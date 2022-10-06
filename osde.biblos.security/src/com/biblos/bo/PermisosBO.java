package com.biblos.bo;

import java.sql.Connection;

import com.dotmarketing.common.db.DotConnect;

import ar.com.osde.dotcms.backend.dtos.UsuarioDTO;


public interface PermisosBO {
	
	public void sincronizarPermisos();
	
	public boolean actualizarPermisos(UsuarioDTO usuarioDTO) throws Exception;
}
