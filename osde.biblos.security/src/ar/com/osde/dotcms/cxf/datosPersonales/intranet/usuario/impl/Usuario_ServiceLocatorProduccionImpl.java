/**
 * Usuario_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.impl;

import org.apache.axis.client.Service;

import ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator;

public class Usuario_ServiceLocatorProduccionImpl extends Service implements Usuario_ServiceLocator {

    public Usuario_ServiceLocatorProduccionImpl() {
    }


    public Usuario_ServiceLocatorProduccionImpl(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Usuario_ServiceLocatorProduccionImpl(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsuarioHttpPort
    private java.lang.String UsuarioHttpPort_address = "http://esb.osde.ar/services/Usuario/";

    public java.lang.String getUsuarioHttpPortAddress() {
        return UsuarioHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsuarioHttpPortWSDDServiceName = "UsuarioHttpPort";

    public java.lang.String getUsuarioHttpPortWSDDServiceName() {
        return UsuarioHttpPortWSDDServiceName;
    }

    public void setUsuarioHttpPortWSDDServiceName(java.lang.String name) {
        UsuarioHttpPortWSDDServiceName = name;
    }

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

    public void setUsuarioHttpPortEndpointAddress(java.lang.String address) {
        UsuarioHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
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
        if ("UsuarioHttpPort".equals(inputPortName)) {
            return getUsuarioHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://usuario.intranet.osde/", "Usuario");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "UsuarioHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsuarioHttpPort".equals(portName)) {
            setUsuarioHttpPortEndpointAddress(address);
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
