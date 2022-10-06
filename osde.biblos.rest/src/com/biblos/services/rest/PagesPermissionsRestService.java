/*
 * Flux IT Argentina
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Guido Celada
 * Date:  12/8/2015 
 */
package com.biblos.services.rest;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.biblos.utils.CookieUtil;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;
import com.dotmarketing.portlets.contentlet.business.HostAPI;
import com.dotmarketing.portlets.folders.business.FolderAPI;
import com.dotmarketing.portlets.folders.model.Folder;
import com.dotmarketing.portlets.htmlpageasset.business.HTMLPageAssetAPI;
import com.dotmarketing.portlets.htmlpageasset.model.IHTMLPage;
import com.dotmarketing.util.Logger;
import com.liferay.portal.model.User;

/**
 * Servicio REST para permisos de host 
 * 
 * @author Guido Celada
 */
@Path("/pagesPermissionsRestService")
public class PagesPermissionsRestService extends OsdeService {
		
	private static HostAPI hostAPI = APILocator.getHostAPI();
	private static ContentletAPI contentletAPI = APILocator.getContentletAPI();
	private static HTMLPageAssetAPI htmlPageAssetAPI = APILocator.getHTMLPageAssetAPI();
	private static FolderAPI folderAPI = APILocator.getFolderAPI();
	private List<IHTMLPage> pages = null;
	
	@POST
	@Path("/pagesForUser")
	@Produces (MediaType.APPLICATION_JSON)
	public String getPagesForUser(@Context HttpServletRequest request, @Context HttpServletResponse response, @FormParam("jsonQuery") String rawData) {	
		try{					
			JsonObject jsonObj = new JsonObject();
			JsonArray 	jsonResponse = new JsonArray();
		    CookieUtil cookieUtil = new CookieUtil();
		    cookieUtil.obtenerUsernameClave(request);
		    Logger.info(PagesPermissionsRestService.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
			String username = cookieUtil.getUsername();	
			User user = APILocator.getUserAPI().loadUserById(username);					
			
			String urlHost = request.getServerName();		
			
			Host host = this.obtenerHost(urlHost, user);
			
			List<Folder> folders= folderAPI.findSubFoldersRecursively(host, user, false);
			pages = htmlPageAssetAPI.getLiveHTMLPages(host, user, false);
			
			jsonResponse = this.loadPages(pages, jsonResponse);
			
			for(Folder folder: folders) {
				
				pages = htmlPageAssetAPI.getLiveHTMLPages(folder, user, false);
				
				jsonResponse = this.loadPages(pages, jsonResponse);
			}
			
			jsonObj.add("paginas", jsonResponse);
			return jsonObj.toString();
		
		}catch(Exception e){
			Logger.error(this, ":::		 "+e.getMessage()+" 	   :::", e);
			JsonObject jsonResponse = new JsonObject();
			jsonResponse.addProperty("error",e.getMessage()+"test1");
			return jsonResponse.toString();
		}
	}
	
	private JsonArray loadPages(List<IHTMLPage> pages, JsonArray jsonResponse) {
		try {
			for (IHTMLPage page: pages) {
				
				JsonObject 				   jsonObject	   = new JsonObject();
				jsonObject.addProperty("titulovisible", (String) page.getTitle());
				jsonObject.addProperty("uri",  (String) page.getURI());
				jsonObject.addProperty("url",  (String) page.getPageUrl());
				
				jsonResponse.add(jsonObject);
			
			}
			
			return jsonResponse;
		}catch(Exception ex) {
			Logger.error(this, "Error al cargar pagina");
			return jsonResponse;
		}
		
	}
	
	// Se implementa este metodo ya que el metodo hostAPI.findByAlias devuelve un unico host
	private Host obtenerHost(String url, User user) {
		try {
			List<Host>       hosts       = APILocator.getHostAPI().findAll( user, false );			
			
			for(Host host : hosts){
				if (host.getAliases().equals(url)) {
					return host;
				}
			}	
			
		} catch (DotDataException | DotSecurityException e) {
			e.getMessage();
		}
		
		return null;
	}
	
	
}
