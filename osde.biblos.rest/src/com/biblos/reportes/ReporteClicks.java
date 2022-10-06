package com.biblos.reportes;

import org.apache.logging.log4j.ThreadContext;

import com.biblos.entities.ClickEntity;
import com.dotmarketing.util.Logger;

public class ReporteClicks {

	public static void generarReporteClick(ClickEntity armarEntityClick) {
		ReporteUtils.fixNullAttributes(armarEntityClick);
		ThreadContext.put("usuarioMT", armarEntityClick.getUsuarioMT());
		ThreadContext.put("usuarioNombre", armarEntityClick.getUsuarioNombre());
		ThreadContext.put("host", armarEntityClick.getHost());
		ThreadContext.put("url", armarEntityClick.getUrl());
		ThreadContext.put("solapa", armarEntityClick.getSolapa());
		ThreadContext.put("idPagina", armarEntityClick.getIdPagina());
		ThreadContext.put("usoBuscador", armarEntityClick.isUsoBuscador() ? "1" : "0");
		Logger.info(ReporteClicks.class, "Se loguea el click");
	}

}
