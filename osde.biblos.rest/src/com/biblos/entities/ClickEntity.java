package com.biblos.entities;

import ar.com.osde.framework.entities.FrameworkEntity;

/**
 * Entitiy para guardar en los logs : Reporte clicks
 */
public class ClickEntity implements FrameworkEntity {

	private static final long serialVersionUID = -6070160903680950369L;

	private String usuarioMT;
	private String usuarioNombre;
	private String host;
	private String url;
	private String solapa;
	private String idPagina;
	private Boolean usoBuscador;

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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSolapa() {
		return solapa;
	}

	public void setSolapa(String solapa) {
		this.solapa = solapa;
	}

	public String getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(String idPagina) {
		this.idPagina = idPagina;
	}

	public Boolean isUsoBuscador() {
		return usoBuscador;
	}

	public void setUsoBuscador(Boolean usoBuscador) {
		this.usoBuscador = usoBuscador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
