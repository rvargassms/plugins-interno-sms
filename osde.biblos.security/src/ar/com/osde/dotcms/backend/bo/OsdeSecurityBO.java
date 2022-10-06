package ar.com.osde.dotcms.backend.bo;

import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.framework.business.base.BusinessObject;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.entities.user.impl.UserIntranet;

import java.util.List;

/**
 * @author ss94848846
 */
public interface OsdeSecurityBO extends BusinessObject {

    /**
     * Recupera un usuario de la intranet
     * @param username
     * @return
     * @throws BusinessException
     */
    Usuario getUserIntranet(String username) throws BusinessException;

    /**
     * Login de un usuario de la intranet a una aplicacion determinada por medio
     * de una cookie (key).
     * @param applicationName
     * @param cookieKey
     * @return UserIntranet
     * @throws BusinessException
     */
    UserIntranet loginByCookie(String applicationName, String cookieKey) throws BusinessException;

    /**
     * Recupera los usuarios con el permiso "GRGDOTCMS-INGINTRA-VIS" de la intranet
     * @return
     * @throws BusinessException
     */
    List<Usuario> getUsuariosConPermisosDeAcceso() throws BusinessException;

    /**
     * Recupera los permisos de un usuario para la aplicación Biblos
     * @param idIntranet
     * @return
     * @throws BusinessException
     */
    List<Permission> getPermisosDeUsuario(String idIntranet) throws BusinessException;

    /**
     * Obtiene el permiso DTO
     * @param permiso
     * @return
     */
    PermisosDTO getPermisoDTO(String permiso);

    /**
     * @deprecated
     * Obtiene el usuario con reintentos
     * @param user
     * @return
     */
    Usuario getUserConReitentos(UsuarioDTO user);
    
    public Empleado getEmployeeHasRetries(UsuarioDTO user);
    
    public String getFilesUploadPath();
    
}
