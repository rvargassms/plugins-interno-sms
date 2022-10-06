/**
 * Usuario_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.impl;

import org.apache.axis.client.Service;

import ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator;

public class Usuario_ServiceLocatorPreproduccionImpl extends Service implements Usuario_ServiceLocator {

    public Usuario_ServiceLocatorPreproduccionImpl() {
    }


    public Usuario_ServiceLocatorPreproduccionImpl(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Usuario_ServiceLocatorPreproduccionImpl(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsuarioHttpPort
    private java.lang.String UsuarioHttpPort_address = "http://preesb.osde.ar/services/Usuario/";

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getUsuarioHttpPortAddress()
	 */
    @Override
	public java.lang.String getUsuarioHttpPortAddress() {
        return UsuarioHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsuarioHttpPortWSDDServiceName = "UsuarioHttpPort";

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getUsuarioHttpPortWSDDServiceName()
	 */
    @Override
	public java.lang.String getUsuarioHttpPortWSDDServiceName() {
        return UsuarioHttpPortWSDDServiceName;
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#setUsuarioHttpPortWSDDServiceName(java.lang.String)
	 */
    @Override
	public void setUsuarioHttpPortWSDDServiceName(java.lang.String name) {
        UsuarioHttpPortWSDDServiceName = name;
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getUsuarioHttpPort()
	 */
    @Override
	public ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType getUsuarioHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UsuarioHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUsuarioHttpPort(endpoint);
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getUsuarioHttpPort(java.net.URL)
	 */
    @Override
	public ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType getUsuarioHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.UsuarioHttpBindingStub _stub = new ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.UsuarioHttpBindingStub(portAddress, this);
            _stub.setPortName(getUsuarioHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#setUsuarioHttpPortEndpointAddress(java.lang.String)
	 */
    @Override
	public void setUsuarioHttpPortEndpointAddress(java.lang.String address) {
        UsuarioHttpPort_address = address;
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getPort(java.lang.Class)
	 */
    @Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.UsuarioHttpBindingStub _stub = new ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.UsuarioHttpBindingStub(new java.net.URL(UsuarioHttpPort_address), this);
                _stub.setPortName(getUsuarioHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getPort(javax.xml.namespace.QName, java.lang.Class)
	 */
    @Override
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UsuarioHttpPort".equals(inputPortName)) {
            return getUsuarioHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getServiceName()
	 */
    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://usuario.intranet.osde/", "Usuario");
    }

    private java.util.HashSet ports = null;

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#getPorts()
	 */
    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "UsuarioHttpPort"));
        }
        return ports.iterator();
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#setEndpointAddress(java.lang.String, java.lang.String)
	 */
    @Override
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsuarioHttpPort".equals(portName)) {
            setUsuarioHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /* (non-Javadoc)
	 * @see ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator#setEndpointAddress(javax.xml.namespace.QName, java.lang.String)
	 */
    @Override
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
