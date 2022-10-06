package com.biblos.services.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.web.UserWebAPI;
import com.dotmarketing.business.web.WebAPILocator;
import com.dotmarketing.util.Logger;
import com.liferay.portal.model.User;
import com.biblos.bo.LoginBo;
import com.biblos.bo.impl.LoginBoImpl;
import com.dotcms.rest.WebResource;

import edu.emory.mathcs.backport.java.util.Arrays;

public abstract class OsdeService extends WebResource {
	
	protected static UserWebAPI userWebAPI;
	protected static User 	  systemUser;
	protected static Properties properties;
	protected static HashSet<String> searchBlacklist;
	protected static LoginBo	loginBo;
	protected static HashMap<String,String> hostIds;
	
	static{
		try {
			userWebAPI = WebAPILocator.getUserWebAPI();
			systemUser = userWebAPI.getSystemUser();
			loginBo	   = new LoginBoImpl();
			
			
		} catch (Exception e) {
			//Logger.error(SearchRestService.class," Error al cargar datos en ServiceHelper ", e);
		} 
	
	}
	protected LoginBo getLoginBo(){
		if(loginBo == null) {
			loginBo = new LoginBoImpl();
		}
		return loginBo; 
	}
	
	protected Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			InputStream input = null;
			try {
				properties.load(getClass().getClassLoader().getResourceAsStream("biblos-dotcms-rest.properties"));
			} catch (IOException e) {
				String msj = "Error al obtener el Properties";
				Logger.error(this, msj, e);
				throw new RuntimeException(msj + " -- " + e.getMessage());
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						String msj = "Error al cerrar InputStream";
						Logger.error(this, msj, e);
						throw new RuntimeException(msj + " -- " + e.getMessage());
					}
				}
			}
		}
		return properties;
	}
	
	protected boolean isInTestMode() {
		return this.getProperties().getProperty("TEST_MODE").compareTo("true")==0;
	}
	
	@SuppressWarnings("unchecked")
	protected HashSet<String> getSearchBlacklist(){
		if(searchBlacklist==null){
			String [] bl = this.getProperties().getProperty("SEARCHER_BLACKLIST").split(",");
			searchBlacklist =  new HashSet<String>( Arrays.asList(bl) );
		}
		return searchBlacklist;
	}
	
	protected List<String> parseJsonArray(JsonObject data, String field){
		JsonArray 	 jsonArray 	 = data.get(field).getAsJsonArray();
		List<String> list = new ArrayList<String>();
		for(JsonElement je: jsonArray)
			if(!StringUtils.isEmpty(je.getAsString())) list.add(je.getAsString());
		return list;
	}
	
	protected HashMap<String,String> getHostIds() throws Exception {
		if(hostIds==null){
			List<Host> 	 hosts =  APILocator.getHostAPI().findAll(systemUser, false);
			hostIds = new HashMap<String,String>();
			for(Host h: hosts) hostIds.put(h.getHostname(),h.getIdentifier());
		}
		return hostIds;
	}

	protected HashMap<String,List<String>> getHostsAndContainers(JsonObject data) throws Exception {
		HashMap<String, String> hostsIds = this.getHostIds();
		HashMap<String,List<String>> hostsAndContainers = new HashMap<String, List<String>>();
		JsonObject hostsAndContainersJson = data.get("hosts").getAsJsonObject();
		for(java.util.Map.Entry<String, JsonElement> entry: hostsAndContainersJson.entrySet()){
			if(!hostsIds.containsKey(entry.getKey())){
				Logger.error(this,"No se encontro hostID para "+entry.getKey());
				continue;
			}
			//String hostID = hostsIds.get(entry.getKey());
			hostsAndContainers.put(entry.getKey(),this.parseJsonArray(hostsAndContainersJson,entry.getKey()));
		}
		if(hostsAndContainers.isEmpty()) throw new Exception("No se configuro ningun host para la busqueda, la consulta retornará vacia.");
		return hostsAndContainers;
	}
	
	protected HashMap<String,Object> getAsHashMap(JsonObject data){
		HashMap<String,Object> hm = new HashMap<String,Object>();
		for(java.util.Map.Entry<String, JsonElement> entry: data.entrySet()){
			hm.put(entry.getKey(),entry.getValue().getAsString());
		}
		return hm;	
	}
	
	protected String[] getIndexes(JsonObject data){
		List<String> indexList = this.parseJsonArray(data,"indices");
		return indexList.toArray(new String[indexList.size()]);
	}
	

	protected HashMap<String,Object> getFilters(JsonObject data) {
		HashMap<String,Object> filters = new HashMap<String,Object>();
		JsonObject json = data.getAsJsonObject("filtros");
		for(Entry<String, JsonElement> field: json.entrySet()){
			HashMap<String,Object> conf = new HashMap<String, Object>();
			JsonObject jsonField = field.getValue().getAsJsonObject();
			String type = jsonField.get("type").getAsString();
			conf.put("type", type);
			if(type.compareTo("range")==0){
				conf.put("from",jsonField.get("from").getAsLong());
				conf.put("to",jsonField.get("to").getAsLong());
			}else{
				conf.put("values",this.parseJsonArray(jsonField, "values"));
			}
			filters.put(field.getKey(),conf);
		}
		return filters;
	}
	
	protected boolean useSuggestion(JsonObject data) {
		return data.get("usarSugerencia").getAsBoolean();
	}
	protected String getSearchWords(JsonObject data) {
		return data.get("busqueda").getAsString();
	}
	protected boolean useExactQuery(JsonObject data) {
		return data.get("busquedaExacta").getAsBoolean();
	}
	protected int getResultSize(JsonObject data) {
		return data.get("cantidadResultados").getAsInt();
	}
	protected int getOffset(JsonObject data) {
		return data.get("iniciarDesde").getAsInt();
	}
	protected String getType(JsonObject data) {
		return data.get("tipo").getAsString();
	}
	protected String getSortBy(JsonObject data) {
		try{
			return data.get("ordenarPor").getAsString();
		}catch(Exception e){
			return null;
		}
	}
	protected String getSortOrientation(JsonObject data) {
		try{
			return data.get("orden").getAsString();
		}catch(Exception e){
			return null;
		}
	}
}
