package ar.com.osde.dotcms.backend.dao.impl;

import ar.com.osde.dotcms.backend.dao.OsdeSecurityDAO;
import ar.com.osde.dotcms.backend.dtos.PermisoConcretoDTO;
import ar.com.osde.dotcms.backend.dtos.PermisosConcretosDTO;
import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.backend.services.UsuariosDePermisosServiceExtension;
import ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.entities.empleado.PuestoDeTrabajo;
import ar.com.osde.framework.business.intranet.IntranetSecurityBO;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.service.intranet.impl.SeguridadPF;
import ar.com.osde.services.administracion.empleado.intranet.usuario.Empleado_ServiceLocator;

import com.dotmarketing.util.Logger;
import org.dozer.Mapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.rpc.ServiceException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ss94848846
 */
public class OsdeSecurityDAOImpl implements OsdeSecurityDAO {

    private UsuariosDePermisosServiceExtension obtenerUsuariosService;
    private SeguridadPF obtenerPermisosService;
    private IntranetSecurityBO securityIntranet;
    private Mapper mapper;
    
    @Deprecated
    private Usuario_ServiceLocator usuarioServiceESB;
    
    private Empleado_ServiceLocator employeeServiceESB;

    /**
     * Obtener detalles del permiso (incluso lista de usuarios)
     *
     * @param permiso
     * @return
     */
    @Override
    public PermisosDTO getPermisoDTO(String permiso) {
        String usuariosString = this.getObtenerUsuariosService().obtenerUsuarios("<permisos><permiso>" + permiso + "</permiso></permisos>");
        Logger.info(this, ">>> XML usuariosString = " + usuariosString);

        PermisosDTO permisosDTO = new PermisosDTO();

        try {
            InputStream is = new ByteArrayInputStream(usuariosString.getBytes());
            JAXBContext jaxbContext = JAXBContext.newInstance(PermisosDTO.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            permisosDTO = (PermisosDTO) jaxbUnmarshaller.unmarshal(is);

        } catch (JAXBException e) {
            Logger.error(this, e.getMessage(), e);
        }

        return permisosDTO;
    }

    public Empleado getEmployeeHasRetries(UsuarioDTO user) {
        for( int i = 1; i <= 3; i++){
            try {
            	Logger.info(this, i + ". Intentando obtener los datos del empleado " + user.getUsername());
                return this.employeeServiceESB.getEmpleadoServicePort().getEmpleadoByUsername(user.getUsername());
            } catch (Exception e) {
                Logger.error(this, e.getMessage() + " " + user.getUsername());
                try{
                    Thread.sleep(3000L);
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @deprecated
     * Obtener usuario teniendo en cuenta los fallos de los requests a la intranet
     *
     * @param user
     * @return
     */
    @Override
    public Usuario getUserConReintentos(UsuarioDTO user) {

        for( int i = 0; i< 3; i++){
            try {
                return this.usuarioServiceESB.getUsuarioHttpPort().obtenerDatosPersonales(user.getUsername());
            } catch (Exception e) {
                Logger.error(this, "Reintentando obtener usuario" + user.getUsername());
                try{
                    Thread.sleep(3000L);
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Recupera todos los permisos que tiene un determinado usuario para un aplicación específica pasada por parámetro
     *
     * @param usuarioIntranet
     * @param applicationName
     * @return
     */
    @Override
    public List<Permission> getPermisosDeUsuario(String usuarioIntranet, String applicationName) {

        String permisosString = this.getObtenerPermisosService().obtenerPermisosConUsuario(applicationName, usuarioIntranet);

        PermisosConcretosDTO permisosConcretosDTO = new PermisosConcretosDTO();

        try{
            InputStream is = new ByteArrayInputStream(permisosString.getBytes());
            JAXBContext jaxbContext = JAXBContext.newInstance(PermisosConcretosDTO.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            permisosConcretosDTO = (PermisosConcretosDTO) jaxbUnmarshaller.unmarshal(is);
        }catch (JAXBException e){
            Logger.error(this, e.getMessage(), e);
        }

        return this.mappearPermission(permisosConcretosDTO.getSeguridadPFDTO());
    }

    /**
     * Mapea los datos del usuario que contiene PermisosDTO a UserIntranet
     * @param permisosDTO
     * @return
     */
    private List<Usuario> mappearUsuariosIntranet(PermisosDTO permisosDTO){
        List<Usuario> usuariosESB = new ArrayList<Usuario>();

        for (UsuarioDTO usuarioDTO : permisosDTO.getPermiso().getUsuariosDTO().getUsuarios()){

            Logger.info(this, "Apellido, Nombre - Username del usuario obtenido: " + usuarioDTO.getApellido() + ", " + usuarioDTO.getNombre() + " - " + usuarioDTO.getUsername());

            /**
             * Intentamos 3 veces obtener los datos del usuario
             */
            int count = 0;
            boolean success = false;
            do {
                count++;

                try{
                    Usuario userESB = getUserByMT(usuarioDTO.getUsername());
                    usuariosESB.add(userESB);
                    success = true;
                }catch( Exception e){
                    Logger.error(this, "Reintentando obtener usuario " + usuarioDTO.getUsername());
                    try{
                        /**
                         * Esperamos 3 segundos para volver a intentar a obtener el usuario de la intra con el ID
                         */
                        Thread.sleep(3000L);
                    }catch (InterruptedException e1){
                        e1.printStackTrace();
                    }
                }


            }while(count <= 3 && !success);

            if(!success){
                // @TODO Revisar esta funcionalidad. Deberíamos crear uno nuevo si no podemos obtener el usuario desde la intra?
            }
        }

        return usuariosESB;
    }

    private List<Permission> mappearPermission(List<PermisoConcretoDTO> seguridadPFDTO){
        List<Permission> permisosDelUsuario = new ArrayList<Permission>();

        for (PermisoConcretoDTO permisoConcretoDTO : seguridadPFDTO){
            Logger.info(this, "Permiso obtenido: " + permisoConcretoDTO.getPermiso());
            Permission permission = new Permission();
            permission.setCode(permisoConcretoDTO.getPermiso());
            permission.setName(permisoConcretoDTO.getNombre());
            permission.setDescription(permisoConcretoDTO.getDescripcion());
            permisosDelUsuario.add(permission);
        }
        Logger.info(this, "Se terminó de cargar los permisos para el usuario");
        return permisosDelUsuario;
    }

    /**
     * Recupera el usuario y sus datos personales del servicio del ESB usando el username en la intranet
     *
     * @param idIntranet
     * @return
     */
    @Override
    public Usuario getUserByMT(String idIntranet){
        try {
        	System.out.println("id intranet " + idIntranet);
            // FIXME 	Existe un objeto que mapea los datos del usuario que contiene PermisosDTO a UserIntranet, para hacer esto utiliza el método "getUserByMT" que devuelve un objecto Usuario bindeado con muchas propiedades que se utilizan para armar los permisos de intranet/dotcms.
        	//    		Se reemplaza la llamada al method "ObtenerDatosPersonales", http://testesb.osde.ar/services/Usuario/?wsdl
        	//			por el method "getEmpleadoByUsername", http://testesb.osde.ar/services/Empleado
        	return employeeToUserTransformer(this.employeeServiceESB.getEmpleadoServicePort().getEmpleadoByUsername(idIntranet));
        } catch (RemoteException e) {
            Logger.error(this, e.getMessage());
        } catch (ServiceException e) {
            Logger.error(this, e.getMessage());
        }
        return null;
    }

    /**
     * Recupera el usuario y sus datos personales del servicio del ESB usando el dni del usuario
     *
     * @param dni
     * @return
     */
    @Override
    public Usuario getUserByDNI(String dni) {

        try {
            return employeeToUserTransformer(this.employeeServiceESB.getEmpleadoServicePort().getEmpleadoByUsername(dni));
        }  catch (RemoteException e) {
            Logger.error(this, e.getMessage());
        } catch (ServiceException e) {
            Logger.error(this, e.getMessage());
        }
        return null;
    }

    public void setObtenerUsuariosService(UsuariosDePermisosServiceExtension obtenerUsuariosService) {
        this.obtenerUsuariosService = obtenerUsuariosService;
    }

    /**
     * Recupera todos los usuarios que tengan el permiso pasado
     *
     * @param permiso
     * @return
     */
    @Override
    public List<Usuario> getUsuariosConPermiso(String permiso) {
        PermisosDTO permisosDTO = getPermisoDTO(permiso);
        return mappearUsuariosIntranet(permisosDTO);
    }

	/**
	 * transformer Employee to User binding the metadata
	 */
	private Usuario employeeToUserTransformer(Empleado empleado ) {
		Usuario usuario = new Usuario();
		//usuario.setId(Integer.getInteger(empleado.getIdEmpleado()));
		usuario.setNombres(empleado.getNombres());		
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
	
	public String getFilesUploadPath() {
		return this.obtenerUsuariosService.getFilesUploadPath();
	}

    
    public UsuariosDePermisosServiceExtension getObtenerUsuariosService() {
        return obtenerUsuariosService;
    }

    public SeguridadPF getObtenerPermisosService(){
        return obtenerPermisosService;
    }

    public void setObtenerPermisosService(SeguridadPF obtenerPermisosService) {
        this.obtenerPermisosService = obtenerPermisosService;
    }

    public void setSecurityIntranet(IntranetSecurityBO securityIntranet) {
        this.securityIntranet = securityIntranet;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    //public void setUsuarioServiceESB(Usuario_ServiceLocator usuarioServiceESB) {
    //    this.usuarioServiceESB = usuarioServiceESB;
    //}
    
    public void setEmployeeServiceESB(Empleado_ServiceLocator employeeServiceESB) {
        this.employeeServiceESB = employeeServiceESB;
    }
}
