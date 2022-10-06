package com.biblos.services.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.dotcms.repackage.org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bouncycastle.asn1.ocsp.Request;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.FactoryLocator;
import com.dotmarketing.business.Role;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.containers.model.Container;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;
import com.dotmarketing.portlets.contentlet.business.DotContentletStateException;
import com.dotmarketing.portlets.contentlet.business.HostAPI;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.htmlpageasset.model.IHTMLPage;
import com.dotmarketing.portlets.workflows.WorkflowUtils;
import com.dotmarketing.portlets.workflows.actionlet.NotifyAssigneeActionlet;
import com.dotmarketing.portlets.workflows.actionlet.NotifyUsersActionlet;
import com.dotmarketing.portlets.workflows.actionlet.WorkFlowActionlet;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import com.dotmarketing.portlets.workflows.model.WorkflowAction;
import com.dotmarketing.portlets.workflows.model.WorkflowActionClass;
import com.dotmarketing.portlets.workflows.model.WorkflowActionClassParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowProcessor;
import com.dotmarketing.portlets.workflows.model.WorkflowStep;
import com.dotmarketing.portlets.workflows.model.WorkflowTask;
import com.dotmarketing.util.DateUtil;
import com.dotmarketing.util.Logger;
import com.dotmarketing.util.Mailer;
import com.liferay.portal.model.User;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;
import ar.com.osde.dotcms.framework.resources.OsdeFrameworkServices;
import ar.com.osde.framework.entities.user.impl.UserIntranet;

import com.biblos.loader.WorkflowProperties;
import com.biblos.util.EmailUtil;
import com.biblos.utils.CookieUtil;

/**
 * @author Emanuel Testa
 *
 */
@Path("/workflowRestService")
public class WorkflowRestService extends OsdeService {
	private final static String MESSAGE_OK = "OK";
	private final static String TASK_ID_LABEL = "TASK_ID_LABEL";
	private static final String IDENTIFICADOR_ADMINISTRACION = "identificadorAdministracin";
	private static final String SOLICITUD_DE_CAMBIO_CREACION_FLAG = "SOLICITUD_DE_CAMBIO_CREACION_FLAG";
	private static final String SOLICITAR_MODIFICACION = "Solicitar Modificacion";
	private static final String SOLICITAR_CREACION = "Solicitar creación de página";
	private static final String PENDIENTE_DE_PUBLICACION = "Pendiente de Publicacion (solicitud)";
	private static OsdeSecurityExternalService osdeSecurityService;
	private static HostAPI hostAPI = APILocator.getHostAPI();
	public static final String HREF_INICIO = "<a href=";
	public static final String HREF_FIN = "</a>";
	public static final String TARGET_BLANK = "target='_blank'";

