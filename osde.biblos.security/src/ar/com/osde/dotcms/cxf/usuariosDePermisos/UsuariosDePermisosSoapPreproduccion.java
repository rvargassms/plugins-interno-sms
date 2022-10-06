package ar.com.osde.dotcms.cxf.usuariosDePermisos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ar.com.osde.framework.services.Service;

/**
 * This class was generated by Apache CXF 2.3.9
 * 2016-07-25T12:11:18.785-03:00
 * Generated source version: 2.3.9
 * 
 */
@WebService(name = "usuariosDePermisosSoap", targetNamespace = "http://pre.intranet.osde/")
public interface UsuariosDePermisosSoapPreproduccion extends Service {

    @WebResult(name = "ObtenerUsuariosResult", targetNamespace = "http://pre.intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuarios", action = "http://pre.intranet.osde/ObtenerUsuarios")
    public String obtenerUsuarios(
        @WebParam(name = "permisos", targetNamespace = "http://pre.intranet.osde/")
        String permisos
    );
    
    @WebResult(name = "ObtenerUsuariosv2Result", targetNamespace = "http://pre.intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuariosv2", action = "http://pre.intranet.osde/ObtenerUsuariosv2")
    public String obtenerUsuariosv2(
        @WebParam(name = "permisos", targetNamespace = "http://pre.intranet.osde/")
        String permisos
    );

    @WebResult(name = "ObtenerListadoDePermisosResult", targetNamespace = "http://pre.intranet.osde/")
    @WebMethod(operationName = "ObtenerListadoDePermisos", action = "http://pre.intranet.osde/ObtenerListadoDePermisos")
    public String obtenerListadoDePermisos(
        @WebParam(name = "permiso", targetNamespace = "http://pre.intranet.osde/")
        String permiso
    );

    @WebResult(name = "ObtenerFilialesDePermisoResult", targetNamespace = "http://pre.intranet.osde/")
    @WebMethod(operationName = "ObtenerFilialesDePermiso", action = "http://pre.intranet.osde/ObtenerFilialesDePermiso")
    public String obtenerFilialesDePermiso(
        @WebParam(name = "permiso", targetNamespace = "http://pre.intranet.osde/")
        String permiso
    );

    @WebResult(name = "ObtenerUsuariosFilialResult", targetNamespace = "http://pre.intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuariosFilial", action = "http://pre.intranet.osde/ObtenerUsuariosFilial")
    public String obtenerUsuariosFilial(
        @WebParam(name = "permisos", targetNamespace = "http://pre.intranet.osde/")
        String permisos,
        @WebParam(name = "filial", targetNamespace = "http://pre.intranet.osde/")
        String filial
    );
}
