package ar.com.osde.dotcms.external.services;


import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.entities.user.impl.UserIntranet;
import ar.com.osde.framework.services.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * @author ss94848846
 */
@WebService
public interface OsdeSecurityExternalService extends Service {

    /**
     * Recupera un usuario de la intranet
     * @param username
     * @return UserIntranet
     * @throws Exception
     */
    Usuario getUserIntranet(String username) throws Exception;

    /**
     * Recupera los usuarios con permiso de intranet de DOTCMS en la intranet
     * @return
     * @throws Exception
     */
    List<Usuario> getUsuariosDotCMS() throws Exception;

    /**
     * Recupera los permisos para Biblos de un determinado usuario en la intranet
     * @param username
     * @return
     * @throws Exception
     */
    List<Permission> getPermisosDeUsuario(String username) throws Exception;

    /**
     * Recupera los permisos de un usuario para la aplicación Biblos.
     * @param permiso
     * @return
     */
    PermisosDTO getPermisoDTO(String permiso);

    /**
     * Obtiene usuario con reintentos
     * @param user
     * @return
     */
    Usuario getUserConReintentos(UsuarioDTO user);
    
    public Empleado getEmployeeHasRetries(UsuarioDTO user);
    
    public String getFilesUploadPath();
    
    public UserIntranet loginByCookie(String applicationName, String cookieKey) throws BusinessException;
    
}