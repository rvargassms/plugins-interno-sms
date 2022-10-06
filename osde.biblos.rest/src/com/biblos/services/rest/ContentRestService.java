package com.biblos.services.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.dotcms.rest.WebResource;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.util.Logger;
import com.liferay.portal.model.User;

/**
 * @author Emanuel Testa
 *
 */
@Path("/contentRestService")
public class ContentRestService extends WebResource {
	
	@POST
	@Path("/obtenerDatosDeContenido")
	@Produces(MediaType.APPLICATION_JSON)
	public String obtenerDatosDeContenido(@Context HttpServletRequest request, @Context HttpServletResponse response, @FormParam("idsArray") String rawData) {
		User systemUser;
		JsonArray dataJSON = new JsonArray();
		try {
			systemUser = APILocator.getUserAPI().getSystemUser();
			String[] ids = rawData.split("/");
			for (String id : ids) {
				JsonObject dJson = new JsonObject();
				Contentlet contentlet = APILocator.getContentletAPI().findContentletByIdentifier(id, true, 1, systemUser, false);
				dJson.addProperty("id", id);
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
				String fMod = DATE_FORMAT.format(contentlet.getModDate());
				dJson.addProperty("fechaMod", fMod);
				dataJSON.add(dJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataJSON.toString();		
	}
	
}
