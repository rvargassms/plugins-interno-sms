package com.biblos.bo.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.dotmarketing.business.Role;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.business.RoleAPIImpl;
import com.dotmarketing.business.UserAPI;
import com.dotmarketing.business.UserAPIImpl;
import com.dotmarketing.db.DbConnectionFactory;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.util.Logger;
import com.dotmarketing.util.Mailer;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PropsUtil;
//import com.mysql.jdbc.Connection;
import com.biblos.adapter.RoleAdapter;
import com.biblos.adapter.UserAdapter;
import com.biblos.adapter.impl.RoleAdapterImpl;
import com.biblos.adapter.impl.UserAdapterImpl;
import com.biblos.bo.PermisosBO;
import com.dotmarketing.common.db.DotConnect;
//import com.plugins.osde.dotCMS.security.PropertiesLoader;

import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
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
import ar.com.osde.worker.RunnableWorker;
import ar.com.osde.worker.pool.RunnableWorkerPool;

import com.biblos.enums.EnumRoleKey;
import com.biblos.loader.AuthorizationPropertiesLoader;
import com.biblos.worker.ActualizarUsuarioPermisos;

public class PermisosBOImpl implements PermisosBO {
	
	private UserAPI uapi;
	private UserAdapter userAdapter = new UserAdapterImpl();
	private OsdeSecurityExternalService osdeSecurityService;
	private int usersTotal;
	

	public PermisosBOImpl() {
		super();
	}
	
	public synchronized void sincronizarPermisos() {
		this.doLog("INICIO de sincronizacion de permisos en Biblos", false, null);
   
		//guarda inicio de sincro en variable para pasarlo a consulta
		DateTimeFormatter fechaActualSincro = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");		
        this.doLog("Horario de inicio sincro: "+ fechaActualSincro.format(LocalDateTime.now()), false, null);	        
		    			
		try {
			long start = System.currentTimeMillis();

			PermisosDTO permisos = this.getOsdeSecurityService().getPermisoDTO("GRGDOTCMS-INGINTRA-VIS");			

			usersTotal = permisos.getPermiso().getUsuariosDTO().getUsuarios().size();
			
			this.doLog("Cantidad de usuarios a sincronizar = " + usersTotal, false, null);				
			
			String poolKey = ActualizarUsuarioPermisos.class.getName();
			
			for(UsuarioDTO usuario: permisos.getPermiso().getUsuariosDTO().getUsuarios()) {
				this.persistirUserBitacora(usuario.getUsername());
			}
			
			for (UsuarioDTO usuario: permisos.getPermiso().getUsuariosDTO().getUsuarios()) {
				
				RunnableWorker runnableWorker = (RunnableWorker) RunnableWorkerPool.getInstance().getObject( poolKey );
				
				ActualizarUsuarioPermisos worker = (ActualizarUsuarioPermisos) runnableWorker.getWorker();
				
				worker.setUsuarioDTO(usuario);
				runnableWorker.wakeUp();
				
			}
			
			try {

				synchronized (this) {

					do {

						this.wait(500);

					} while (RunnableWorkerPool.getInstance().getPool().getNumActive(poolKey) != 0);
				}
			} catch (InterruptedException e) {
			}
						
			this.depurarUsuariosDotCms(fechaActualSincro);
			
			long end = System.currentTimeMillis();
			 
			Logger.info(this, "Tiempo total " + (end - start) + " ms");
			Logger.info(this, "Tiempo medio " + ((end-start)/permisos.getPermiso().getUsuariosDTO().getUsuarios().size()) + " ms");

			this.doLog("FIN de sincronizacion de permisos en Biblos", false, null);
		} catch (Exception e) {
			this.doLog(e.getMessage(), true, e);
			Logger.error(PermisosBOImpl.class, "::: "+ e.getMessage() +" :::", e);
		}
	}
		
	private void depurarUsuariosDotCms(DateTimeFormatter fechaSincro) throws Exception {	
		DotConnect dbConnection = new DotConnect();

		try {			
			
			StringBuilder sqlBitacoraCount = new StringBuilder();
			
			sqlBitacoraCount.append("SELECT COUNT(*) FROM bitacora_sincronizacion bs WHERE bs.fecha_ejecucion > '");
			sqlBitacoraCount.append(fechaSincro);		
			
			
			dbConnection.setSQL(sqlBitacoraCount.toString());
			ArrayList<Map<String, Object>> countUserSincronizacion = dbConnection.loadResults();
			int totalUserSincronizacion = Integer.parseInt((String) countUserSincronizacion.get(0).get(""));
			
			String mensajeError;
			
			if(totalUserSincronizacion == 0) {
				mensajeError = "No se pudo obtener la lista de usuarios sincronizados";				
				Logger.error(PermisosBOImpl.class, mensajeError);
				throw new Exception(mensajeError); 
			} else if(totalUserSincronizacion != usersTotal) {
				mensajeError = "Conflicto. La cantidad de usuarios a sincronizar no es igual a la lista de usuarios del proceso de sincronización";
				Logger.error(PermisosBOImpl.class, mensajeError);
				throw new Exception(mensajeError); 
			}				
			
			
			StringBuilder sqlBitacora = new StringBuilder();
			
			sqlBitacora.append("SELECT userId FROM bitacora_sincronizacion bs WHERE bs.fecha_ejecucion > '");
			sqlBitacora.append(fechaSincro);
			sqlBitacora.append("' AND bs.estado != 'Eliminado'");
			
			
			StringBuilder sqlUserToDelete = new StringBuilder();
				sqlUserToDelete.append("SELECT u.userId FROM User_ u WHERE u.userId NOT IN (");
				sqlUserToDelete.append(sqlBitacora);
				sqlUserToDelete.append(") AND u.userId NOT IN (SELECT userId FROM User_Excluidos_Eliminacion uee)");
				
			dbConnection.setSQL(sqlUserToDelete.toString());	
			
			ArrayList<Map<String, Object>> usersMap = dbConnection.loadResults();
			ArrayList<String> usersList = new ArrayList<String>();
			
				for (int i=0; i < usersMap.size(); i++) {
					usersList.add((String) usersMap.get(i).get("userid"));
				}
				
			Logger.info(this, "Cantidad de usuarios a eliminarse en la depuracion " + usersList.size());
			
			userAdapter.eliminateUserAndAllConstraintDataRelatedArrayString(usersList, dbConnection);			

		} catch (DotDataException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		} 
	}
	//se cambio user_sincronizacion por bitacora_sincro, se persiste uid en bitacora
	private void persistirUserBitacora(String userId) {
		try {
			DotConnect dbConnection = new DotConnect();
			
			StringBuilder sql = new StringBuilder("INSERT into bitacora_sincronizacion (userId, fecha_ejecucion) values ('" + userId + "', GETDATE())");	
			dbConnection.executeStatement(sql.toString());
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	private void doLog(String message, boolean error, Throwable e) {
        if (error) {
        	Logger.error(PermisosBOImpl.class, "::: "+ message +" :::", e);
        } else {
        	Logger.info(PermisosBOImpl.class, "::: "+ message +" :::");
        }
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

	@Override
	public boolean actualizarPermisos(UsuarioDTO usuarioDTO) throws Exception {
		ActualizarUsuarioPermisos worker = new ActualizarUsuarioPermisos();
		worker.setUsuarioDTO(usuarioDTO);
		worker.work();
		return false;
	}
}