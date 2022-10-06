package com.biblos.worker;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.biblos.adapter.RoleAdapter;
import com.biblos.adapter.UserAdapter;
import com.biblos.adapter.impl.RoleAdapterImpl;
import com.biblos.adapter.impl.UserAdapterImpl;
import com.biblos.bo.impl.PermisosBOImpl;
import com.biblos.loader.AuthorizationPropertiesLoader;
import com.dotmarketing.business.Role;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.business.RoleAPIImpl;
import com.dotmarketing.common.db.DotConnect;
import com.dotmarketing.util.Logger;
import com.liferay.portal.model.User;

import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;
import ar.com.osde.dotcms.framework.resources.OsdeFrameworkServices;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.entities.empleado.PuestoDeTrabajo;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.worker.Worker;

public class ActualizarUsuarioPermisos implements Worker {
	/**
	 *  Nombre que tiene la variable del Rol Padre de Validadores, definido en la properties
	 */
	private static final String OSDE_PARENT_ROLE_VALIDATOR = "validatorParentRole";

	private static String parentRoleValidatorName;
	
	private static String wfwAdmGralRole;
	
	private static String sisProAdm;
	
	private UsuarioDTO usuarioDTO;
	private OsdeSecurityExternalService osdeSecurityService;
	private UserAdapter userAdapter = new UserAdapterImpl();
	private RoleAdapter roleAdapter = new RoleAdapterImpl();
	private RoleAPI roleApi = new RoleAPIImpl();
	
	private Map<String, Role> roleMap = null;
	
	public ActualizarUsuarioPermisos() {

		try {
			
			Properties properties = AuthorizationPropertiesLoader.loadAllProperties();
			parentRoleValidatorName = AuthorizationPropertiesLoader.getProperty(properties, OSDE_PARENT_ROLE_VALIDATOR);
			wfwAdmGralRole = AuthorizationPropertiesLoader.getProperty(properties, "wfwAdminGral.role");
			sisProAdm = AuthorizationPropertiesLoader.getProperty(properties, "admin.role");
			
		} catch(Exception ex) {
			Logger.error(PermisosBOImpl.class, "::: "+ ex.getMessage() +" :::", ex);
		}
	}

	@Override
	public void work() {
			
			try {
				
				Usuario usuarioIntranet =  employeeToUserTransformer(this.getOsdeSecurityService().getEmployeeHasRetries(usuarioDTO));
				
				if(usuarioIntranet == null) {
					Logger.info(this, "El usuario : " + usuarioDTO.getUsername() + " no sera sincronizado debido a que no se pudo obtener los datos del servicio empleado");					
					persistirBitacoraSincronizacion("ERROR. Empleado service", usuarioDTO.getUsername());
				} else {
					User usuarioBiblos = this.getUserAdapter().updateUserOrCreate(usuarioIntranet);
					
					if (usuarioBiblos !=null) {
						// limpio los permisos asignados, antes de asignar los nuevos
						if(!this.getRoleAdapter().removeAllRolesFromUser(usuarioBiblos))
							persistirBitacoraSincronizacion("ERROR. Removiendo roles", usuarioBiblos.getUserId());
						
						List<Permission> permisos = this.getOsdeSecurityService().getPermisosDeUsuario(usuarioIntranet.getUsername());
						HashSet<String> permisosAsigignados = new HashSet<String>();
						HashSet<Role> rolesAsignados = new HashSet<Role>();
						
						for (Permission permiso : permisos) {
				    					
							// Mismo codigo en plugin commons LoginAdapterImpl.
							if(permisosAsigignados.contains(permiso.getCode()))continue;
							if(permiso.getCode()==null)continue;				
							
							// Se chequea si el rol a crear es un permiso standar o es un permiso validador,
							// y en base a eso redefino el rol padre
							if (permiso.getCode()!=null && permiso.getCode().toUpperCase().contains(parentRoleValidatorName.toUpperCase())) {
								this.getRoleAdapter().loadParentRole(parentRoleValidatorName);
							} else {
								this.getRoleAdapter().loadParentRole();
							}			
							
							if (permiso.getCode().equals(sisProAdm)) {
													
								Role permisoBackEnd = roleApi.loadBackEndUserRole();
								Logger.info(this, "Carga permiso BackEnd: " + permisoBackEnd.getName());
								rolesAsignados.add(permisoBackEnd);
								permisosAsigignados.add(Role.DOTCMS_BACK_END_USER);
							}
							
							Role permisoBiblos = getRole(permiso.getCode(), permiso.getDescription());
						
							rolesAsignados.add(permisoBiblos);
							permisosAsigignados.add(permiso.getCode());
						}
						
						Role permisoFrontEnd = roleApi.loadFrontEndUserRole();
						Logger.info(this, "Carga permiso FrontEnd: " + permisoFrontEnd.getName());
						rolesAsignados.add(permisoFrontEnd);
						permisosAsigignados.add(Role.DOTCMS_FRONT_END_USER);
						
						if(this.getRoleAdapter().updateRolesFromUser( rolesAsignados, usuarioBiblos )) 
							persistirBitacoraSincronizacion("OK", usuarioBiblos.getUserId());
						else 
							persistirBitacoraSincronizacion("ERROR. Actualizando roles", usuarioBiblos.getUserId());
					}
					
										
				}						
				
			} catch (Exception e) {
				this.doLog("El usuario " + usuarioDTO.getUsername() + " no se pudo crear", true, e);
				Logger.error(PermisosBOImpl.class, "::: "+ e.getMessage() +" :::", e);
				persistirBitacoraSincronizacion("ERROR.", usuarioDTO.getUsername());
			}
			
		}
	
