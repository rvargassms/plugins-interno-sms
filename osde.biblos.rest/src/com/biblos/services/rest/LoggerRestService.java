/*
 * Flux IT Argentina
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Martin Zanotti
 * Date:  15/2/2015 - 11:21:47
 */
package com.biblos.services.rest;


import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.util.ajax.JSON;

import com.biblos.commons.CustomDBParametersLoader;
import com.biblos.entities.ClickEntity;
import com.biblos.reportes.ReporteClicks;
import com.google.gson.JsonParser;
import com.dotmarketing.portlets.workflows.URLUtils;
import com.dotmarketing.util.Logger;
import com.google.gson.JsonObject;


/**
 * @author Martin Zanotti
 */
@Path("/loggerRestService")
public class LoggerRestService extends OsdeService {
	
	@POST
	@Path("/click")
	@Produces(MediaType.TEXT_PLAIN)
	public String click(@Context HttpServletRequest request, @Context HttpServletResponse response, String rawData) {
		JsonObject 	jsonResponse = new JsonObject();
		try{
			
			JsonObject 	data = (new JsonParser()).parse(rawData).getAsJsonObject();
			HashMap<String, Object> map = this.getAsHashMap(data);

			ReporteClicks.generarReporteClick(this.armarEntityClick(map));

			jsonResponse.addProperty("status","ok");
			return jsonResponse.toString();
				
		}catch(Exception e){
			Logger.error(this, ":::		 "+e.getMessage()+" 	   :::", e);
			jsonResponse.addProperty("status","error");
			jsonResponse.addProperty("error",e.getMessage());
			return jsonResponse.toString();
		}
	}
	
		/**
	 * Genera la entity de click a guardar...
	 * 
	 * @return
		 * @throws Exception 
	 */
	private ClickEntity armarEntityClick(HashMap<String, Object> params) throws Exception {
		URL url = URLUtils.decodeURL((String) params.get("url"));
				
		ClickEntity clickEntity = null;
		clickEntity = new ClickEntity();
		clickEntity.setUsuarioMT((String) params.get("usuarioMT"));
		clickEntity.setUsuarioNombre((String) params.get("usuarioNombre"));
		clickEntity.setHost((String) params.get("host"));
		clickEntity.setUrl(URLUtils.getURLWithoutFragment(url));
		clickEntity.setSolapa((String) params.get("tab"));
		clickEntity.setUsoBuscador(Boolean.parseBoolean((String) params.get("usoBuscador")));

		String parentPath = URLUtils.getURLParenthPath(url);
		String assetName = URLUtils.getURLAssetName(url);
		String query = "select * from identifier where parent_path = ? and asset_name = ?";
		
		clickEntity.setIdPagina(CustomDBParametersLoader.getField(query, "id", String.class, parentPath, assetName));

		return clickEntity;
	}
}
