package com.dotmarketing.portlets.workflows.config;

import com.dotmarketing.business.Role;
import com.dotmarketing.portlets.workflows.model.WorkflowScheme;
import com.dotmarketing.portlets.workflows.model.WorkflowStep;
import com.liferay.portal.model.User;

public class WorkFlowConfig {
	
	private String stepName;
	private User whoUse;
	private int order;
	private String nextStepName;
	private WorkflowStep workflowStep;
	private WorkflowScheme workflowScheme;
	
	private String actionName;
	private String subActionName;
	private boolean isAssignable = false;
	private boolean isHerarchyUserRol = false;
	private boolean isCommentable = false;
	
	private Role wfwAdmGralRole;
	
	public WorkFlowConfig(String stepName, User whoUse, int order, WorkflowScheme workflowScheme) {
		this.stepName = stepName;
		this.whoUse = whoUse;
		this.order = order;
		this.workflowScheme = workflowScheme;
	}

	public WorkFlowConfig(String stepName, String actionName, int order, User whoUse, boolean isAssignable, boolean isHerarchyUserRol, boolean isCommentable, Role wfwAdmGralRole, String nextStepName, WorkflowScheme workflowScheme) {
		this.stepName = stepName;
		this.actionName = actionName;
		this.whoUse = whoUse;
		this.order = order;
		this.isAssignable = isAssignable;
		this.isHerarchyUserRol = isHerarchyUserRol;
		this.isCommentable = isCommentable;
		this.wfwAdmGralRole = wfwAdmGralRole;
		this.nextStepName = nextStepName;
		//this.workflowStep = workflowStep;
		this.workflowScheme = workflowScheme;
	}

	public WorkFlowConfig(String actionName, String subActionName, int order, User whoUse, WorkflowScheme workflowScheme) {
		this.actionName = actionName;
		this.subActionName = subActionName;
		this.whoUse = whoUse;
		this.order = order;
		//this.workflowStep = workflowStep;
		this.workflowScheme = workflowScheme;
	}

	
	
	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public User getWhoUse() {
		return whoUse;
	}

	public void setWhoUse(User whoUse) {
		this.whoUse = whoUse;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public WorkflowScheme getWorkflowScheme() {
		return workflowScheme;
	}

	public void setWorkflowScheme(WorkflowScheme workflowScheme) {
		this.workflowScheme = workflowScheme;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getSubActionName() {
		return subActionName;
	}

	public void setSubActionName(String subActionName) {
		this.subActionName = subActionName;
	}

	public boolean isAssignable() {
		return isAssignable;
	}

	public void setAssignable(boolean isAssignable) {
		this.isAssignable = isAssignable;
	}

	public boolean isHerarchyUserRol() {
		return isHerarchyUserRol;
	}

	public void setHerarchyUserRol(boolean isHerarchyUserRol) {
		this.isHerarchyUserRol = isHerarchyUserRol;
	}

	public Role getWfwAdmGralRole() {
		return wfwAdmGralRole;
	}

	public void setWfwAdmGralRole(Role wfwAdmGralRole) {
		this.wfwAdmGralRole = wfwAdmGralRole;
	}

	public String getNextStepName() {
		return nextStepName;
	}

	public void setNextStepName(String nextStepName) {
		this.nextStepName = nextStepName;
	}

	public boolean isCommentable() {
		return isCommentable;
	}

	public void setCommentable(boolean isCommentable) {
		this.isCommentable = isCommentable;
	}
	
	
	
}
