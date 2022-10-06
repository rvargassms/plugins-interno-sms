package com.biblos.adapter.impl;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.framework.entities.user.Permission;
import com.biblos.adapter.LoginAdapter;
import com.biblos.bo.impl.PermisosBOImpl;
import com.biblos.utils.AuthorizationPropertyUtils;
import com.biblos.utils.LoginUrlUtils;
import com.dotcms.cms.login.LoginServiceAPIFactory;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.*;
import com.dotmarketing.business.web.WebAPILocator;
import com.dotmarketing.cms.factories.PublicEncryptionFactory;
import com.dotmarketing.cms.login.factories.LoginFactory;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.factories.PreviewFactory;
import com.dotmarketing.util.Logger;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.util.WebKeys;
import com.liferay.portal.ejb.UserManagerUtil;
import com.liferay.portal.events.EventsProcessor;
import com.liferay.portal.model.User;
import com.liferay.portal.util.CookieKeys;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Clase responsable de autenticar usuario obtenido desde la intranet contra la base de DotCMS
 */
public class LoginAdapterImpl implements LoginAdapter {

	private UserAPI userAPI;

	/**
	 * Agregamos como una depedencia de Autenticación UserAPI propia del framework de DotCMS
	 */
	public LoginAdapterImpl() {
		userAPI = new UserAPIImpl();
		AuthorizationPropertyUtils.getAllPropertiesAuthorization();
	}