	@POST
	@Path("/ejecutarWorkflowSolicitudDeCreacion")
	@Produces(MediaType.TEXT_PLAIN)
	public String ejecutarWorkflowSolicitudDeCreacion(@Context HttpServletRequest request, FormDataMultiPart form) {

		Logger.info(this, ":::      Ejecutando Workflow Solicitud De Creacion      :::");

		String returnMessage = "";

		try {
		    CookieUtil cookieUtil = new CookieUtil();
		    cookieUtil.obtenerUsernameClave(request);
		    Logger.info(WorkflowRestService.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
			String username = cookieUtil.getUsername();
			User usuario = APILocator.getUserAPI().loadUserById(username);
			if (usuario == null)
				throw new Exception("Error buscando el usuario logueado, devuelve usuario NULO");
			
			Host defaulthost = hostAPI.findDefaultHost(usuario, false);

			String contentletIdentifier = WorkflowUtils.getCreacionPaginaContentletID();

			String solicitud = form.getField("descripcion") != null ? form.getField("descripcion").getValue() : "";
			String hash = form.getField("hash") != null ? form.getField("hash").getValue() : "";
			String pageTitle = form.getField("pageTitle") != null ? form.getField("pageTitle").getValue() : "";			
			String fileName = form.getField("fileName").getValue();			
			
			String urlAdjunto = request.getScheme() + "://" + defaulthost.getAliases() + ":" + request.getServerPort() + "/";

			File file = extractFile(form, fileName);

			returnMessage = this.iniciarSolicitud(usuario, contentletIdentifier, solicitud, null, urlAdjunto, pageTitle, file, true);

		} catch (Exception e) {
			String error = ExceptionUtils.getStackTrace(e);
			Logger.error(this, error, e);
			return error;
		}

		Logger.info(this, ":::      Finalizado Workflow Solicitud De Creacion      :::");

		return returnMessage;

	}

	@POST
	@Path("/ejecutarWorkflowSolicitudDeCambio")
	@Produces(MediaType.TEXT_PLAIN)
	public String ejecutarWorkflowSolicitudDeCambio(@Context HttpServletRequest request, FormDataMultiPart form) {
		Logger.info(this, ":::      Ejecutando Workflow Solicitud De Cambio      :::");

		String returnMessage = "";

		try {
		    CookieUtil cookieUtil = new CookieUtil();
		    cookieUtil.obtenerUsernameClave(request);
		    Logger.info(WorkflowRestService.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
			String username = cookieUtil.getUsername();
			User usuario = APILocator.getUserAPI().loadUserById(username);
			if (usuario == null)
				throw new Exception("Error buscando el usuario logueado, devuelve usuario NULO");
			
			Host defaulthost = hostAPI.findDefaultHost(usuario, false);

			String countentletIdentifier = form.getField("countentletIdentifier") != null
					? form.getField("countentletIdentifier").getValue()
					: "";
			String solicitud = form.getField("solicitud") != null ? form.getField("solicitud").getValue() : "";
			String solapa = form.getField("solapa") != null ? form.getField("solapa").getValue() : "";
			String hash = form.getField("hash") != null ? form.getField("hash").getValue() : "";
			String pageTitle = form.getField("pageTitle") != null ? form.getField("pageTitle").getValue() : "";
			String fileName = form.getField("fileName").getValue();
			String urlAdjunto = request.getScheme() + "://" + defaulthost.getAliases() + ":" + request.getServerPort() + "/";
			String url = formatearUrl(form.getHeaders().get("referer").toString());
			url = url.concat(solapa);

			File file = extractFile(form, fileName);

			returnMessage = this.iniciarSolicitud(usuario, countentletIdentifier, solicitud, url, urlAdjunto, pageTitle, file,
					false);

		} catch (Exception e) {
			String error = ExceptionUtils.getStackTrace(e);
			Logger.error(this, error, e);
			return error;
		}

		Logger.info(this, ":::      Finalizado Workflow Solicitud De Cambio      :::");

		return returnMessage;
	}

	private File stream2file(InputStream in, File file) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		IOUtils.copy(in, out);
		out.close();
		return file;
	}
	
	private String formatearUrl(String url) {
		if (url.substring(0, 1).contentEquals("[") && url.substring(url.length() - 1).equals("]")) {
			url = url.replace("[", "");
			url = url.replace("]", "");
		}
		
		return url;
	}

	@POST
	@Path("/obtenerPuestosFuncionales")
	@Produces(MediaType.TEXT_PLAIN)
	public String obtenerPuestosFuncionales(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String rawData) {
		JsonObject jsonObject = new JsonObject();
		try {
			JsonObject data = (new JsonParser()).parse(rawData).getAsJsonObject();
			HashMap<String, Object> map = this.getAsHashMap(data);
			if (!map.containsKey("username"))
				throw new Exception("Falta campo username");

			String username = (String) map.get("username");

			return this.agregarDatosExtrasDeUsuario(username);
		} catch (Exception e) {
			Logger.error(this, "::::: " + e.getMessage() + " :::::", e);
			jsonObject.addProperty("status", "error");
			jsonObject.addProperty("error", e.getMessage());
			return jsonObject.toString();
		}
	}

	/**
	 * Inicia el trámite de workflow dependiendo si es una solicitud de modificación
	 * o una solicitud de creación de página
	 * 
	 * @param usuario
	 * @param contentletIdentifier
	 * @param solicitud
	 * @param url
	 * @param pageTitle
	 * @param file
	 * @param isCreacion
	 * @return
	 * @throws Exception
	 */
	private String iniciarSolicitud(User usuario, String contentletIdentifier, String solicitud, String url, String urlAdjunto,
			String pageTitle, File file, boolean isCreacion) throws Exception {

		String stepName = isCreacion ? SOLICITAR_CREACION : SOLICITAR_MODIFICACION;

		Contentlet contentlet = getContentletByIdentifier(contentletIdentifier);
		WorkflowAction action = WorkflowUtils.getActionByStepName(stepName);

		return procesarSolicitud(usuario, solicitud, url, urlAdjunto, pageTitle, file, contentlet, action, isCreacion);
	}

	/**
	 * Obtiene el contentlet a base de un identificador que genera DotCMS cuando se
	 * genera el contenido
	 * 
	 * @param countentletIdentifier
	 * @return
	 * @throws DotDataException
	 * @throws DotSecurityException
	 */
	private Contentlet getContentletByIdentifier(String countentletIdentifier)
			throws DotDataException, DotSecurityException {
		User systemUser = APILocator.getUserAPI().getSystemUser();
		Contentlet contentlet = null;

		try {
			contentlet = APILocator.getContentletAPI().findContentletByIdentifier(countentletIdentifier, true, 1,
					systemUser, false);
		} catch (DotContentletStateException e) {
			Logger.warn(this, "No se encontro el contenido en version live, se usara version working", e);
			contentlet = APILocator.getContentletAPI().findContentletByIdentifier(countentletIdentifier, false, 1,
					systemUser, false);
		}

		// Si es content-generic, deberia tener seteado un campo
		// 'identificadorAdministracin'
		if (contentlet.get(IDENTIFICADOR_ADMINISTRACION) == null) {
			throw new RuntimeException("El contenido no tiene seteado: " + IDENTIFICADOR_ADMINISTRACION);
		}

		return contentlet;
	}

	private String procesarSolicitud(User usuario, String solicitud, String url, String urlAdjunto, String pageTitle, File file, Contentlet contentlet, 
			WorkflowAction action, boolean isCreacion) throws DotDataException, Exception {
		
		WorkflowAPI wapi = APILocator.getWorkflowAPI();
		
		WorkflowTask task = wapi.findTaskByContentlet(contentlet);
		
		String idContenido = contentlet.get(IDENTIFICADOR_ADMINISTRACION).toString();
		
		if(task != null && task.getStatus() != null && task.getStatus().trim() != "") {
			
			WorkflowStep step = wapi.findStep(task.getStatus());
			
			if (step.getName().equals(PENDIENTE_DE_PUBLICACION)) {		
		
			//Si la task no es nueva, significa que el contenido se esta actualizando
		
			try {
				//Se obtiene el processor para obtener datos necesarios para el envio de mail
				if (contentlet.getStringProperty(Contentlet.WORKFLOW_ACTION_KEY)==null) {
					contentlet.setStringProperty(Contentlet.WORKFLOW_ACTION_KEY, action.getId());
				}
				WorkflowProcessor processor = new WorkflowProcessor(contentlet, usuario);
				
				//Se envia mail al usuario solicitante indicando que se envio su solicitud exitosamente
				this.sendUserEmail(processor, solicitud, usuario, url, urlAdjunto, pageTitle, null, isCreacion, idContenido);
				//Se envia mail al usuario asignado indicando que tiene una solicitud en bandeja
				this.sendAssigneeEmail(processor, solicitud, usuario, url, urlAdjunto, pageTitle, file, false, isCreacion, idContenido);
				
				//Aparte se ejecutan las subtareas de NotifyUsers y NotifyAssignee que tenga el Step de Solicitud de Cambio
				List<WorkflowActionClass> actionClasses = processor.getActionClasses();
				if(actionClasses != null) {
					for(WorkflowActionClass actionClass:actionClasses) {
						WorkFlowActionlet actionlet = actionClass.getActionlet();
						Map<String,WorkflowActionClassParameter> params = FactoryLocator.getWorkFlowFactory().findParamsForActionClass(actionClass);
						if (NotifyUsersActionlet.class.isInstance(actionlet) || NotifyAssigneeActionlet.class.isInstance(actionlet)) {
							actionlet.executeAction(processor, params);
						}
					}
				}
			} catch (Exception e) {
				String error = ExceptionUtils.getStackTrace(e);
				Logger.error(this, error, e);
				return error;
			}
			
			return MESSAGE_OK;
			}
		}
		
		String workflowComment = this.armarComentario(usuario.getUserId(), solicitud, contentlet, isCreacion, urlAdjunto, (file!=null ? file.getName() : null));
		
		contentlet.setStringProperty(Contentlet.WORKFLOW_ACTION_KEY, action.getId());
		contentlet.setStringProperty(Contentlet.WORKFLOW_COMMENTS_KEY, workflowComment);
		contentlet.setStringProperty(Contentlet.WORKFLOW_ASSIGN_KEY, null);
		contentlet.setStringProperty(WorkflowUtils.WORKFLOW_PAGE_URL, url);
		
		WorkflowProcessor workflowProcessor = wapi.fireWorkflowNoCheckin(contentlet, usuario);				
		
		//Se envia mail al usuario solicitante indicando que se envio su solicitud exitosamente
		this.sendUserEmail(workflowProcessor, solicitud, usuario, url, urlAdjunto, pageTitle, null, isCreacion, idContenido);
		//Se envia mail al usuario asignado indicando que tiene una solicitud en bandeja
		this.sendAssigneeEmail(workflowProcessor, solicitud, usuario, url, urlAdjunto, pageTitle, file, true, isCreacion, idContenido);
		
		return MESSAGE_OK;
	}

	private boolean sendUserEmail(WorkflowProcessor processor, String solicitud, User usuario, String url, String urlAdjunto,
			String pageTitle, File file, boolean isCreacion, String idContenido) {

		try {
			String subject = null;
			String preText = "Le informamos que se ha generado un nuevo trámite en Biblos 2.5, el mismo será evaluado por el Área de Contenidos. Una vez finalizado se le notificará su resolución.";

			if (isCreacion) {
				subject = "[Biblos 2.5] Solicitud de Creación de Página";
			} else {
				subject = "[Biblos 2.5] Solicitud de Cambio";
			}

			return this.sendCustomEmail(processor, solicitud, usuario, "", url, urlAdjunto, pageTitle, preText, subject, file, true,
					isCreacion, idContenido);
		} catch (Exception e) {
			Logger.warn(this, "Error al enviar el email de solicitud de cambio/creacion", e);
			return false;
		}
	}

	private boolean sendAssigneeEmail(WorkflowProcessor processor, String solicitud, User usuario, String url, String urlAdjunto,
			String pageTitle, File file, boolean nuevaSolicitud, boolean isCreacion, String idContenido) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String currentDate = dateFormat.format(new Date());		

		try {
			String subject = null;
			String preText = nuevaSolicitud ? "Le informamos que se le ha asignado un nuevo trámite en Biblos 2.5."
					: "Le recordamos que tiene asignado un trámite en Biblos 2.5.";
			String emailAddress = this.findAssigneeEmails(processor);

			if (isCreacion) {
				subject = nuevaSolicitud ? "[Biblos 2.5] Solicitud de Creación de Página (NUEVO) ["  + currentDate + "]"
						: "[Biblos 2.5] - Solicitud de Creación de Página [" + currentDate + "]";
			} else {
				subject = nuevaSolicitud ? "[Biblos 2.5] Nueva Solicitud de Cambio [" + currentDate + "]"
						: "[Biblos 2.5] Solicitud de Cambio [" + currentDate + "]";
			}

			return this.sendCustomEmail(processor, solicitud, usuario, emailAddress, url, urlAdjunto, pageTitle, preText, subject,
					file, false, isCreacion, idContenido);
		} catch (Exception e) {
			Logger.warn(this, "Error al enviar el email de solicitud de cambio/creacion", e);
			return false;
		}
	}

