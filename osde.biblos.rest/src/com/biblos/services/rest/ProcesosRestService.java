
package com.biblos.services.rest;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dotmarketing.util.Logger;
import com.biblos.content.ContentSingleton;
import com.biblos.content.bo.ContentBO;
import com.biblos.services.rest.OsdeService;

/**
 * Servicio REST para ejecutar procesos custom en el administrador 
 * 
 */
@Path("/procesosRestService")
public class ProcesosRestService extends OsdeService {
		
	private static final String OK = "OK";
	private static final String EN_PROCESO = "EN PROCESO";
	
	@POST
	@Path("/desbloquearContenidos")
	@Produces (MediaType.APPLICATION_JSON)
	public String desbloquearContenidos(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		ContentSingleton.instance().getContentBO().desbloquearContenido();
		return OK;
	}
}
