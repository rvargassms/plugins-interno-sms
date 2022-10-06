package ar.com.osde.dotcms.backend.services.impl;

import ar.com.osde.dotcms.backend.services.UsuariosDePermisosServiceExtension;
import ar.com.osde.dotcms.cxf.usuariosDePermisos.UsuariosDePermisosSoapTesting;

public class UsuariosDePermisosServiceExtensionTestingImpl implements UsuariosDePermisosServiceExtension {

	private UsuariosDePermisosSoapTesting usuariosDePermisosSoapTesting;
	private String filesUploadPath;

	public String getFilesUploadPath() {
		return filesUploadPath;
	}

	public void setFilesUploadPath(String filesUploadPath) {
		this.filesUploadPath = filesUploadPath;
	}

	public String obtenerUsuarios(String permisos) {
		return this.getUsuariosDePermisosSoapTesting().obtenerUsuarios(permisos);
	}
	    
	public String obtenerUsuariosv2(String permisos) {
		return this.getUsuariosDePermisosSoapTesting().obtenerUsuariosv2(permisos);
	}

	public String obtenerListadoDePermisos(String permiso) {
		return this.getUsuariosDePermisosSoapTesting().obtenerListadoDePermisos(permiso);
	}

	public String obtenerFilialesDePermiso(String permiso) {
		return this.getUsuariosDePermisosSoapTesting().obtenerFilialesDePermiso(permiso);
	}

	public String obtenerUsuariosFilial(String permisos, String filial) {
		return this.obtenerUsuariosFilial(permisos, filial);
	}
	
	public UsuariosDePermisosSoapTesting getUsuariosDePermisosSoapTesting() {
		return usuariosDePermisosSoapTesting;
	}

	public void setUsuariosDePermisosSoapTesting(UsuariosDePermisosSoapTesting usuariosDePermisosSoapTesting) {
		this.usuariosDePermisosSoapTesting = usuariosDePermisosSoapTesting;
	}
}
