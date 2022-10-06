package ar.com.osde.dotcms.backend.services;

import javax.jws.WebService;

import ar.com.osde.framework.services.Service;
import ar.com.osde.dotcms.backend.dtos.ProcessResponseDTO;


/**
 * The Interface UpdateService.
 */
@WebService
public interface BatchService extends Service {
	/**
	 * Start.
	 *
	 * @return the process response
	 */
	ProcessResponseDTO start();

	/**
	 * Status.
	 *
	 * @param id the id
	 * @return the process response
	 */
	ProcessResponseDTO status(String id);

	/**
	 * Cancel.
	 *
	 * @param id the id
	 * @return the process response
	 */
	ProcessResponseDTO cancel(String id);


}
