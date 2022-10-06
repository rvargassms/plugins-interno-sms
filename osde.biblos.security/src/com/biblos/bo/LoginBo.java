package com.biblos.bo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biblos.utils.CookieUtil;

public interface LoginBo {
	
	/**
	 * Get OSDE user name from Cookies, login the user into dotCMS and set permissions.
	 * @return Boolean, whether or not could login user into dotCMS.
	 * */
	public boolean doLogin(HttpServletRequest reqHttp, HttpServletResponse resHttp,boolean doBackendLogin, CookieUtil cookieUtil) throws Exception;		
	public boolean isLoggedIn(HttpSession ses);
	//public String[] getCookiesFromHeader(HttpServletRequest reqHttp);
	//public String getUsernameFromHeader(HttpServletRequest reqHttp);
}
