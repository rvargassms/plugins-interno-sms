package ar.com.osde.services.administracion.empleado;

import ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_ServiceLocator;
import ar.com.osde.services.administracion.empleado.intranet.usuario.Empleado_ServiceLocator;

public class EmpleadoServiceProxy implements ar.com.osde.services.administracion.empleado.EmpleadoService {
  private String _endpoint = null;
  private ar.com.osde.services.administracion.empleado.EmpleadoService empleadoService = null;
  private Empleado_ServiceLocator employeeServiceESB;
  
  public EmpleadoServiceProxy() {
    _initEmpleadoServiceProxy();
  }
  
  public EmpleadoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmpleadoServiceProxy();
  }
  
  private void _initEmpleadoServiceProxy() {
    try {
      empleadoService = employeeServiceESB.getEmpleadoServicePort();
      if (empleadoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)empleadoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)empleadoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (empleadoService != null)
      ((javax.xml.rpc.Stub)empleadoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoService() {
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService;
  }
  
  public ar.com.osde.entities.empleado.UnidadOrganizativa[] getUnidadesPrimerNivelJerarquico(java.lang.String empreNro, java.lang.String uniNro) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.getUnidadesPrimerNivelJerarquico(empreNro, uniNro);
  }
  
  public ar.com.osde.services.administracion.empleado.SearchResult searchEmpleados(ar.com.osde.entities.empleado.EmpleadoFilter empleadoFilter) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.searchEmpleados(empleadoFilter);
  }
  
  public ar.com.osde.entities.empleado.Empleado getEmpleadoById(java.lang.String idEmpleado) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.getEmpleadoById(idEmpleado);
  }
  
  public ar.com.osde.entities.empleado.Empleado getEmpleadoByUsername(java.lang.String username) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.getEmpleadoByUsername(username);
  }
  
  public java.lang.String obtenerPermisosConEMail(java.lang.String aplicacion, java.lang.String email) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.obtenerPermisosConEMail(aplicacion, email);
  }
  
  public java.lang.String obtenerDatosPersonalesEMail(java.lang.String email) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.obtenerDatosPersonalesEMail(email);
  }
  
  public ar.com.osde.entities.empleado.PuestoFuncional[] getPuestosPrincipalesDeUnidad(java.lang.String numeroEmpresa, java.lang.String numeroUnidadOrganizativa, java.lang.String filiales) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.getPuestosPrincipalesDeUnidad(numeroEmpresa, numeroUnidadOrganizativa, filiales);
  }
  
  public ar.com.osde.entities.empleado.PuestoFuncional[] getPuestosDependientesDePuesto(java.lang.String numeroEmpresa, java.lang.String numeroUnidadOrganizativa, java.lang.String numeroPuesto, java.lang.String filiales) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.getPuestosDependientesDePuesto(numeroEmpresa, numeroUnidadOrganizativa, numeroPuesto, filiales);
  }
  

	public Empleado_ServiceLocator getEmployeeServiceESB() {
		return employeeServiceESB;
	}
	
	public void setEmployeeServiceESB(Empleado_ServiceLocator employeeServiceESB) {
		this.employeeServiceESB = employeeServiceESB;
	}

  
}