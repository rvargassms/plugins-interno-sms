package ar.com.osde.services.administracion.empleado.intranet.usuario;

public interface Empleado_Service  extends javax.xml.rpc.Service {

    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort() throws javax.xml.rpc.ServiceException;

    public ar.com.osde.services.administracion.empleado.EmpleadoService getEmpleadoServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
