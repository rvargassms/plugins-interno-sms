package com.biblos.services.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.dotcms.rest.WebResource;
import com.dotmarketing.util.Logger;
import com.dotcms.rest.InitDataObject;
import com.dotcms.rest.ResourceResponse;
import com.dotmarketing.util.json.JSONException;
import com.biblos.loader.ProccessSpringContextLoader;
import com.biblos.bo.PermisosBO;
import com.biblos.bo.impl.PermisosBOImpl;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;


@Path("/permisosRestService")
public class PermisosRestService extends OsdeService {
	
	/**
	 * URL Examples
     * http://dotcmsd.intranet.osde:9080/api/permisosRestService/ejecutarSincronizarPermisos/
     * 
	 * @param request
	 * @param params
	 * @return JSON
	 * @throws JSONException
	 */
	@POST
	@Path("/ejecutarSincronizarPermisos")
	@Produces (MediaType.APPLICATION_JSON)
	public String ejecutarSincronizarPermisos(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		PermisosBO pm = new PermisosBOImpl();
		pm.sincronizarPermisos();
		return "OK";
	}
	
	/**
	 * Endpoint para ejecutar la sincronización de un solo usuario a través del parámetro 
     * 
     * 
	 * @param request
	 * @param params
	 * @return JSON
	 * @throws JSONException
	 */
	@POST
	@Path("/ejecutarSincronizarUsuario")
	@Produces (MediaType.APPLICATION_JSON)
	public String ejecutarSincronizarUsuario(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		String resp = null;
		String username = request.getParameter("username");		
		UsuarioDTO user = new UsuarioDTO();
		user.setUsername(username);
		
		PermisosBO pm = new PermisosBOImpl();
		
		try {
			if(pm.actualizarPermisos(user))
				resp = "OK";			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return resp;
	}
	
}
