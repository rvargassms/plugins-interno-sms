package com.biblos.bo.impl;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;
import ar.com.osde.dotcms.framework.resources.OsdeFrameworkServices;
import ar.com.osde.framework.entities.user.Permission;
import ar.com.osde.framework.entities.user.impl.UserIntranet;

import com.biblos.adapter.LoginAdapter;
import com.biblos.adapter.impl.LoginAdapterImpl;
import com.biblos.adapter.impl.UserAdapterImpl;
import com.biblos.adapter.UserAdapter;
import com.biblos.bo.LoginBo;
import com.biblos.entities.IngresoEntity;
import com.biblos.reportes.ReporteIngreso;
import com.biblos.utils.CookieUtil;
import com.dotmarketing.util.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.List;
import com.liferay.portal.model.User;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * Clase responsable por consumir el servicio de OSDE para autenticar el usuario
 */
public class LoginBoImpl implements LoginBo {

	private LoginAdapter loginBiblosAdapter;
	private OsdeSecurityExternalService osdeSecurityExternalService;
	private UserAdapter userAdapter;

	/**
	 * El login se hace a partir de los datos que encontramos en DotCMS
	 */
	private static boolean LOGIN_DIRECT_ON_INTRANET = false;

	public LoginBoImpl() {
		loginBiblosAdapter = new LoginAdapterImpl();
		osdeSecurityExternalService = OsdeFrameworkServices.OsdeSecurityExternalService();
		userAdapter = new UserAdapterImpl();
	}
	
	@Override
	public boolean doLogin(HttpServletRequest reqHttp, HttpServletResponse resHttp, boolean doBackendLogin, CookieUtil cookieUtil) throws Exception{
		Enumeration<String> headers = reqHttp.getHeaderNames();
		
		Logger.info(LoginBoImpl.class, "::: "+ "Contenido Headers" +" :::");
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			Logger.info(LoginBoImpl.class, "::: "+ name + " = " + reqHttp.getHeader(name) +" :::");
		}		

	    /**
	     * FIXME It is required to incorporate UserIntranet validation since it has the user's data logged in to the intranet.
	     * https://git.osde.ar/GestiondeAmbientesySoftware/proyectos-de-deploy/biblos20/general/-/issues/194 
	     */
		
		Logger.info(LoginBoImpl.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
		
		String username = ((UserIntranet)this.getOsdeSecurityExternalService().loginByCookie("GRGDOTCMS", cookieUtil.getClave())).getUserName();

		boolean logged = false;
		
		if(username == null){
			Logger.error(this, "No hay username de usuario configurado");
			return false;
		}

		if(!isServiceOsdeCreated()){
            Logger.error(this, "No fue posible iniciar el servicio de OSDE");
		}

		if(LOGIN_DIRECT_ON_INTRANET){
			Usuario userESB = null;
			try {
				System.out.println("usuario: " + username);
				userESB = this.getOsdeSecurityExternalService().getUserIntranet(username);
				List<Permission> permissions = this.getPermissionFromUser(username);
				logged = this.getLoginBiblosAdapter().doLogin(userESB, permissions, reqHttp, resHttp, doBackendLogin);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(!LOGIN_DIRECT_ON_INTRANET || !logged){
			logged = this.getLoginBiblosAdapter().doLogin(username, reqHttp, resHttp, doBackendLogin);
		}

		if(logged){
			User user = userAdapter.getUser(username);
 			ReporteIngreso.generarReporteIngreso(this.armarEntityIngreso(username, user.getFullName(), reqHttp.getHeader("User-Agent")));
 			
 			return true;
 		}

		return false;
	}

	private boolean isServiceOsdeCreated(){
		return (this.getOsdeSecurityExternalService() != null);
	}


    /**
     * Busca lista de permisos del usuario desde la Intranet
     * @param username
     * @return
     */
	private List<Permission> getPermissionFromUser(String username){
        // @TODO llevar este método para el plugin de autorización y inyectarlo aquí
		try {
			return this.getOsdeSecurityExternalService().getPermisosDeUsuario(username);
		} catch (Exception e) {
			Logger.error(this, "No se pudo recuperar permisos del usuario");
			e.printStackTrace();
			return null;
		}
	}

	public LoginAdapter getLoginBiblosAdapter(){
		return loginBiblosAdapter;
	}

	public void setLoginBiblosAdapter(LoginAdapter loginBiblosAdapter){
		this.loginBiblosAdapter = loginBiblosAdapter;
	}

	@Override
	public boolean isLoggedIn(HttpSession ses) {
		return loginBiblosAdapter.isLoggedIn(ses);
	}

//	@Override
//	public String[] getCookiesFromHeader(HttpServletRequest reqHttp) {
//		return loginBiblosAdapter.getCookiesFromHeader(reqHttp);
//	}
//
//	@Override
//	public String getUsernameFromHeader(HttpServletRequest reqHttp) {
//		return loginBiblosAdapter.getUsernameFromHeader(reqHttp);
//	}

//	@Override
//	public String getUsernameFromCookies(String[] cookies) {
//		return loginBiblosAdapter.getUsernameFromCookies(cookies);
//	}

    public OsdeSecurityExternalService getOsdeSecurityExternalService(){
	    return osdeSecurityExternalService;
    }

    public void setOsdeSecurityExternalService(OsdeSecurityExternalService osdeSecurityExternalService){
        this.osdeSecurityExternalService = osdeSecurityExternalService;
    }
    
    /**
	 * Persiste en el evento de login, 
	 * guardando los datos del usuario y la fecha del login.
	 */
	private IngresoEntity armarEntityIngreso(String username, String name, String userAgentString) {
		//Obtener informacion del browser y dispositivo usado
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
		
		Logger.info(LoginBoImpl.class, "Se pudo obtener userAgent desde userAgentString");
		
		IngresoEntity ingresoEntity = new IngresoEntity();
		ingresoEntity.setUsuarioMT(username);
		ingresoEntity.setUsuarioNombre(name);
		ingresoEntity.setNavegador(userAgent.getBrowser().getGroup().getName());
		ingresoEntity.setNavegadorVersion(userAgent.getBrowserVersion().getVersion());
		ingresoEntity.setSistemaOperativo(userAgent.getOperatingSystem().getName());
		ingresoEntity.setDispositivoIngreso(userAgent.getOperatingSystem().getDeviceType().getName());
		return ingresoEntity;
	}
}
