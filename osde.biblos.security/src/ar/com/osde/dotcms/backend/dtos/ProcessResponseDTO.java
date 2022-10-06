package ar.com.osde.dotcms.backend.dtos;

import org.apache.commons.lang.StringUtils;

/**
 * The Class ProcessResponse.
 */

public class ProcessResponseDTO {
	/** The id. */
	private String id;

	/** The status. */
	private ProcessStatus status;

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new process response.
	 */
	public ProcessResponseDTO() {
		super();
	}

	/**
	 * Instantiates a new process response.
	 *
	 * @param id     the id
	 * @param status the status
	 */
	public ProcessResponseDTO(String id, ProcessStatus status) {
		super();
		this.id = id;
		this.status = status;
		this.errorMessage = StringUtils.EMPTY;
	}

	/**
	 * Instantiates a new process response.
	 *
	 * @param errorMessage the error message
	 */
	public ProcessResponseDTO(String errorMessage) {
		super();
		this.status = null;
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new process response.
	 *
	 * @param id           the id
	 * @param errorMessage the error message
	 */
	public ProcessResponseDTO(String id, String errorMessage) {
		super();
		this.id = id;
		this.status = null;
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new process response.
	 *
	 * @param id           the id
	 * @param status       the status
	 * @param errorMessage the error message
	 */
	public ProcessResponseDTO(String id, ProcessStatus status, String errorMessage) {
		super();
		this.id = id;
		this.status = status;
		this.errorMessage = errorMessage;
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
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ProcessStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ProcessStatus status) {
		this.status = status;
	}


}
