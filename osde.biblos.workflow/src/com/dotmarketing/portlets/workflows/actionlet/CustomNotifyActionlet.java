package com.dotmarketing.portlets.workflows.actionlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dotmarketing.portlets.workflows.model.WorkflowActionClassParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowActionFailureException;
import com.dotmarketing.portlets.workflows.model.WorkflowActionletParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowProcessor;
import com.dotmarketing.portlets.workflows.model.WorkflowStep;
import com.dotmarketing.portlets.workflows.util.WorkflowEmailUtil;
import com.dotmarketing.util.Logger;

public class CustomNotifyActionlet extends WorkFlowActionlet {

	private static final long serialVersionUID = 1L;
	private static List<WorkflowActionletParameter> paramList = null; 


	public String getName() {
		// TODO Auto-generated method stub
		return "Custom Notify";
	}

	public String getHowTo() {

		return "This actionlet will send an email to a custom configuration. It uses a default email subject and message, but can be overridden.  Both the subject and message are parsed Velocity, and have access to a $workflow object that gives them $workflow.task, $workflow.nextAssign, $workflow.action, $workflow.step, etc.. ";
	}

	public void executeAction(WorkflowProcessor processor,Map<String,WorkflowActionClassParameter>  params) throws WorkflowActionFailureException {

		String emailSubject =null;
		String emailBody =null;
		boolean isHtml = false;
			
		if(params.get("emailSubject") != null && params.get("emailSubject").getValue() !=null){
			emailSubject = params.get("emailSubject").getValue();
		}
		if(params.get("emailBody") != null && params.get("emailBody").getValue()!=null){
			emailBody = params.get("emailBody").getValue();
		}
		
		if(params.get("isHtml") != null && params.get("isHtml").getValue()!=null){
			try{
				isHtml = new Boolean(params.get("isHtml").getValue());
			}
			catch(Exception e){
				Logger.error(CustomNotifyActionlet.class, "::: "+ e.getMessage() +" :::");
			}
		}
		
		String to = params.get("to").getValue();
		
		String[] destinatarios = {to};		
		
		WorkflowEmailUtil.sendWorkflowEmail(processor, destinatarios, emailSubject, emailBody, isHtml);
		
	}

	public WorkflowStep getNextStep() {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public  List<WorkflowActionletParameter> getParameters() {
		if(paramList ==null){
			synchronized (this.getClass()) {
				if(paramList ==null){
					paramList = new ArrayList<WorkflowActionletParameter>();
					paramList.add(new WorkflowActionletParameter("to", "Destinatario", "", true));
					paramList.add(new WorkflowActionletParameter("emailSubject", "Email Subject", "", false));
					paramList.add(new WorkflowActionletParameter("emailBody", "Email Message", null, false));
					paramList.add(new WorkflowActionletParameter("isHtml", "Is Html?", "true", false));		
				}
			}
		}
		return paramList;
	}
}
