package ar.com.osde.dotcms.backend.bo.impl;

import ar.com.osde.dotcms.backend.bo.OsdeSecurityBO;
import ar.com.osde.dotcms.backend.dao.OsdeSecurityDAO;
import ar.com.osde.dotcms.backend.dtos.PermisosDTO;
import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;
import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.entities.empleado.Empleado;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.business.exception.BusinessIntranetServiceException;
import ar.com.osde.framework.business.exception.BusinessXMLParsingException;
import ar.com.osde.framework.business.intranet.IntranetSecurityBO;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.entities.user.impl.UserIntranet;
import com.dotmarketing.util.Logger;
import org.dozer.Mapper;

import java.util.List;

/**
 * @author ss94848846
 */
public class OsdeSecurityBOImpl implements OsdeSecurityBO {

    private IntranetSecurityBO securityIntranet;
    private OsdeSecurityDAO osdeSecurityDAO;
    private Mapper mapper;
    private String applicationName;

    public String getFilesUploadPath() {
		return osdeSecurityDAO.getFilesUploadPath();
	}

	public final static String PERMISO_INTRANET_OSDE_BIBLOS = "GRGDOTCMS-INGINTRA-VIS";

    /**
     * Recupera un usuario de la intranet
     *
     * @param username
     * @return
     * @throws BusinessException
     */
    @Override
    public Usuario getUserIntranet(String username) throws BusinessException {
        if(username != null && "".compareTo(username) != 0){
        	
            Usuario currentUser = this.getOsdeSecurityDAO().getUserByMT(username.toLowerCase());

            if(currentUser == null) Logger.warn(this, "No se encontró el usuario");
            return currentUser;
        }else{
            Logger.warn(this, "No sé especificó el nombre de usuario correctamente");
        }
        return null;
    }

    /**
     * Recupera los datos de un usuario mediante clave
     *
     * @param applicationName
     * @param cookieKey
     * @return UserIntranet
     * @throws BusinessException
     */
    @Override
    public UserIntranet loginByCookie(String applicationName, String cookieKey) throws BusinessException{
        UserIntranet currentUser = null;

        if ((applicationName != null && "".compareTo(applicationName) != 0)
            && (cookieKey != null && "".compareTo(cookieKey) != 0)) {

            try {
                currentUser = securityIntranet.loginByKey(applicationName, cookieKey);
            } catch (BusinessIntranetServiceException e) {
                e.printStackTrace();
                throw new BusinessException(e);
            } catch (BusinessXMLParsingException e) {
                Logger.error(this, e.getMessage(), e);
                throw new BusinessException(e);
            }

            if(currentUser == null) {
                Logger.warn(this, "No sé encontró el usuario");
            }
            return currentUser;
        }else{
            Logger.warn(this, "No sé especificó el nombre de usuario correctamente");
        }
        return null;
    }

    /**
     * Recupera los usuarios con el permiso "GRGDOTCMS-INGINTRA-VIS" de la intranet
     *
     * @return
     * @throws BusinessException
     */
    @Override
    public List<Usuario> getUsuariosConPermisosDeAcceso() throws BusinessException {
        Logger.info(this, "Se obtienen los usuarios que tengan el permiso GRGDOTCMS-INGINTRA-VIS");
        try {
            return this.getOsdeSecurityDAO().getUsuariosConPermiso(PERMISO_INTRANET_OSDE_BIBLOS);
        }catch( Exception e){
            Logger.error(this, e.getMessage(), e);
            throw new BusinessException();
        }

    }

    /**
     * Recupera los permisos de un usuario para la aplicación Biblos
     *
     * @param idIntranet
     * @return
     * @throws BusinessException
     */
    @Override
    public List<Permission> getPermisosDeUsuario(String idIntranet) throws BusinessException {
        Logger.info(this, "Se obtienen los permisos para el usuario: " + idIntranet + " para la aplicación: " + this.getApplicationName());
        try{
            return this.getOsdeSecurityDAO().getPermisosDeUsuario(idIntranet, this.getApplicationName());
        }catch(Exception e){
            Logger.error(this, e.getMessage(), e);
            throw new BusinessException();
        }
    }

    /**
     * Obtiene el permiso DTO
     *
     * @param permiso
     * @return
     */
    @Override
    public PermisosDTO getPermisoDTO(String permiso) {
        return this.getOsdeSecurityDAO().getPermisoDTO(permiso);
    }

    /**
     * @deprecated
     * Obtiene el usuario con reintentos
     *
     * @param user
     * @return
     */
    @Override
    public Usuario getUserConReitentos(UsuarioDTO user) {
        return this.getOsdeSecurityDAO().getUserConReintentos(user);
    }

    public Empleado getEmployeeHasRetries(UsuarioDTO user) {
    	return this.getOsdeSecurityDAO().getEmployeeHasRetries(user);
    }

    public IntranetSecurityBO getSecurityIntranet() {
        return securityIntranet;
    }

    public void setSecurityIntranet(IntranetSecurityBO securityIntranet) {
        this.securityIntranet = securityIntranet;
    }

    public OsdeSecurityDAO getOsdeSecurityDAO() {
        return osdeSecurityDAO;
    }

    public void setOsdeSecurityDAO(OsdeSecurityDAO osdeSecurityDAO) {
        this.osdeSecurityDAO = osdeSecurityDAO;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