	private boolean sendCustomEmail(WorkflowProcessor workflow, String solicitud, User user, String emailAddress,
			String url, String urlAdjunto, String pageTitle, String preText, String subject, File file, boolean sendToUser,
			boolean isCreacion, String idContenido) throws DotDataException, DotSecurityException, IOException {
		
		String hostDescription = hostAPI.findByName(workflow.getContentlet().getHost(), APILocator.getUserAPI().getSystemUser(), false).getStringProperty("description");	

		StringBuffer sb = new StringBuffer();

		sb.append(preText);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		sb.append("Datos del tr&aacute;mite:");
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		sb.append(WorkflowUtils.NEGRITA_INICIO + "Usuario: " + WorkflowUtils.NEGRITA_FIN);
		sb.append(user.getFirstName() + " " + user.getLastName() + " - " + user.getUserId() + " ("
				+ user.getEmailAddress() + ")");
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		
		sb.append(WorkflowUtils.NEGRITA_INICIO + "ID del tr&aacute;mite: " + WorkflowUtils.NEGRITA_FIN);
		sb.append(workflow.getTask().getId());		
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		sb.append(WorkflowUtils.NEGRITA_INICIO + "ID del contenido: " + WorkflowUtils.NEGRITA_FIN);
		sb.append(idContenido);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		sb.append(WorkflowUtils.NEGRITA_INICIO + "Tipo de tr&aacute;mite: " + WorkflowUtils.NEGRITA_FIN);
		sb.append(isCreacion ? "Solicitud de Creación de Página" : "Solicitud de Cambio");
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		if (isCreacion) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "P&aacute;gina: " + WorkflowUtils.NEGRITA_FIN);
		} else {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "P&aacute;gina y sitio: " + WorkflowUtils.NEGRITA_FIN);
		}
		sb.append(pageTitle);
		sb.append(" - " + hostDescription);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		if (!isCreacion) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Link a la p&aacute;gina: " + WorkflowUtils.NEGRITA_FIN);
			sb.append("<a href='" + url + "'>" + url + "</a>");
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Link adjunto: " + WorkflowUtils.NEGRITA_FIN + WorkflowRestService.HREF_INICIO + urlAdjunto + "file?name=" + file.getName().replace(".", "%2E") + " " + WorkflowRestService.TARGET_BLANK + ">" + file.getName() + WorkflowRestService.HREF_FIN);			
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
		}

		sb.append(WorkflowUtils.NEGRITA_INICIO + "Comentario / descripci&oacute;n: " + WorkflowUtils.NEGRITA_FIN);
		sb.append(solicitud);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);

		String htmlBody = sb.toString();
		String to = sendToUser ? user.getEmailAddress() : emailAddress;
		return EmailUtil.sendEmail(to, subject, htmlBody,
				WorkflowProperties.getProperties().getProperty(EmailUtil.EMAIL_SYSTEM_ADDRESS, EmailUtil.EMAIL_DEFAULT_ADDRESS), file);
	}


	/**
	 * Genera el comentario que se adosa al historial del trámite de workflow
	 * 
	 * @param userId
	 * @param solicitud
	 * @param contentlet
	 * @param isCreacion
	 * @return
	 * @throws Exception
	 */
	private String armarComentario(String userId, String solicitud, Contentlet contentlet, boolean isCreacion, String urlAdjunto, String fileName)
			throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		sb.append(this.agregarDatosExtrasDeUsuario(userId));
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		// Agrego una etiqueta para luego reemplazarla por taskId
		sb.append(WorkflowUtils.NEGRITA_INICIO + "ID de tramite: " + WorkflowUtils.NEGRITA_FIN + TASK_ID_LABEL);
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		
		if (isCreacion) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + WorkflowUtils.TIPO_DE_TRAMITE_LABEL + WorkflowUtils.NEGRITA_FIN
					+ WorkflowUtils.SOLICITUD_DE_CREACION);
		} else {
			sb.append(WorkflowUtils.NEGRITA_INICIO + WorkflowUtils.TIPO_DE_TRAMITE_LABEL + WorkflowUtils.NEGRITA_FIN
					+ WorkflowUtils.SOLICITUD_DE_CAMBIO);
		}
		sb.append(WorkflowUtils.SALTO_DE_LINEA);
		
		if (fileName !=null) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Link adjunto: " + WorkflowUtils.NEGRITA_FIN + WorkflowRestService.HREF_INICIO + urlAdjunto + "file?name=" + fileName.replace(".", "%2E") + " " + WorkflowRestService.TARGET_BLANK + ">" + fileName + WorkflowRestService.HREF_FIN);
			
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
		}

		if (!isCreacion) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "ID del contenido: " + WorkflowUtils.NEGRITA_FIN
					+ contentlet.get(IDENTIFICADOR_ADMINISTRACION).toString());
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Referencias: " + WorkflowUtils.NEGRITA_FIN
					+ this.findReferences(contentlet));
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
		}
		sb.append(WorkflowUtils.NEGRITA_INICIO + "Comentario / descripcion: " + WorkflowUtils.NEGRITA_FIN
				+ solicitud);
		//sb.append(SOLICITUD_DE_CAMBIO_CREACION_FLAG);
		return sb.toString();
	}

	private String agregarDatosExtrasDeUsuario(String username) throws Exception {
		StringBuffer sb = new StringBuffer();
		Usuario userESB = this.getOsdeSecurityService().getUserIntranet(username);
		if (userESB != null) {
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Nombre y apellido: " + WorkflowUtils.NEGRITA_FIN
					+ userESB.getNombres() + " " + userESB.getApellidos());
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
			sb.append(WorkflowUtils.NEGRITA_INICIO + "MT: " + WorkflowUtils.NEGRITA_FIN + userESB.getUsername());
			sb.append(WorkflowUtils.SALTO_DE_LINEA);
			sb.append(WorkflowUtils.NEGRITA_INICIO + "Mail: " + WorkflowUtils.NEGRITA_FIN + userESB.getEmail());
			// Si tiene cargado puestos funcionales, los agrego
			if (userESB.getPuestos() != null && userESB.getPuestos().length > 0) {
				sb.append(WorkflowUtils.SALTO_DE_LINEA);
				sb.append(WorkflowUtils.NEGRITA_INICIO + "Puestos: " + WorkflowUtils.NEGRITA_FIN);
				for (int i = 0; i < userESB.getPuestos().length; i++) {
					sb.append(WorkflowUtils.SALTO_DE_LINEA);
					// Muestro descripcion del puesto + empresa
					sb.append(userESB.getPuestos()[i].getDescripcion());
					if (userESB.getPuestos()[i].getFilial().getEmpresa() != null
							&& userESB.getPuestos()[i].getFilial().getEmpresa().getDescripcion() != null) {
						sb.append(" - " + userESB.getPuestos()[i].getCap().getEmpresa().getDescripcion());
					}
				}
			}
		}
		return sb.toString();
	}

	protected HashMap<String, Object> getAsHashMap(JsonObject data) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		for (java.util.Map.Entry<String, JsonElement> entry : data.entrySet()) {
			hm.put(entry.getKey(), entry.getValue().getAsString());
		}
		return hm;
	}

	private String findReferences(Contentlet content) throws Exception {
		ContentletAPI contentletAPI = APILocator.getContentletAPI();
		Set<String> pageReferences = new HashSet<String>();
		StringBuffer pageReferencesString = new StringBuffer();
		List<Map<String, Object>> references = contentletAPI.getContentletReferences(content,
				APILocator.getUserAPI().getSystemUser(), false);
		for (Map<String, Object> reference : references) {
			IHTMLPage page = (IHTMLPage) reference.get("page");
			Container container = (Container) reference.get("container"); // solapa
			String containerTitle = container.getTitle();
			String pageUrl = StringUtils.isNotBlank(containerTitle) ? page.getPageUrl() + " (" + containerTitle + ")"
					: page.getPageUrl();
			if (pageReferences.add(pageUrl)) {
				if (pageReferences.size() > 1) {
					pageReferencesString.append(", ");
				}
				pageReferencesString.append(pageUrl);
			}
		}
		return pageReferencesString.toString();
	}

	private String findAssigneeEmails(WorkflowProcessor processor) throws Exception {
		Role assignedTo = null;

		assignedTo = processor.getNextAssign();
		
		if (assignedTo == null) {
			throw new Exception("Next assign does not exist");
		} else {					
			if (assignedTo.getDescription().isEmpty()) {
				throw new Exception("No existe un destinatario del email");
			} else {
				return assignedTo.getDescription(); // Si el rol asignado tiene como descripcion un mail, se envia a ese correo,	
			}
		}
	}

	public OsdeSecurityExternalService getOsdeSecurityService() {
		if (osdeSecurityService == null) {
			this.setOsdeSecurityService(OsdeFrameworkServices.OsdeSecurityExternalService());
		}
		return osdeSecurityService;
	}

	public void setOsdeSecurityService(OsdeSecurityExternalService osdeSecurityService) {
		WorkflowRestService.osdeSecurityService = osdeSecurityService;
	}

	/**
	 * Obtiene el archivo cargado al momento de generar la solicitud de modificación
	 * o creación de página
	 * 
	 * @param form
	 * @return
	 * @throws IOException
	 */
	private File extractFile(FormDataMultiPart form, String fileName) throws IOException {
		File file = null;
		
		if (fileName!=null && !fileName.isEmpty() && !fileName.trim().isEmpty()) {
			FormDataBodyPart fileBodyPart = form.getField("file") != null ? form.getField("file") : null;
			InputStream fileInputStream = fileBodyPart != null ? fileBodyPart.getValueAs(InputStream.class) : null;		
			
			String nombreArchivo = UUID.randomUUID().toString() + "_" +  fileName.replace(" ", "");
			file = new File(this.getOsdeSecurityService().getFilesUploadPath().concat("/").concat(nombreArchivo));
			file = stream2file(fileInputStream, file);
		}	
		
		return file;		
	}	

}