	private void persistirBitacoraSincronizacion(String estado, String userId) {
		try {
			DotConnect dbConnection = new DotConnect();
			
			StringBuilder sql = new StringBuilder("INSERT into bitacora_sincronizacion (userId, estado, fecha_ejecucion ) values ('" + userId + "', '" + estado + "', GETDATE()) WHERE userId = "+ userId);	
			dbConnection.executeStatement(sql.toString());
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	/**
	 * transformer Employee to User binding the metadata
	 */
	private Usuario employeeToUserTransformer(Empleado empleado ) {
		
		if(empleado == null) return null;
		
		Usuario usuario = new Usuario();
		//FIXME why we have cases that employee hasn't names, we should just get name
		usuario.setNombres((empleado.getNombres() == null ? empleado.getNombre() : empleado.getNombres()));		
		usuario.setApellidos(empleado.getApellidos());
		usuario.setBaja((empleado.getBaja()==1 ? true : false));
		usuario.setEmail(empleado.getEmail());
		usuario.setUsername(empleado.getNombreUsuario());
		if(empleado.getPuestosDeTrabajo() !=null && empleado.getPuestosDeTrabajo().getList() !=null && empleado.getPuestosDeTrabajo().getList().length>0) {
			Puesto puestos[] = new Puesto[empleado.getPuestosDeTrabajo().getList().length];
			
			for (int i = 0; i<empleado.getPuestosDeTrabajo().getList().length;i++) {
				Object object = empleado.getPuestosDeTrabajo().getList()[i];
				if(object instanceof PuestoDeTrabajo) {
					Empresa empresa = new Empresa();
					empresa.setDescripcion(((PuestoDeTrabajo)object).getRutaCompleta()); //((PuestoDeTrabajo)object).getDescripcion()
					empresa.setCodigo(String.valueOf(((PuestoDeTrabajo)object).getEmpreNro()));
					
					Filial filial = new Filial();
					filial.setDescripcion(((PuestoDeTrabajo)object).getDescripcionFilial());
					filial.setEmpresa(empresa);
					
					Cap cap = new Cap();
					cap.setDescripcion(((PuestoDeTrabajo)object).getDescripionCAP());
					cap.setEmpresa(empresa);
					
					Puesto puesto = new Puesto();
					puesto.setFilial(filial);
					puesto.setDescripcion(((PuestoDeTrabajo)object).getDescripcion());
					puesto.setCap(cap);
					
					puestos[i] = puesto;
					usuario.setPuestos(puestos);
				}
			}
		}
		
		return usuario;
	}
	
	private Role getRole( String codigo, String desc ) throws UnsupportedEncodingException {
		codigo = new String(codigo.getBytes("ISO-8859-1"), "UTF-8");
		desc = new String(desc.getBytes("ISO-8859-1"), "UTF-8");
		
		if( roleMap == null ) {
			roleMap = new HashMap<String, Role>();
		}
		
		Role permiso = roleMap.get(codigo);
		
		if( permiso == null ) {
			Logger.info(this, "Carga permiso: " + codigo);
			permiso = this.getRoleAdapter().getRoleFromPermissionOrCreate(codigo, desc);
			roleMap.put(codigo, permiso);
		}
		
		return permiso;
	}
	
	private void doLog(String message, boolean error, Throwable e) {
        if (error) {
        	Logger.error(PermisosBOImpl.class, "::: "+ message +" :::", e);
        } else {
        	Logger.info(PermisosBOImpl.class, "::: "+ message +" :::");
        }
    }
	
	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	public void releaseResources() {
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	public OsdeSecurityExternalService getOsdeSecurityService() {
		if (osdeSecurityService==null) {
			this.setOsdeSecurityService(OsdeFrameworkServices.OsdeSecurityExternalService());
		}
		
		return osdeSecurityService;
	}

	public void setOsdeSecurityService(OsdeSecurityExternalService osdeSecurityService) {
		this.osdeSecurityService = osdeSecurityService;
	}
	
	public UserAdapter getUserAdapter() {
		return userAdapter;
	}
	
	public RoleAdapter getRoleAdapter() {
		return roleAdapter;
	}

	
	

}
