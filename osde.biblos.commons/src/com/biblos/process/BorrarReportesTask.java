package com.biblos.process;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.dotmarketing.util.Logger;
import com.biblos.commons.CustomDBParametersLoader;
import com.biblos.loader.CommonsPropertiesLoader;

public class BorrarReportesTask {
	
	private static final String TIEMPO_LIMITE_DATOS_REPORTES = "reportes.limite.tiempo";

	public void execute() {
		Logger.info(this, "Se borraran los datos innecesarios para los reportes");
		try {
			Properties properties = CommonsPropertiesLoader.loadAllProperties();
			Integer limiteMeses = Integer.valueOf(CommonsPropertiesLoader.getProperty(properties, TIEMPO_LIMITE_DATOS_REPORTES));
			
			LocalDateTime date = LocalDateTime.now().minusMonths(limiteMeses);
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    
		    String fechaLimite = date.format(formatter);
		    
		    CustomDBParametersLoader.executeQuery("delete from REPORTE_CLICKS where fecha < ?", fechaLimite);
		    CustomDBParametersLoader.executeQuery("delete from REPORTE_INGRESO where fecha_ingreso < ?", fechaLimite);
		    CustomDBParametersLoader.executeQuery("delete from REPORTE_WORKFLOW where fecha_ejecucion < ?", fechaLimite);
		    
		} catch (Exception e) {
			Logger.error(this, e.getMessage());
		}
	}

}

