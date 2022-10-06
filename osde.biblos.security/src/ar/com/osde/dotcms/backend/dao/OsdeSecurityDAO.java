package ar.com.osde.dotcms.backend.dao;

import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.persistence.dao.DataAccessObject;

import java.util.List;

/**
 * @author ss94848846
 */
public interface OsdeSecurityDAO extends DataAccessObject {

    /**
     * Recupera todos los usuarios que tengan el permiso pasado
     * @param permiso
     * @return
     */
    List<Usuario> getUsuariosConPermiso(String permiso);

    /**
     * Obtener detalles del permiso (incluso lista de usuarios)
     * @param permiso
     * @return
     */
    PermisosDTO getPermisoDTO(String permiso);

    /**
     * @deprecated
     * Obtener usuario teniendo en cuenta los fallos de los requests a la intranet
     * @param user
     * @return
     */
    Usuario getUserConReintentos(UsuarioDTO user);

    /**
     * Recupera todos los permisos que tiene un determinado usuario para un aplicación específica pasada por parámetro
     * @param usuarioIntranet
     * @param applicationName
     * @return
     */
    List<Permission> getPermisosDeUsuario(String usuarioIntranet, String applicationName);

    /**
     * Recupera el usuario y sus datos personales del servicio del ESB usando el username en la intranet
     * @param idIntranet
     * @return
     */
    Usuario getUserByMT(String idIntranet);

    /**
     * Recupera el usuario y sus datos personales del servicio del ESB usando el dni del usuario
     * @param dni
     * @return
     */
    Usuario getUserByDNI(String dni);
    
    public Empleado getEmployeeHasRetries(UsuarioDTO user);
    
	public String getFilesUploadPath();
}