	/**
	 * Loguea el usuario
	 *
	 * @param user
	 * @param permissions
	 * @param req
	 * @param res
	 * @param doBackendLogin
	 * @throws DotDataException, DotSecurityException
	 */
	@Override
	public synchronized boolean doLogin(User user, List<Permission> permissions, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) {
		try {
			/** Chequeamos si el usuario tiene permisos para acceder al backend**/
			boolean hasBackendPermission = false;

			/** Hacemos el login utilizando el correo del usuario **/
			String email = user.getEmailAddress();

			/** @TODO Llevar esta funcionalidad al módulo de autorización **/
			String roleAdminFqn = AuthorizationPropertyUtils.getOsdeParentRole() + " --> "+AuthorizationPropertyUtils.getAdminRole();
			Role roleAdmin = APILocator.getRoleAPI().findRoleByFQN(roleAdminFqn);

			if(APILocator.getRoleAPI().doesUserHaveRole(user, roleAdmin)){
				hasBackendPermission= true;
			}
			/** --- **/
			
			boolean loginOk = false;

			if(doBackendLogin){
				if(hasBackendPermission){
					loginOk = LoginFactory.doLogin(email, email, false, req, res);

					this.setBackendSessionVariables(req, res);
				}else{
					LoginServiceAPIFactory.getInstance().getLoginService().doActionLogout(req, res);
					return true;
				}
			}
			return loginOk ? loginOk : LoginFactory.doLogin(email,email,false,req,res);
		} catch (Exception e) {
			Logger.error(this, "No se pudo encontrar role por identificador FQN");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Login recupera datos desde DotCMS con un usuario de tipo Usuario
	 *
	 * @param userESB
	 * @param permissions
	 * @param req
	 * @param res
	 * @param doBackendLogin
	 * @throws DotDataException, DotSecurityException
	 */
	@Override
	public boolean doLogin(Usuario userESB, List<Permission> permissions, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception {
		Logger.info(LoginAdapterImpl.class, "::: "+ "usuariosss: " + userESB +" :::");
		User user = userAPI.loadUserById(userESB.getUsername());
		return this.doLogin(user, permissions, req, res, doBackendLogin);
	}

	/**
	 * Login recupera datos del usuario en caso de que haya fallado el login con la intranet
	 * @param username
	 * @param permissions
	 * @param req
	 * @param res
	 * @param doBackendLogin
	 * @return
	 * @throws Exception
	 */
	@Override
	public synchronized boolean doLogin(String username, List<Permission> permissions, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception {
		User user = userAPI.loadUserById(username);
		if(user == null) return false;

		return this.doLogin(user, permissions, req, res, doBackendLogin);
	}

	/**
	 * Login recupera los datos del usuario sin incluir los permisos
	 * @param username
	 * @param req
	 * @param res
	 * @param doBackendLogin
	 * @return
	 */
	@Override
	public synchronized boolean doLogin(String username, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception {

		/**
		 * En caso de fallar buscar username en la intranet buscar en DotCMS
		 */
		try {
			User user = userAPI.loadUserById(username);

			if(user == null) return false;

			return this.doLogin(username,null, req,res,doBackendLogin);

		} catch (DotDataException | DotSecurityException | NullPointerException e) {
			Logger.info(this, "No fue posible recuperar usuario con username " + username + "desde Dot");
			e.printStackTrace();
		}
		return false;
	}
	
	private void setBackendSessionVariables(HttpServletRequest request,HttpServletResponse response) {
		
		try {

			/**
			 * Busca datos del usuario a partir de la sessión CMS_USER
			 */
			User user = (User) request.getSession().getAttribute(WebKeys.CMS_USER);

			UserAPI userAPI = APILocator.getUserAPI();

			/**
			 * Verifica si el usuario está logueado en el backend
			 */
			boolean respectFrontend = WebAPILocator.getUserWebAPI().isLoggedToBackend(request);

			/**
			 * Setea el lenguaje utilizado para español
			 */
			user.setLanguageId(LoginUrlUtils.getLOCALE_ES());
			userAPI.save(user, userAPI.getSystemUser(), respectFrontend);

			request.getSession().setAttribute(com.liferay.portal.util.WebKeys.USER_ID, user.getUserId());
			request.getSession().setAttribute(com.liferay.portal.util.WebKeys.USER, user);
			PreviewFactory.setVelocityURLS(request);
			
			try{
				String domainName = request.getServerName();
				Host h = null;

				/**
				 * Busca el host a partir del nombre del domínio donde está el usuario
				 */
				h = APILocator.getHostAPI().findByName(domainName, user, false);


				/**
				 * Si ningún host fue seleccionado entonces setea uno a partir del Alias del host
				 */
				if(h == null || !UtilMethods.isSet(h.getInode())){
					h = APILocator.getHostAPI().findByAlias(domainName, user, false);
				}

				/**
				 * En el caso de que encuentre el host agrega a la sessión el HOST seleccionado
				 */
				if(h != null && UtilMethods.isSet(h.getInode())){
					request.getSession().setAttribute(com.dotmarketing.util.WebKeys.CMS_SELECTED_HOST_ID, h.getIdentifier());
				}else{
					request.getSession().setAttribute(com.dotmarketing.util.WebKeys.CMS_SELECTED_HOST_ID, APILocator.getHostAPI().findDefaultHost(APILocator.getUserAPI().getSystemUser(), true).getIdentifier());
				}

			}catch (DotSecurityException se) {
				request.getSession().setAttribute(com.dotmarketing.util.WebKeys.CMS_SELECTED_HOST_ID, APILocator.getHostAPI().findDefaultHost(APILocator.getUserAPI().getSystemUser(), true).getIdentifier());
			}
						
			request.getSession().removeAttribute("_failedLoginName");

			/**
			 * Datos almacenados en la cookie
			 */
			Cookie idCookie = new Cookie(CookieKeys.ID,UserManagerUtil.encryptUserId(user.getUserId()));
			idCookie.setPath("/");

			idCookie.setMaxAge(0);
			
			response.addCookie(idCookie);

			EventsProcessor.process(PropsUtil.getArray(PropsUtil.LOGIN_EVENTS_PRE), request, response);
			EventsProcessor.process(PropsUtil.getArray(PropsUtil.LOGIN_EVENTS_POST), request, response);

			List<Layout> userLayouts;
			userLayouts = APILocator.getLayoutAPI().loadLayoutsForUser(user);
			if ((userLayouts == null) || (userLayouts.size() == 0) || !UtilMethods.isSet(userLayouts.get(0).getId())) {
				throw new Exception("RequiredLayoutException");
			}
			java.util.Map<String, String[]> params = new java.util.HashMap<String, String[]>();

			params.put("struts_action",new String[] {"/ext/director/direct"});
			
		} catch (Exception e) {
		}
	}

//	@Override
//	public String[] getCookiesFromHeader(HttpServletRequest reqHttp) {
//		String cookies = StringUtils.isNotEmpty(reqHttp.getHeader("Cookie")) ? reqHttp.getHeader("Cookie") : reqHttp.getHeader("Set-Cookie");
//		if (cookies==null || !cookies.contains("intranet")) {
//			return null;
//		}
//		
//		cookies = cookies.substring(cookies.indexOf("intranet") + 9, cookies.length());
//		if (StringUtils.isNotEmpty(cookies)) {
//			return cookies.split("&");
//		} else {
//			return null;
//		}
//	}


//	@Override
//	public String getUsernameFromCookies(String[] cookies) {
//		if (cookies == null || cookies.length == 0)return null;
//		
//		for(int i = 0; i < cookies.length; i++){
//			
//			String[] cookie = cookies[i].split("=");
//
//			for (int e = 0; e < cookie.length; e++) {
//				if(!cookie[e].contains("username")) continue;
//				if(cookie[e].contains("username")) {
//					String param0 = cookie[e];
//					String param1 = cookie[e+1];
//					System.out.println( "param0 :" + param0 + " ,param1:" +param1 );
//					System.out.println( " param1:" +param1.replace("; intranet", "") );
//					
//					if (LoginUrlUtils.getKEY_COOKIE_NAME().equalsIgnoreCase(param0)) return param1.replace("; intranet", "");
//				}
//			}
//		}
//		
//		return null;
//	}
	
	@Override
	public boolean isLoggedIn(HttpSession ses) {
		return ses.getAttribute(WebKeys.CMS_USER) != null;
	}

//	@Override
//	public String getUsernameFromHeader(HttpServletRequest reqHttp) {
//		String[] cookies = this.getCookiesFromHeader(reqHttp);
//		//FIXME A cookie associated with a cross-site resource at https:// that was set without the `username` attribute. A future release of buscador will sent requests are set with header parameter`username=ssxxxxxxxx`
//		if(cookies == null || cookies.length == 0) {
//			String username = reqHttp.getHeader("username");
//			return username;
//		}
//
//		for(int i = 0; i < cookies.length; i++){
//			
//			String[] cookie = cookies[i].split("=");
//
//			for (int e = 0; e < cookie.length; e++) {
//				if(!cookie[e].contains("username")) continue;
//				if(cookie[e].contains("username")) {
//					String param0 = cookie[e];
//					String param1 = cookie[e+1];
//					System.out.println( "param0 :" + param0 + " ,param1:" +param1 );
//					System.out.println( " param1:" +param1.replace("; intranet", "") );
//					
//					if (LoginUrlUtils.getKEY_COOKIE_NAME().equalsIgnoreCase(param0)) return param1.replace("; intranet", "");
//				}
//			}
//
//		}
//
//		return null;
//	}
}
