package com.biblos.services.rest;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.PermissionAPI;
import com.dotmarketing.portlets.containers.business.ContainerAPI;
import com.dotmarketing.portlets.containers.model.Container;
import com.dotmarketing.portlets.contentlet.business.HostAPI;
import com.dotmarketing.util.Logger;
import com.dotmarketing.util.json.JSONArray;
import com.dotmarketing.util.json.JSONObject;
import com.liferay.portal.model.User;
import com.biblos.content.ContentConfiguration;
import com.biblos.utils.CookieUtil;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * Servicio REST para permisos de host 
 * 
 * @author Guido Celada
 *
 */
@Path("/hostsPermissionsRestService")
public class HostPermissionsRestService extends OsdeService {
	private static HostAPI hostAPI = APILocator.getHostAPI();
	private static ContainerAPI containerAPI = APILocator.getContainerAPI();
	
	@GET
	@Path("/hostsForUser")
	@Produces (MediaType.APPLICATION_JSON)
	public String getHostsForUser(@Context HttpServletRequest request) {
		//Obtener usuario logeado desde el request
		User user;
		try {
		    CookieUtil cookieUtil = new CookieUtil();
		    cookieUtil.obtenerUsernameClave(request);
		    Logger.info(HostPermissionsRestService.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
			String username = cookieUtil.getUsername();
			user = APILocator.getUserAPI().loadUserById(username);
		} catch (Exception e) {
			Logger.error(HostPermissionsRestService.class, "Error al obtener el usuario logeado", e);
			return null;
		}
		//Obtener los hosts con permiso de lectura para ese usuario
		List<Host> hosts;
		try {
			hosts = hostAPI.getHostsWithPermission(PermissionAPI.PERMISSION_READ, user, true);
		} catch (Exception e) {
			Logger.error(HostPermissionsRestService.class, "Error al obtener los hosts con permiso de lectura para el usuario logeado", e);
			return null;
		}
		
		//Obtener aliases de los hosts
		JSONArray hostsAliases = new JSONArray();
		for (Host host : hosts) {
			String alias = host.getAliases();
			try {
				if (host.isArchived() || !host.isLive() || alias == null || alias.isEmpty())
					continue;
			} catch (Exception e) {
				Logger.error(HostPermissionsRestService.class, "Error en el servicio REST de hosts", e);
				return null;
			} 
			
			JSONObject hostJSON = new JSONObject();			
			try {
				int t = request.getServerPort();
				hostJSON.put("url", request.getScheme() +"://"+alias+":"+request.getServerPort());
				hostJSON.put("name", host.getStringProperty("description"));
				hostJSON.put("alias", host.getAliases());
				hostJSON.put("hostname", host.getHostname());
				hostJSON.put("isDefault", host.isDefault());
			} catch (Exception e) {
				Logger.error(HostPermissionsRestService.class, "Error al generar el JSON respuesta", e);
				return null;
			}
			hostsAliases.add(hostJSON);
		}
		
		return hostsAliases.toString();
	}
	
	@GET
	@Path("/containersForUser")
	@Produces (MediaType.APPLICATION_JSON)
	public String getContainersForUser(@Context HttpServletRequest request) {
		JsonObject response = new JsonObject();
		
		//Obtener usuario logeado desde el request
		User user;
		try {
		    CookieUtil cookieUtil = new CookieUtil();
		    cookieUtil.obtenerUsernameClave(request);
		    Logger.info(HostPermissionsRestService.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
			String username = cookieUtil.getUsername();
			user = APILocator.getUserAPI().loadUserById(username);
		} catch (Exception e) {
			Logger.error(HostPermissionsRestService.class, "Error al obtener el usuario logeado", e);
			return null;
		}
		
		//Obtener host con acceso y containers
		try {
			JsonArray  hostsJSON = new JsonArray();
			List<Host> hosts = hostAPI.getHostsWithPermission(PermissionAPI.PERMISSION_READ, user, true);
			
			//HashSet<String> enabledHosts = new HashSet<String>();
			//enabledHosts.addAll(Arrays.asList(ContentConfiguration.getProperties().getProperty("hosts").split(",")));
			
			for(Host host: hosts){
				//if(!enabledHosts.contains(host.getHostname())) continue;
				
				String alias = host.getAliases();
				if(host.isArchived() || !host.isLive() || alias == null || alias.isEmpty()) continue;
				List<Container> containers = containerAPI.findContainersUnder(host);
				JsonArray  containersJSON = new JsonArray();
				for(Container c: containers){
					JsonObject cJson = new JsonObject();
					cJson.addProperty("id",c.getIdentifier());
					cJson.addProperty("name",(String) c.getMap().get("friendlyName"));
					cJson.addProperty("metadata",c.getNotes());
					containersJSON.add(cJson);
				}
				JsonObject hostJSON = new JsonObject();	
				hostJSON.addProperty("id", host.getHostname());
				hostJSON.addProperty("name", host.getStringProperty("description"));
				hostJSON.addProperty("metadata", host.getStringProperty("keywords"));
				hostJSON.addProperty("alias", host.getAliases());
				hostJSON.add("containers",containersJSON);
				
				hostsJSON.add(hostJSON);	
			}
			response.add("hosts",hostsJSON);
			
		} catch (Exception e) {
			Logger.error(HostPermissionsRestService.class, "Error al cargar containers para el usuario", e);
			response.addProperty("error",e.getMessage());
		}
		return response.toString();
	}

}
