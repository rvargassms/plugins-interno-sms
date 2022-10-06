/*
 * Flux IT Argentina
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Martin Zanotti
 * Date:  28/11/2014 - 14:49:03
 */
package com.biblos.filters.interceptor;
/**
 * @author Martin Zanotti
 * 
 */
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.dotmarketing.util.Logger;
import com.biblos.commons.CustomDBParametersLoader;
import com.biblos.commons.loader.CommonsProcessSpringLoader;
import com.biblos.loader.ProccessSpringContextLoader;
import com.biblos.utils.CookieUtil;
import com.biblos.utils.LoginUrlUtils;
import com.biblos.bo.LoginBo;
import com.biblos.bo.impl.LoginBoImpl;


public class LoginOsdeInterceptor implements Filter {
	
	private LoginBo loginBo;
   
	public LoginOsdeInterceptor() {
		super();
		this.doLog("LoginFilter creado",false,false,null);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		LoginUrlUtils.getAllPropertiesLoginOsde();
		loginBo = new LoginBoImpl();
		iniciarCron();
	}
	
	private void iniciarCron() {
		if(LoginUrlUtils.getCRON_ENABLED()){
			this.doLog("Iniciando CRON", false, false, null);
			try {
				ProccessSpringContextLoader.init();
				CommonsProcessSpringLoader.init();
			} catch (Exception e) {
				this.doLog("La inicialización del ProccessSpringContextLoader falló",false,true,e);
			}
		}else{
			this.doLog("CRON deshabilitado", false, false, null);
		}
	}

	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		HttpServletRequest reqHttp = (HttpServletRequest) request;
		HttpServletResponse resHttp = (HttpServletResponse) response;
		HttpSession session= reqHttp.getSession();
		String url = reqHttp.getRequestURI().toString();

		resHttp.addHeader("Access-Control-Allow-Origin", "*");
		resHttp.addHeader("Access-Control-Allow-Credentials","true");
		
		/// mludeiro
		if( url.matches( "(/html/|/dotAdmin/).*(.js|.html|.gif|.png|.css)") ) {
			chain.doFilter( request, response );
			return;
		}
		resHttp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
	    resHttp.setHeader("Pragma", "no-cache");
	    this.doLog("LoginFilter checkear url: "+url,true,false,null);
	    
	    //String[] cookies = loginBo.getCookiesFromHeader(reqHttp);
		//String username = loginBo.getUsernameFromCookies(cookies);
		
	    CookieUtil cookieUtil = new CookieUtil();
	    cookieUtil.obtenerUsernameClave(reqHttp);
	    
	    //Matchear url
    	if (isUrlExcluded(url) || (url.contains(LoginUrlUtils.getADMIN_URL() + "/") && cookieUtil.getUsername() != null)) {
    		this.doLog("LoginFilter url skipeada: "+url,true,false,null);
    		chain.doFilter( request, response );
    		return;
    	}
    	this.doLog("LoginFilter url validada: "+url,true,false,null);
    	boolean backendLogin= url.compareTo(LoginUrlUtils.getADMIN_URL()) == 0 || url.compareTo(LoginUrlUtils.getADMIN_REDIRECT_URL()) == 0;
		
		//Verificar si usuario esta logueado o requiere loguearse como administrador
		if (!loginBo.isLoggedIn(session) || backendLogin) {
			boolean logged = false;
			try {
				logged = loginBo.doLogin(reqHttp,resHttp,backendLogin, cookieUtil);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!logged){ 
				resHttp.sendRedirect(LoginUrlUtils.getREDIRECT_URL_AFLTER_LOGIN_FAILED());
				return;
			}
		}
		
    	chain.doFilter(request, response);		
	}
       
	/**
     * This method match urls that ends in .html or without any extension
     * in order to filter undesired url like those finalized in .css, .png, etc.
     * */
    private boolean isUrlExcluded(String url){ 
    	if(url.compareTo(LoginUrlUtils.getLOGIN_POINT())==0) return true;
    	if(url.compareTo(LoginUrlUtils.getREDIRECT_URL_AFLTER_LOGIN_FAILED())==0) return true;
    	Pattern p;
    	Matcher m;
    	for(String excluded: LoginUrlUtils.getEXCLUDE_URLS()){
    		p = Pattern.compile(excluded, Pattern.CASE_INSENSITIVE);
        	m = p.matcher(url);
        	if(m.matches())return true;
        	//if(url.compareTo(excluded)==0)return true;
    	}
    	//Patron verifica si la url finaliza en .html o sin extension, a modo de exlcuir urls como .css, .png, etc.
    	p = Pattern.compile("^[^.]*(\\.html|)$", Pattern.CASE_INSENSITIVE);
    	m = p.matcher(url);
    	return !m.matches();
    }
    
	private void doLog ( String message , boolean debugOnly, boolean warning, Throwable e) {
        if(warning)Logger.warn(LoginOsdeInterceptor.class,"::: "+ message +" :::", e);
        else Logger.info(LoginOsdeInterceptor.class,"::: "+ message +" :::");
    }
	public LoginBo getLoginBo() {
		return loginBo;
	}
	public void setLoginBo(LoginBo loginBo) {
		this.loginBo = loginBo;
	}
}