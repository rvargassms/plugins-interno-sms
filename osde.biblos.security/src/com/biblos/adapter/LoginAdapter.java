package com.biblos.adapter;

import ar.com.osde.framework.entities.user.Permission;
import com.dotmarketing.exception.DotDataException;
import com.liferay.portal.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginAdapter {


	/**
	 * Loguea el usuario utilizando los datos registrados dentro de DotCmS
	 * @param userDot
	 * @param permissions
	 * @param req
	 * @param res
	 * @param doBackendLogin
	 * @return
	 */
	public boolean doLogin(User userDot, List<Permission> permissions, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin);


	/**
	 * Login a userIntranet into dotCMS
	 * @throws DotDataException, DotSecurityException
	 * */
	public boolean doLogin(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario userESB, List<Permission> permissions , HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception;


	public boolean doLogin(String username, List<Permission> permissions , HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception;


	public boolean doLogin(String username, HttpServletRequest req, HttpServletResponse res, boolean doBackendLogin) throws Exception;
	
/*	public UserAdapter getUserAdapter();*/
	
	/**
     * Checks whether or not a user is logged in session
     * */
	public boolean isLoggedIn(HttpSession ses);
		
	//public String getUsernameFromHeader(HttpServletRequest reqHttp);
	//public String[] getCookiesFromHeader(HttpServletRequest reqHttp);
}
