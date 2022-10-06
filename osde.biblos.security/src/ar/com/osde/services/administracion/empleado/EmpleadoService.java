/**
 * EmpleadoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public interface EmpleadoService extends java.rmi.Remote {
    public ar.com.osde.entities.empleado.UnidadOrganizativa[] getUnidadesPrimerNivelJerarquico(java.lang.String empreNro, java.lang.String uniNro) throws java.rmi.RemoteException;
    public ar.com.osde.services.administracion.empleado.SearchResult searchEmpleados(ar.com.osde.entities.empleado.EmpleadoFilter empleadoFilter) throws java.rmi.RemoteException;
    public ar.com.osde.entities.empleado.Empleado getEmpleadoById(java.lang.String idEmpleado) throws java.rmi.RemoteException;
    public ar.com.osde.entities.empleado.Empleado getEmpleadoByUsername(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String obtenerPermisosConEMail(java.lang.String aplicacion, java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosPersonalesEMail(java.lang.String email) throws java.rmi.RemoteException;
    public ar.com.osde.entities.empleado.PuestoFuncional[] getPuestosPrincipalesDeUnidad(java.lang.String numeroEmpresa, java.lang.String numeroUnidadOrganizativa, java.lang.String filiales) throws java.rmi.RemoteException;
    public ar.com.osde.entities.empleado.PuestoFuncional[] getPuestosDependientesDePuesto(java.lang.String numeroEmpresa, java.lang.String numeroUnidadOrganizativa, java.lang.String numeroPuesto, java.lang.String filiales) throws java.rmi.RemoteException;
}
