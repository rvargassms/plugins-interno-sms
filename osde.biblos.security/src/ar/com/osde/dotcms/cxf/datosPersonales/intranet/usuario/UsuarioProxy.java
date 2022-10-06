package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario;

import ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.impl.Usuario_ServiceLocatorTestingImpl;

public class UsuarioProxy implements ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType {
  private String _endpoint = null;
  private ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType usuario_PortType = null;
  private Usuario_ServiceLocator usuarioServiceESB;
  
  public UsuarioProxy() {
    _initUsuarioProxy();
  }
  
  public UsuarioProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioProxy();
  }
  
  private void _initUsuarioProxy() {
    try {
      usuario_PortType = usuarioServiceESB.getUsuarioHttpPort();
      if (usuario_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuario_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuario_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuario_PortType != null)
      ((javax.xml.rpc.Stub)usuario_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType getUsuario_PortType() {
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType;
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorDNI(java.lang.String dni) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.getUsuarioPorDNI(dni);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorClave(java.lang.String clave) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerDatosPersonalesPorClave(clave);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorUsername(java.lang.String nombreUsuario) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.getUsuarioPorUsername(nombreUsuario);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonales(java.lang.String nombreUsuario) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerDatosPersonales(nombreUsuario);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios1(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios1(codigoJerarquico, porcionNombreApellido);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios2(java.lang.String codigoFilial, java.lang.String[] puestos) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios2(codigoFilial, puestos);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[] obtener(java.lang.String userName, java.lang.String jerar, int idModulo) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtener(userName, jerar, idModulo);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios3(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios3(codigoFilial, puestos, codigoCap);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios4(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios4(codigoJerarquico, porcionNombreApellido, numeroPagina, cantidadRegistrosPorPagina);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios5(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap, java.lang.String filtroNombreyApellido) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios5(codigoFilial, puestos, codigoCap, filtroNombreyApellido);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[] getUsuarios(java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.getUsuarios(porcionNombreApellido, numeroPagina, cantidadRegistrosPorPagina);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios(java.lang.String[] puestos) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerUsuarios(puestos);
  }
  
  public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorDNI(java.lang.String dni) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    return usuario_PortType.obtenerDatosPersonalesPorDNI(dni);
  }
  
  public void solicitudPassword(java.lang.String email) throws java.rmi.RemoteException{
    if (usuario_PortType == null)
      _initUsuarioProxy();
    usuario_PortType.solicitudPassword(email);
  }

public Usuario_ServiceLocator getUsuarioServiceESB() {
	return usuarioServiceESB;
}

public void setUsuarioServiceESB(Usuario_ServiceLocator usuarioServiceESB) {
	this.usuarioServiceESB = usuarioServiceESB;
}
  
  
}