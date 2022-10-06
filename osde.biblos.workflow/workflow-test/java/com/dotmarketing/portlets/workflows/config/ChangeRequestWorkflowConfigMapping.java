package com.dotmarketing.portlets.workflows.config;

import java.util.HashMap;
import java.util.Map;

import com.dotmarketing.business.Role;
import com.dotmarketing.portlets.workflows.model.WorkflowScheme;
import com.liferay.portal.model.User;

public class ChangeRequestWorkflowConfigMapping {

	private String workFlowName;
	
	private WorkflowScheme scheme = null;
	private String stepName = null;
	private String actionName = null;
	private String nextStepName = null;
	
    final Map<String, Object> steps		  	= new HashMap<>();

    final Map<String, Object> actions	   	= new HashMap<>();

    final Map<String, Object> subActions	= new HashMap<>();
    
    private Role wfwAdmGralRole = null;

    public ChangeRequestWorkflowConfigMapping(String workFlowName, WorkflowScheme workflowScheme) {
    	this.workFlowName = workFlowName;
    	this.scheme = workflowScheme;
    }


    public void mapStepToWorkflowActionForWorkflowScheme(final String stepName,
                                                         final int order,
                                                         final WorkflowScheme    workflowScheme) {
    	this.stepName= stepName;
        this.steps.put(this.stepName.toUpperCase(), this.addWorkflowStep(stepName, null, order, workflowScheme));
    }


    /**
     * This method mapped action to Wfw For scheme
     * @param actionName
     * @param order
     * @param whoUse
     * @param isAssignable
     * @param isHerarchyUserRol
     * @param wfwAdmGralRole
     * @param nextStepName
     * @param workflowScheme
     */
    public void mapActionToWorkflowActionForWorkflowScheme(String actionName,
                                                           int order,
                                                           User whoUse, 
                                                           boolean isAssignable,
                                                           boolean isHerarchyUserRol,
                                                           boolean isCommentable,
                                                           Role wfwAdmGralRole,
                                                           String nextStepName,
                                                           WorkflowScheme    workflowScheme) {
    	this.actionName = actionName;
    	this.nextStepName = nextStepName;
        this.actions.put(this.stepName.toUpperCase() + "@" + this.actionName.toUpperCase() + "#" + this.nextStepName.toUpperCase(), this.addWorkflowStepAction(this.stepName, actionName, whoUse, order, isAssignable, isHerarchyUserRol, isCommentable, wfwAdmGralRole, nextStepName, workflowScheme));
    }

    public void mapSubActionToWorkflowActionForWorkflowScheme(String subActionName,    														  
                                                              int order,
                                                              User whoUse, 
                                                              WorkflowScheme    workflowScheme) {
        this.subActions.put(this.stepName.toUpperCase() + "@" + this.actionName.toUpperCase() + "@" + subActionName.toUpperCase(), this.addWorkflowStepSubAction(actionName, subActionName, order, whoUse, workflowScheme));
    }

    private WorkFlowConfig addWorkflowStep(String stepName, User whoUse, int order, WorkflowScheme workflowScheme) {

        return new WorkFlowConfig(stepName, whoUse, order, workflowScheme);
    }


    private WorkFlowConfig addWorkflowStepAction(String stepName, String actionName, User whoUse, int order, boolean isAssignable, boolean isHerarchyUserRol, boolean isCommentable, Role wfwAdmGralRole, String nextStepName, WorkflowScheme workflowScheme) {

        return new WorkFlowConfig(stepName, actionName, order, whoUse, isAssignable, isHerarchyUserRol, isCommentable, wfwAdmGralRole, nextStepName, workflowScheme);
    }

    
    private WorkFlowConfig addWorkflowStepSubAction(final String actionName, final String subActionName, final int order, final User whoUse, final WorkflowScheme workflowScheme) {

        return new WorkFlowConfig(actionName, subActionName, order, whoUse, workflowScheme);
    }

    public void setWorkFlowScheme(WorkflowScheme scheme) {
    	this.scheme = scheme;
    }
    
    public WorkflowScheme getWorkFlowScheme() {
    	return this.scheme;
    }
    
    public String getWorkFlowName() {
    	return this.workFlowName;
    }

    public Map<String, Object>  getWorkFlowSteps() {
        return this.steps;
    }

    public Map<String, Object> getWorkFlowActions() {      
        return this.actions;
    }

    public Map<String, Object> getWorkFlowSubActions() {
        return subActions;
    }

}
