package com.biblos.content;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.dotmarketing.beans.Permission;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.Permissionable;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.htmlpageasset.model.IHTMLPage;
import com.dotmarketing.util.Logger;

public class ContentConfiguration {
	
	public static final	String INDEX_NAME				= "osde";
	public static final int 	SHARDS					= 1;
	public static final int 	REPLICAS				= 1;
	public static final String OSDE_SETTING_JSON_NAME 	= "es-osde-settings.json";
	public static final String OSDE_MAPPING_JSON_NAME 	= "es-osde-mapping";
	public static final String HTMLPAGE_MAPPING_NAME 	= "page";
	public static final String CONTENTLET_MAPPING_NAME  = "content";
	
	private static Properties properties;
    
	static{
		properties = new Properties();
		InputStream input = null;
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("biblos-dotcms-index.properties"));
		} catch (IOException e) {
			Logger.error(ContentConfiguration.class, e.getMessage(), e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					Logger.error(ContentConfiguration.class, e.getMessage(), e);
				}
			}
		}	
	}
	
	public static Properties getProperties(){
		return properties;
	}
	
	public static Set<String> getPermissions(Permissionable permissionable) throws Exception {
		List<Permission> permissions = APILocator.getPermissionAPI().getPermissions(permissionable);
		Set<String> perms = new LinkedHashSet<String>();
		for(Permission p: permissions){
			perms.add(APILocator.getRoleAPI().loadRoleById(p.getRoleId()).getName());
		}
		return perms;
	}
	public static Map<String,Object> getMappingFor(IHTMLPage page,String host) throws Exception {
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("pageId", page.getIdentifier());
			json.put("host",host);
			json.put("pageTitle",page.getTitle());
			json.put("metadata", page.getMetadata());
			json.put("uri", page.getURI());
			json.put("url", page.getPageUrl());
			return json;
	}
	
	public static Map<String,Object> getMappingFor(Contentlet content,String hostName, List<Map<String, Object>> references) throws Exception {
		
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("host",hostName);
		json.put("contentInode",content.getInode());
		json.put("contentId",content.getIdentifier());
		json.put("title", content.getTitle());
		json.put("administrativeTitle","");
		json.put("body",content.get("body"));
		json.put("metadata", content.get("metadata"));
		json.put("permissions", ContentConfiguration.getPermissions(content));
		json.put("references", references);
		return json;
	}
	
	
}
