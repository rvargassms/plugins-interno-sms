/**
 * Usuario_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado.intranet.usuario.impl;

import org.apache.axis.client.Service;

import ar.com.osde.services.administracion.empleado.intranet.usuario.Empleado_ServiceLocator;

public class Empleado_ServiceLocatorPreProdImpl extends Service implements Empleado_ServiceLocator {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The WSDD service name defaults to the port name.
    private java.lang.String EmpleadoServicePortWSDDServiceName = "EmpleadoServicePort";

    // Use to get a proxy class for EmpleadoServicePort
    private java.lang.String EmpleadoServicePort_address = "http://preesb.osde.ar/services/Empleado";

    private java.util.HashSet ports = null;

    
    public Empleado_ServiceLocatorPreProdImpl() {}
    
    public Empleado_ServiceLocatorPreProdImpl(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Empleado_ServiceLocatorPreProdImpl(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }


    public java.lang.String getEmpleadoServicePortAddress() {
        return EmpleadoServicePort_address;
    }

    public java.lang.String getEmpleadoServicePortWSDDServiceName() {
        return EmpleadoServicePortWSDDServiceName;
    }

    public void setEmpleadoServicePortWSDDServiceName(java.lang.String name) {
        EmpleadoServicePortWSDDServiceName = name;
    }

    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmpleadoServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmpleadoServicePort(endpoint);
    }

    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ar.com.osde.services.administracion.empleado.EmpleadoServiceServiceSoapBindingStub _stub = new ar.com.osde.services.administracion.empleado.EmpleadoServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmpleadoServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmpleadoServicePortEndpointAddress(java.lang.String address) {
        EmpleadoServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ar.com.osde.services.administracion.empleado.EmpleadoService.class.isAssignableFrom(serviceEndpointInterface)) {
                ar.com.osde.services.administracion.empleado.EmpleadoServiceServiceSoapBindingStub _stub = new ar.com.osde.services.administracion.empleado.EmpleadoServiceServiceSoapBindingStub(new java.net.URL(EmpleadoServicePort_address), this);
                _stub.setPortName(getEmpleadoServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmpleadoServicePort".equals(inputPortName)) {
            return getEmpleadoServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "EmpleadoServiceService");
    }

        public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "EmpleadoServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmpleadoServicePort".equals(portName)) {
            setEmpleadoServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
