package com.biblos.reportes;

import org.apache.logging.log4j.ThreadContext;

import com.biblos.entities.IngresoEntity;
import com.dotmarketing.util.Logger;

public class ReporteIngreso {

       public static void generarReporteIngreso(IngresoEntity armarEntityIngreso) {
    	     ReporteUtils.fixNullAttributes(armarEntityIngreso);
    	     ThreadContext.put("usuarioMT", armarEntityIngreso.getUsuarioMT());
    	     ThreadContext.put("usuarioNombre", armarEntityIngreso.getUsuarioNombre());
    	     ThreadContext.put("explorador", armarEntityIngreso.getNavegador());
    	     ThreadContext.put("versionExplorador", armarEntityIngreso.getNavegadorVersion());
    	     ThreadContext.put("sistemaOperativo", armarEntityIngreso.getSistemaOperativo());
    	     ThreadContext.put("dispositivoIngreso", armarEntityIngreso.getDispositivoIngreso());
             Logger.info(ReporteIngreso.class, "Se loguea el ingreso"); 
             
       }
       
}
