package ar.com.osde.dotcms.external.services.impl;

import ar.com.osde.dotcms.backend.bo.OsdeSecurityBO;
import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.entities.user.impl.UserIntranet;

import java.util.List;

/**
 * @author ss94848846
 */
public class OsdeSecurityExternalServiceImpl implements OsdeSecurityExternalService {

    private OsdeSecurityBO osdeSecurityBO;

    /**
     * Recupera un usuario de la intranet
     *
     * @param username
     * @return UserIntranet
     * @throws Exception
     */
    @Override
    public Usuario getUserIntranet(String username) throws Exception {
        return this.getOsdeSecurityBO().getUserIntranet(username);
    }

    /**
     * Recupera los usuarios con permiso de intranet de DOTCMS en la intranet
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Usuario> getUsuariosDotCMS() throws Exception {
        return this.getOsdeSecurityBO().getUsuariosConPermisosDeAcceso();
    }

    /**
     * Recupera los permisos para Biblos de un determinado usuario en la intranet
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> getPermisosDeUsuario(String username) throws Exception {
        return this.getOsdeSecurityBO().getPermisosDeUsuario(username);
    }

    /**
     * Recupera los permisos de un usuario para la aplicación Biblos.
     *
     * @param permiso
     * @return
     */
    @Override
    public PermisosDTO getPermisoDTO(String permiso) {
        return this.getOsdeSecurityBO().getPermisoDTO(permiso);
    }

    /**
     * @deprecated
     * Obtiene usuario con reintentos
     *
     * @param user
     * @return
     */
    @Override
    public Usuario getUserConReintentos(UsuarioDTO user) {
        return this.getOsdeSecurityBO().getUserConReitentos(user);
    }

    @Override
    public Empleado getEmployeeHasRetries(UsuarioDTO user) {
        return this.getOsdeSecurityBO().getEmployeeHasRetries(user);
    }


    public OsdeSecurityBO getOsdeSecurityBO() {
        return osdeSecurityBO;
    }

    public void setOsdeSecurityBO(OsdeSecurityBO osdeSecurityBO) {
        this.osdeSecurityBO = osdeSecurityBO;
    }

	@Override
	public String getFilesUploadPath() {
		return this.getOsdeSecurityBO().getFilesUploadPath();
	}
	
	public UserIntranet loginByCookie(String applicationName, String cookieKey) throws BusinessException {
		return this.getOsdeSecurityBO().loginByCookie(applicationName, cookieKey);
	}
}