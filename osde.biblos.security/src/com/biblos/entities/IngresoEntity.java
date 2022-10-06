package com.biblos.entities;

import java.util.Date;

import ar.com.osde.framework.entities.FrameworkEntity;

/**
* Entitiy para guardar en los logs : Reporte ingresos...
*/
public class IngresoEntity implements FrameworkEntity {

	private static final long serialVersionUID = 1857498350421059577L;
	
	private String usuarioMT;
	private String usuarioNombre;
	private String navegador;
	private String navegadorVersion;
	private String sistemaOperativo;
	private String dispositivoIngreso;
	
	public String getUsuarioMT() {
		return usuarioMT;
	}
	public void setUsuarioMT(String usuarioMT) {
		this.usuarioMT = usuarioMT;
	}
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}
	public String getNavegador() {
		return navegador;
	}
	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}
	public String getNavegadorVersion() {
		return navegadorVersion;
	}
	public void setNavegadorVersion(String navegadorVersion) {
		this.navegadorVersion = navegadorVersion;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public String getDispositivoIngreso() {
		return dispositivoIngreso;
	}
	public void setDispositivoIngreso(String dispositivoIngreso) {
		this.dispositivoIngreso = dispositivoIngreso;
	}
	

}
