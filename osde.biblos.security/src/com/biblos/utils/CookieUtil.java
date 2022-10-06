package com.biblos.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	
	private String username = null;
	private String clave = null;
	private String cookieName = null;
	
//	public static String getClaveFromCookies(String[] cookies) {
//		if (cookies == null || cookies.length == 0)return null;
//		
//		for(int i = 0; i < cookies.length; i++){
//			
//			String[] cookie = cookies[i].split("=");
//
//			for (int e = 0; e < cookie.length; e++) {
//				if(!cookie[e].contains("clave")) continue;
//				if(cookie[e].contains("clave")) {
//					String param0 = cookie[e];
//					String param1 = cookie[e+1];
//					if (LoginUrlUtils.getKEY_COOKIE_CLAVE().equalsIgnoreCase(param0)) return param1;
//				}
//			}
//		}
//		
//		return null;
//	}
	
	public boolean obtenerUsernameClave(HttpServletRequest reqHttp) {
		Cookie[] cookies = reqHttp.getCookies();
		
		//FIXME A cookie associated with a cross-site resource at https:// that was set without the `username` attribute. A future release of buscador will sent requests are set with header parameter`username=ssxxxxxxxx`
		if(cookies == null || cookies.length == 0) {
			this.username = reqHttp.getHeader("username");
		}
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().startsWith("intranet")) {
				this.cookieName = cookie.getName();
				String[] values = cookie.getValue().split("&");
				for (String value : values) {					
					if (value.startsWith(LoginUrlUtils.getKEY_COOKIE_CLAVE())) {
						this.clave = value.split("=")[1];						
					}
					else if (value.startsWith(LoginUrlUtils.getKEY_COOKIE_NAME())) {
						this.username = value.split("=")[1];						
					}
					
					if (this.clave != null && this.username != null) {
						break;
					}
				}
				
				if (this.clave != null && this.username != null) {
					break;
				}
			}
		}
		
		return this.clave != null && this.username != null;
	}

	public String getUsername() {
		return username;
	}	

	public String getClave() {
		return clave;
	}

	public String getCookieName() {
		return cookieName;
	}	
	
}
