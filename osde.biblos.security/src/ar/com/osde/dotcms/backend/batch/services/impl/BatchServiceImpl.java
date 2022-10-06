package ar.com.osde.dotcms.backend.batch.services.impl;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.springframework.batch.core.Job;

import ar.com.osde.dotcms.backend.services.BatchService;
import ar.com.osde.dotcms.backend.dtos.ProcessResponseDTO;
import ar.com.osde.dotcms.backend.batch.bo.BatchBO;

/**
 * The Class UpdateServiceImpl.
 */
@WebService(endpointInterface = "ar.com.osde.dotcms.backend.services.BatchService", serviceName = "BatchService")
public class BatchServiceImpl implements BatchService {

	/** The simple job. */
	private Job simpleJob;

	/** The batch bo. */
	private BatchBO batchBO;

	/**
	 * Start.
	 *
	 * @return the process response
	 */
	public ProcessResponseDTO start() {
		ProcessResponseDTO processResponse = getBatchBO().startJob(simpleJob);
		return processResponse;
	}

	/**
	 * Status.
	 *
	 * @param id the id
	 * @return the process response
	 */
	public ProcessResponseDTO status(String id) {
		Long executionId;

		if (StringUtils.isEmpty(id)) {
			return new ProcessResponseDTO("El parametro id no puede estar vacio");
		}

		try {
			executionId = Long.valueOf(id);
		} catch (NumberFormatException e) {
			return new ProcessResponseDTO("El parametro id no tiene un formato correcto.");
		}

		ProcessResponseDTO processResponse = getBatchBO().getJobStatus(executionId);

		return processResponse;
	}

	/**
	 * Cancel.
	 *
	 * @param id the id
	 * @return the process response
	 */
	public ProcessResponseDTO cancel(String id) {
		//return new ProcessResponse("Esta funcionalidad no se encuentra disponible en este proceso.");
		Long executionId;
		try {
			executionId = Long.valueOf(id);
		} catch (NumberFormatException e) {
			return new ProcessResponseDTO("El parametro id no tiene un formato correcto.");
		}

		ProcessResponseDTO processResponse = getBatchBO().getJobStatus(executionId);

		return processResponse;

	}

	/**
	 * Gets the simple job.
	 *
	 * @return the simple job
	 */
	public Job getSimpleJob() {
		return simpleJob;
	}

	/**
	 * Sets the simple job.
	 *
	 * @param simpleJob the new simple job
	 */
	public void setSimpleJob(Job simpleJob) {
		this.simpleJob = simpleJob;
	}

	public BatchBO getBatchBO() {
		return batchBO;
	}

	public void setBatchBO(BatchBO batchBO) {
		this.batchBO = batchBO;
	}


}
