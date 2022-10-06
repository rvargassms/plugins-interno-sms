package ar.com.osde.dotcms.backend.batch.bo;

import org.springframework.batch.core.Job;

import ar.com.osde.framework.business.base.BusinessObject;
import ar.com.osde.dotcms.backend.dtos.ProcessResponseDTO;



/**
 * The Interface BatchBO.
 */
public interface BatchBO extends BusinessObject{

	/**
	 * Start job.
	 *
	 * @param job the job
	 * @return the process response
	 */
	ProcessResponseDTO startJob(Job job);

	/**
	 * Gets the job status.
	 *
	 * @param jobExecutionId the job execution id
	 * @return the job status
	 */
	ProcessResponseDTO getJobStatus(Long jobExecutionId);
}
