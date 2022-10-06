/**
 * Usuario_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario;

public interface Usuario_PortType extends java.rmi.Remote {
    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorDNI(java.lang.String dni) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorClave(java.lang.String clave) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorUsername(java.lang.String nombreUsuario) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonales(java.lang.String nombreUsuario) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios1(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios2(java.lang.String codigoFilial, java.lang.String[] puestos) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[] obtener(java.lang.String userName, java.lang.String jerar, int idModulo) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios3(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios4(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios5(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap, java.lang.String filtroNombreyApellido) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[] getUsuarios(java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios(java.lang.String[] puestos) throws java.rmi.RemoteException;
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorDNI(java.lang.String dni) throws java.rmi.RemoteException;
    public void solicitudPassword(java.lang.String email) throws java.rmi.RemoteException;
}
