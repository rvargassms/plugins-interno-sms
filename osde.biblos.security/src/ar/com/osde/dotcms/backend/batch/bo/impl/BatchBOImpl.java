package ar.com.osde.dotcms.backend.batch.bo.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import ar.com.osde.dotcms.backend.dtos.ProcessResponseDTO;
import ar.com.osde.dotcms.backend.dtos.ProcessStatus;
import ar.com.osde.dotcms.backend.batch.bo.BatchBO;
import ar.com.osde.dotcms.backend.batch.utils.BatchUtils;


/**
 * The Class BatchBOImpl.
 */
public class BatchBOImpl implements BatchBO {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(BatchBOImpl.class);

	/** The job launcher. */
	private JobLauncher jobLauncher;

	/** The job explorer. */
	private JobExplorer jobExplorer;

	/**
	 * Start job.
	 *
	 * @param job the job
	 * @return the process response
	 */
	public ProcessResponseDTO startJob(Job job) {
		ProcessResponseDTO processResponse;

		Set<JobExecution> runningJobExecutions = jobExplorer.findRunningJobExecutions(job.getName());

		if (!runningJobExecutions.isEmpty()) {
			return new ProcessResponseDTO("El proceso ya se encuentra ejecutando.");
		}

		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.addString("jobName", job.getName()).toJobParameters();

			JobExecution run = this.jobLauncher.run(job, jobParameters);
			processResponse = new ProcessResponseDTO(run.getId().toString(), ProcessStatus.STARTED);

		} catch (JobExecutionAlreadyRunningException e) {
			LOGGER.error("Error al lanzar la ejecuci\u00F3n del job.", e);
			processResponse = new ProcessResponseDTO("La ejecuci\u00F3n del job ya se encuentra corriendo.");
		} catch (JobRestartException e) {
			LOGGER.error("Error al lanzar la ejecuci\u00F3n del job.", e);
			processResponse = new ProcessResponseDTO("No se pudo reiniciar el job.");
		} catch (JobInstanceAlreadyCompleteException e) {
			LOGGER.error("Error al lanzar la ejecuci\u00F3n del job.", e);
			processResponse = new ProcessResponseDTO("La instancia de este job ya se encuentra ejecutando.");
		} catch (JobParametersInvalidException e) {
			LOGGER.error("Error al lanzar la ejecuci\u00F3n del job.", e);
			processResponse = new ProcessResponseDTO("Par\u00E1metros de creaci\u00F3n de job incorrectos.");
		}

		return processResponse;
	}

	/**
	 * Gets the job status.
	 *
	 * @param jobExecutionId the job execution id
	 * @return the job status
	 */
	public ProcessResponseDTO getJobStatus(Long jobExecutionId) {
		JobExecution jobExecution = jobExplorer.getJobExecution(jobExecutionId);

		if (jobExecution == null) {
			return new ProcessResponseDTO("No existe el proceso solicitado.");
		}

		ProcessStatus processStatus = BatchUtils.batchStatusToProcessStatus(jobExecution.getStatus());

        // si el numero es impar
        if(jobExecutionId % 2 != 0) {
        	jobExecution.setExitStatus(ExitStatus.FAILED);
        	processStatus = ProcessStatus.ERROR;
        	ExitStatus exitStatus = jobExecution.getExitStatus();
        	return new ProcessResponseDTO(jobExecutionId.toString(), processStatus, exitStatus.getExitDescription());
        } 
		
		if (processStatus.equals(ProcessStatus.ERROR)) {
			ExitStatus exitStatus = jobExecution.getExitStatus();
			return new ProcessResponseDTO(jobExecutionId.toString(), processStatus, exitStatus.getExitDescription());
		}

		return new ProcessResponseDTO(jobExecutionId.toString(), processStatus);
	}

	/**
	 * Gets the job launcher.
	 *
	 * @return the job launcher
	 */
	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	/**
	 * Sets the job launcher.
	 *
	 * @param jobLauncher the new job launcher
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	/**
	 * Gets the job explorer.
	 *
	 * @return the job explorer
	 */
	public JobExplorer getJobExplorer() {
		return jobExplorer;
	}

	/**
	 * Sets the job explorer.
	 *
	 * @param jobExplorer the new job explorer
	 */
	public void setJobExplorer(JobExplorer jobExplorer) {
		this.jobExplorer = jobExplorer;
	}
}
