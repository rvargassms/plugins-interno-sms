package com.biblos.utils;

import com.biblos.loader.AuthenticationPropertiesLoader;
import com.dotmarketing.util.Logger;

import java.util.Properties;

public class LoginUrlUtils {
	
	private static String LOGIN_POINT;
	private static String REDIRECT_URL_AFLTER_LOGIN_FAILED;
	private static String[] EXCLUDE_URLS;
	private static String ADMIN_URL;
	private static String ADMIN_REDIRECT_URL;
	private static String URL_WITH_HTML_OR_WITHOUT_EXTENSION;
	private static String URL_WITH_ASSETS_EXTENSIONS;
	private static String KEY_COOKIE_NAME;
	private static String KEY_COOKIE_CLAVE;
	private static String LOCALE_ES;
	private static Boolean CRON_ENABLED;
	
	public static void getAllPropertiesLoginOsde() { 
		Properties properties = AuthenticationPropertiesLoader.loadAllProperties();
		try {
		LOGIN_POINT = AuthenticationPropertiesLoader.getProperty(properties, "loginPointUrl");
		REDIRECT_URL_AFLTER_LOGIN_FAILED = AuthenticationPropertiesLoader.getProperty(properties, "redirectUrlAfterLoginFailed");
		ADMIN_URL = AuthenticationPropertiesLoader.getProperty(properties, "adminUrl");
		ADMIN_REDIRECT_URL = AuthenticationPropertiesLoader.getProperty(properties, "adminRedirectUrl");
		URL_WITH_HTML_OR_WITHOUT_EXTENSION = AuthenticationPropertiesLoader.getProperty(properties, "urlWithHTMLOrWithoutExtension");
		URL_WITH_ASSETS_EXTENSIONS = AuthenticationPropertiesLoader.getProperty(properties, "urlWithAssetsExtensions");
		EXCLUDE_URLS = AuthenticationPropertiesLoader.getProperty(properties, "exludedUrls").split(",");
		KEY_COOKIE_NAME = "username";
		KEY_COOKIE_CLAVE = "clave";
		LOCALE_ES = "es_ES";
		CRON_ENABLED = Boolean.parseBoolean(AuthenticationPropertiesLoader.getProperty(properties, "cronEnabled"));
		
		cleanSpacesExcludedUrls(EXCLUDE_URLS);
		
		} catch(Exception ex) {
			Logger.error(LoginUrlUtils.class, ex.getMessage());
		}
		
		
	}

	
	public static Boolean getCRON_ENABLED() {
		return CRON_ENABLED;
	}


	public static void setCRON_ENABLED(Boolean cRON_ENABLED) {
		CRON_ENABLED = cRON_ENABLED;
	}


	private static void cleanSpacesExcludedUrls(String[] EXCLUDE_URLS) {
		
		if(EXCLUDE_URLS != null && EXCLUDE_URLS.length > 0) {
			for (int i = 0; i < EXCLUDE_URLS.length; i++) {
				EXCLUDE_URLS[i]= EXCLUDE_URLS[i].trim();
			}
		}
		
	}

	public static String getURL_WITH_HTML_OR_WITHOUT_EXTENSION() {
		return URL_WITH_HTML_OR_WITHOUT_EXTENSION;
	}

	public static String getURL_WITH_ASSETS_EXTENSIONS() {
		return URL_WITH_ASSETS_EXTENSIONS;
	}

	public static String getLOGIN_POINT() {
		return LOGIN_POINT;
	}

	public static String getREDIRECT_URL_AFLTER_LOGIN_FAILED() {
		return REDIRECT_URL_AFLTER_LOGIN_FAILED;
	}

	public static String[] getEXCLUDE_URLS() {
		return EXCLUDE_URLS;
	}

	public static String getADMIN_URL() {
		return ADMIN_URL;
	}

	public static String getADMIN_REDIRECT_URL() {
		return ADMIN_REDIRECT_URL;
	}

	public static String getKEY_COOKIE_NAME() {
		return KEY_COOKIE_NAME;
	}

	public static String getKEY_COOKIE_CLAVE() {
		return KEY_COOKIE_CLAVE;
	}

	public static String getLOCALE_ES(){ return LOCALE_ES;}
}
