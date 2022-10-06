package ar.com.osde.services.administracion.empleado.intranet.usuario;


public interface Empleado_ServiceLocator extends Empleado_Service {
	
	public java.lang.String getEmpleadoServicePortAddress();
	
    public java.lang.String getEmpleadoServicePortWSDDServiceName();

    public void setEmpleadoServicePortWSDDServiceName(java.lang.String name);
    
    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort() throws javax.xml.rpc.ServiceException;

    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    
    public void setEmpleadoServicePortEndpointAddress(java.lang.String address);
    
    
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException;
    	
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException;

    public javax.xml.namespace.QName getServiceName();

    public java.util.Iterator getPorts();

	void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException;

	void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException;

    
}
