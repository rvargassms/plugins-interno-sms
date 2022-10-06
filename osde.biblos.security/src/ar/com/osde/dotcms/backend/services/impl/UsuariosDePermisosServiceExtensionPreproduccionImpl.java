package ar.com.osde.dotcms.backend.services.impl;

import ar.com.osde.dotcms.backend.services.UsuariosDePermisosServiceExtension;
import ar.com.osde.dotcms.cxf.usuariosDePermisos.UsuariosDePermisosSoapPreproduccion;

public class UsuariosDePermisosServiceExtensionPreproduccionImpl implements UsuariosDePermisosServiceExtension {

	private UsuariosDePermisosSoapPreproduccion usuariosDePermisosSoapPreproduccion;
	private String filesUploadPath;
	
	public String getFilesUploadPath() {
		return filesUploadPath;
	}

	public void setFilesUploadPath(String filesUploadPath) {
		this.filesUploadPath = filesUploadPath;
	}

	public String obtenerUsuarios(String permisos) {
		return this.getUsuariosDePermisosSoapPreproduccion().obtenerUsuarios(permisos);
	}
	    
	public String obtenerUsuariosv2(String permisos) {
		return this.getUsuariosDePermisosSoapPreproduccion().obtenerUsuariosv2(permisos);
	}

	public String obtenerListadoDePermisos(String permiso) {
		return this.getUsuariosDePermisosSoapPreproduccion().obtenerListadoDePermisos(permiso);
	}

	public String obtenerFilialesDePermiso(String permiso) {
		return this.getUsuariosDePermisosSoapPreproduccion().obtenerFilialesDePermiso(permiso);
	}

	public String obtenerUsuariosFilial(String permisos, String filial) {
		return this.getUsuariosDePermisosSoapPreproduccion().obtenerUsuariosFilial(permisos, filial);
	}
	
	public UsuariosDePermisosSoapPreproduccion getUsuariosDePermisosSoapPreproduccion() {
		return usuariosDePermisosSoapPreproduccion;
	}

	public void setUsuariosDePermisosSoapPreproduccion(UsuariosDePermisosSoapPreproduccion usuariosDePermisosSoapPreproduccion) {
		this.usuariosDePermisosSoapPreproduccion = usuariosDePermisosSoapPreproduccion;
	}
}
