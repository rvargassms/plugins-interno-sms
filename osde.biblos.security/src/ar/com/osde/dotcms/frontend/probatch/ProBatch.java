package ar.com.osde.dotcms.frontend.probatch;

import com.opensymphony.xwork2.ActionSupport;

import ar.com.osde.dotcms.backend.services.BatchService;
import ar.com.osde.dotcms.backend.dtos.ProcessResponseDTO;

/**
 * The Class UpdateAction.
 */

public class ProBatch extends ActionSupport {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5215316037598597602L;

	/** The service. */
	private transient BatchService service;

	/** The id. */
	private String id;

	/** The response. */
	private ProcessResponseDTO response;

	/**
	 * Start.
	 *
	 * @return the string
	 */
	public String start() {
		response = getService().start();
		return SUCCESS;
	}

	/**
	 * Status.
	 *
	 * @return the string
	 */
	public String status() {
		response = getService().status(id);
		return SUCCESS;
	}

	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	public String cancel() {
		response = getService().cancel(id);
		return SUCCESS;
	}

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public BatchService getService() {
		return service;
	}

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	public void setService(BatchService service) {
		this.service = service;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public ProcessResponseDTO getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(ProcessResponseDTO response) {
		this.response = response;
	}


}
