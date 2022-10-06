package com.biblos.process;

import com.dotmarketing.util.Logger;
import com.biblos.commons.CustomDBParametersLoader;
import com.biblos.bo.PermisosBO;


public class SincronizarPermisosyUsuariosTask {
	
	private PermisosBO permisosBO;
	
	public void execute() {
		

		try {
			
			if(CustomDBParametersLoader.syncUsuariosPermisos()){
				this.doLog("Se sincronizaran los usuarios y sus permisos", false, null);
				//this.getPermisosBO().sincronizarPermisos();
				this.doLog("Sincronizacion de usuarios y permisos OK", false, null);
			} else {
				this.doLog("Este nodo no sincroniza los usuarios y sus permisos ya que hay otro en proceso", false, null);
			}
		} catch (Exception e) {
			this.doLog(e.getMessage(), true, e);
		} finally {
			CustomDBParametersLoader.unlockSyncUsuariosPermisos();
		}
	}
	
	private void doLog(String message, boolean error, Throwable e) {
        if (error) {
        	Logger.error(SincronizarPermisosyUsuariosTask.class, "::: "+ message +" :::", e);
        } else {
        	Logger.info(SincronizarPermisosyUsuariosTask.class, "::: "+ message +" :::");
        }
    }

	public PermisosBO getPermisosBO() {
		return permisosBO;
	}

	public void setPermisosBO(PermisosBO permisosBO) {
		this.permisosBO = permisosBO;
	}
}