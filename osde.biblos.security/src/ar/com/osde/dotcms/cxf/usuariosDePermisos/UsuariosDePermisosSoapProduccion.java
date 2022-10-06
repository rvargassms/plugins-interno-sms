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
@WebService(name = "usuariosDePermisosSoap", targetNamespace = "http://intranet.osde/")
public interface UsuariosDePermisosSoapProduccion extends Service {

    @WebResult(name = "ObtenerUsuariosResult", targetNamespace = "http://intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuarios", action = "http://intranet.osde/ObtenerUsuarios")
    public String obtenerUsuarios(
        @WebParam(name = "permisos", targetNamespace = "http://intranet.osde/")
        String permisos
    );
    
    @WebResult(name = "ObtenerUsuariosv2Result", targetNamespace = "http://intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuariosv2", action = "http://intranet.osde/ObtenerUsuariosv2")
    public String obtenerUsuariosv2(
        @WebParam(name = "permisos", targetNamespace = "http://intranet.osde/")
        String permisos
    );

    @WebResult(name = "ObtenerListadoDePermisosResult", targetNamespace = "http://intranet.osde/")
    @WebMethod(operationName = "ObtenerListadoDePermisos", action = "http://intranet.osde/ObtenerListadoDePermisos")
    public String obtenerListadoDePermisos(
        @WebParam(name = "permiso", targetNamespace = "http://intranet.osde/")
        String permiso
    );

    @WebResult(name = "ObtenerFilialesDePermisoResult", targetNamespace = "http://intranet.osde/")
    @WebMethod(operationName = "ObtenerFilialesDePermiso", action = "http://intranet.osde/ObtenerFilialesDePermiso")
    public String obtenerFilialesDePermiso(
        @WebParam(name = "permiso", targetNamespace = "http://intranet.osde/")
        String permiso
    );

    @WebResult(name = "ObtenerUsuariosFilialResult", targetNamespace = "http://intranet.osde/")
    @WebMethod(operationName = "ObtenerUsuariosFilial", action = "http://intranet.osde/ObtenerUsuariosFilial")
    public String obtenerUsuariosFilial(
        @WebParam(name = "permisos", targetNamespace = "http://intranet.osde/")
        String permisos,
        @WebParam(name = "filial", targetNamespace = "http://intranet.osde/")
        String filial
    );
}
