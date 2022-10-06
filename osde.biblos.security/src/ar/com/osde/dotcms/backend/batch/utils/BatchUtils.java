package ar.com.osde.dotcms.backend.batch.utils;

import org.springframework.batch.core.BatchStatus;

import ar.com.osde.dotcms.backend.dtos.ProcessStatus;



/**
 * The Class BatchUtils.
 */
public abstract class BatchUtils {

	/**
	 * Batch status to process status.
	 *
	 * @param batchStatus the batch status
	 * @return the process status
	 */
	public static ProcessStatus batchStatusToProcessStatus(BatchStatus batchStatus) {
		if (batchStatus.isRunning()) {
			return ProcessStatus.RUNNING;
		}
		if (batchStatus.isUnsuccessful()) {
			return ProcessStatus.ERROR;
		}
		if (batchStatus.equals(BatchStatus.STOPPED)) {
			return ProcessStatus.CANCELED;
		}
		return ProcessStatus.FINISHED;
	}
}
