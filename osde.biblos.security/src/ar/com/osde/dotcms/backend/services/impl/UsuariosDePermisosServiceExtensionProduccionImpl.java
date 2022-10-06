package ar.com.osde.dotcms.backend.services.impl;

import ar.com.osde.dotcms.backend.services.UsuariosDePermisosServiceExtension;
import ar.com.osde.dotcms.cxf.usuariosDePermisos.UsuariosDePermisosSoapProduccion;

public class UsuariosDePermisosServiceExtensionProduccionImpl implements UsuariosDePermisosServiceExtension {

	private UsuariosDePermisosSoapProduccion usuariosDePermisosSoapProduccion;
	private String filesUploadPath;
	
	
	public String getFilesUploadPath() {
		return filesUploadPath;
	}

	public void setFilesUploadPath(String filesUploadPath) {
		this.filesUploadPath = filesUploadPath;
	}

	public String obtenerUsuarios(String permisos) {
		return this.getUsuariosDePermisosSoapProduccion().obtenerUsuarios(permisos);
	}
	    
	public String obtenerUsuariosv2(String permisos) {
		return this.getUsuariosDePermisosSoapProduccion().obtenerUsuariosv2(permisos);
	}

	public String obtenerListadoDePermisos(String permiso) {
		return this.getUsuariosDePermisosSoapProduccion().obtenerListadoDePermisos(permiso);
	}

	public String obtenerFilialesDePermiso(String permiso) {
		return this.getUsuariosDePermisosSoapProduccion().obtenerFilialesDePermiso(permiso);
	}

	public String obtenerUsuariosFilial(String permisos, String filial) {
		return this.getUsuariosDePermisosSoapProduccion().obtenerUsuariosFilial(permisos, filial);
	}
	
	public UsuariosDePermisosSoapProduccion getUsuariosDePermisosSoapProduccion() {
		return usuariosDePermisosSoapProduccion;
	}

	public void setUsuariosDePermisosSoapProduccion(UsuariosDePermisosSoapProduccion usuariosDePermisosSoapProduccion) {
		this.usuariosDePermisosSoapProduccion = usuariosDePermisosSoapProduccion;
	}
}
