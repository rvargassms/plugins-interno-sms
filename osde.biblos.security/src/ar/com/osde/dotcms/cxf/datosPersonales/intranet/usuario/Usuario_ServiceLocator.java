package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario;

public interface Usuario_ServiceLocator extends Usuario_Service {

	java.lang.String getUsuarioHttpPortAddress();

	java.lang.String getUsuarioHttpPortWSDDServiceName();

	void setUsuarioHttpPortWSDDServiceName(java.lang.String name);

	ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType getUsuarioHttpPort()
			throws javax.xml.rpc.ServiceException;

	ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType getUsuarioHttpPort(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException;

	void setUsuarioHttpPortEndpointAddress(java.lang.String address);

	/**
	 * For the given interface, get the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException;

	/**
	 * For the given interface, get the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException;

	javax.xml.namespace.QName getServiceName();

	java.util.Iterator getPorts();

	/**
	* Set the endpoint address for the specified port name.
	*/
	void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException;

	/**
	* Set the endpoint address for the specified port name.
	*/
	void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException;

}