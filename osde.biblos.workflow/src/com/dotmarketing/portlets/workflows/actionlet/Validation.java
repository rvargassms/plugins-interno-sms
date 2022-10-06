package com.dotmarketing.portlets.workflows.actionlet;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dotmarketing.portlets.workflows.model.WorkflowActionClassParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowActionFailureException;
import com.dotmarketing.portlets.workflows.model.WorkflowActionletParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowProcessor;
import com.dotmarketing.portlets.workflows.model.WorkflowTask;
import com.dotmarketing.business.FactoryLocator;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.workflows.actionlet.WorkFlowActionlet;
import com.dotmarketing.portlets.workflows.business.WorkFlowFactory;

public class Validation extends WorkFlowActionlet {

	private static final long	serialVersionUID	= 4111172297157414222L;

	public void executeAction(WorkflowProcessor processor, Map<String, WorkflowActionClassParameter> params) {

		final Contentlet contentlet = processor.getContentlet();

		if (contentlet.getContentType().name().equalsIgnoreCase("File Asset")) {
			Pattern pat = Pattern.compile("^[A-Za-z0-9]*$");
			Matcher mat = pat.matcher(this.extractNameContent(contentlet.get("fileName").toString()));
			if (!mat.matches()) {
				String error = "El nombre no puede contener caracteres especiales, acentos ni espacios";
				throw new WorkflowActionFailureException(error);
			}
		}
		
	}
	
	public String extractNameContent(String name) {		
		StringBuilder strb = new StringBuilder(name);
		String str = strb.reverse().toString();
		return name = str.split("\\.", 2)[1];
	}

	/**
	 * Descripción que se muestra al hacer click sobre esta subacción cuando es
	 * agregada en una acción del workflow.
	 */
	public String getHowTo() {
		return "Esta acción restringe el nombre del file asset para permitir sólo caracteres alfanumericos";
	}

	/**
	 * Nombre que se muestra en la lista de subacciones disponibles para agregar
	 * a una acción de un workflow y para ordenarlas al momento de generar la
	 * lista.
	 */
	public String getName() {
		String nombre = "";
		String palabras[] = this.getClass().getSimpleName().split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");

		for (int i = 0; i < palabras.length; i++) {
			nombre += (i != palabras.length - 1) ? palabras[i] + " " : palabras[i];
		}

		return nombre;
	}

	public List<WorkflowActionletParameter> getParameters() {
		return null;
	}	


}
