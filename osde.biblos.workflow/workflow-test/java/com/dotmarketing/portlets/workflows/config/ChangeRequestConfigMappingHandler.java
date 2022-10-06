package com.dotmarketing.portlets.workflows.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.dotcms.business.WrapInTransaction;
import com.dotcms.contenttype.business.ContentTypeAPIImpl;
import com.dotcms.contenttype.business.FieldAPI;
import com.dotcms.repackage.net.sf.hibernate.collection.Set;
import com.dotmarketing.beans.Permission;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.FactoryLocator;
import com.dotmarketing.business.NoSuchUserException;
import com.dotmarketing.business.PermissionAPI;
import com.dotmarketing.business.Role;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.exception.AlreadyExistException;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.workflows.actionlet.VelocityScriptActionlet;
import com.dotmarketing.portlets.workflows.business.WorkFlowFactory;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import com.dotmarketing.portlets.workflows.model.SystemActionWorkflowActionMapping;
import com.dotmarketing.portlets.workflows.model.WorkflowAction;
import com.dotmarketing.portlets.workflows.model.WorkflowActionClass;
import com.dotmarketing.portlets.workflows.model.WorkflowActionClassParameter;
import com.dotmarketing.portlets.workflows.model.WorkflowScheme;
import com.dotmarketing.portlets.workflows.model.WorkflowState;
import com.dotmarketing.portlets.workflows.model.WorkflowStep;
import com.google.common.collect.ImmutableMap;
import com.liferay.portal.model.User;

/**
 * 
 * This handler create an workflow "Solicitud De Cambio" with 8 steps and each action.
 *
 */
public class ChangeRequestConfigMappingHandler {

    
    static ImmutableMap <String, Class> actionClassesMetaDataMap = new ImmutableMap.Builder<String, Class>()
                .put(WFWConfigConstants.SAVE_CONTENT_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.SaveContentActionlet.class)
                .put(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.CheckinContentActionlet.class)
                .put(WFWConfigConstants.MARK_COMPLETE_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.MarcarFinalizado.class)
                .put(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.UnpublishContentActionlet.class)
                .put(WFWConfigConstants.ARCHIVE_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.ArchiveContentActionlet.class)
                .put(WFWConfigConstants.REMOVE_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.DeleteContentActionlet.class)
                .put(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.NotifyAssigneeActionlet.class)
                .put(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.PublishContentActionlet.class)
                .put(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.ResetTaskActionlet.class)
                .put(WFWConfigConstants.LOCK_CONTENT_SUBACTION, com.dotmarketing.portlets.workflows.actionlet.CheckoutContentActionlet.class)
                .put(WFWConfigConstants.REQUIRE_MULTIPLE_APPROVES,com.dotmarketing.portlets.workflows.actionlet.MultipleApproverActionlet.class)
                .put(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION,com.dotmarketing.portlets.workflows.actionlet.VelocityScriptActionlet.class)
                .put(WFWConfigConstants.COPY_CONTENT_SUBACTION,com.dotmarketing.portlets.workflows.actionlet.CopyActionlet.class)
                .put(WFWConfigConstants.UNARCHIVE_SUBACTION,com.dotmarketing.portlets.workflows.actionlet.UnarchiveContentActionlet.class)
                .put(WFWConfigConstants.DESTROY_SUBACTION,com.dotmarketing.portlets.workflows.actionlet.DestroyContentActionlet.class)
                .put(WFWConfigConstants.VALIDATION_SUBACTION,com.dotmarketing.portlets.workflows.actionlet.Validation.class)
                .build();
 
    private static User user;
    private static ContentTypeAPIImpl contentTypeAPI;
    private static FieldAPI fieldAPI;
    private static RoleAPI roleAPI;
	private static WorkflowAPI workflowAPI;
	
    private WorkflowScheme wfScheme = null;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	
    private static Map<String, WorkflowStep> stepsAUX = new HashMap<>();
    
    public ChangeRequestConfigMappingHandler(){}

    public ChangeRequestConfigMappingHandler(User user, ContentTypeAPIImpl contentTypeAPI,
    		FieldAPI fieldAPI,
    		RoleAPI roleAPI,
    		WorkflowAPI workflowAPI){
    	this.user = user;
    	this.contentTypeAPI = contentTypeAPI;
    	this.fieldAPI = fieldAPI;
    	this.roleAPI = roleAPI;
    	this.workflowAPI = workflowAPI;
    }

    
    /**
     * This test first creates an workflow with steps and each action.
     * Them assign the each action with subaction to configuration to define in ChangeRequestWorkflowConfigMapping.
     * 
     * @param changeRequestConfigWorkflowMapping <code>ChangeRequestWorkflowConfigMapping</code>
     * @throws DotDataException
     * @throws DotSecurityException
     */
    public void save(ChangeRequestWorkflowConfigMapping changeRequestConfigWorkflowMapping)  throws DotDataException, DotSecurityException {

    	if (changeRequestConfigWorkflowMapping.getWorkFlowScheme() != null && changeRequestConfigWorkflowMapping.getWorkFlowScheme().getId() != null && changeRequestConfigWorkflowMapping.getWorkFlowScheme().getName() !=null)
    		wfScheme = modifyWorkflowScheme(changeRequestConfigWorkflowMapping.getWorkFlowScheme());    		
    	else if (changeRequestConfigWorkflowMapping.getWorkFlowName().equals(WFWConfigConstants.WORK_FLOW_CHANGE_REQUEST) ||
        	changeRequestConfigWorkflowMapping.getWorkFlowName().equals(WFWConfigConstants.WORK_FLOW_SYSTEM)) {         		
        	wfScheme = addWorkflowScheme(changeRequestConfigWorkflowMapping.getWorkFlowName());    		
        	changeRequestConfigWorkflowMapping.setWorkFlowScheme(wfScheme);  	
        }
       	
    	
        if (changeRequestConfigWorkflowMapping.getWorkFlowSteps() != null) {


        	// first add steps
        	for (final Entry<String, Object> workFlowSteps : changeRequestConfigWorkflowMapping.getWorkFlowSteps().entrySet()) {

            	WorkFlowConfig configStep = (WorkFlowConfig) workFlowSteps.getValue();
            	
            	/* Generate steps */
            	WorkflowStep wfwStep = addWorkflowStep(configStep.getStepName(), configStep.getOrder(), false, false, wfScheme.getId());
            	
            	stepsAUX.put(wfwStep.getName().toUpperCase(), wfwStep);
        	}
        	

        	// second add actions from steps
            for (final Entry<String, WorkflowStep> workFlowSteps : stepsAUX.entrySet()) {
            	
            	WorkflowStep wfwStep = workFlowSteps.getValue(); 
            	
	            for (final Entry<String, Object> workFlowActions : findActionsByStepName(wfwStep.getName(), changeRequestConfigWorkflowMapping.getWorkFlowActions()).entrySet()) {
	            	
	            	WorkFlowConfig configAction = (WorkFlowConfig) workFlowActions.getValue();
	            	
	            	/* Generate actions */
	            	WorkflowAction wfwAction = addWorkflowAction(configAction.getActionName(), configAction.getOrder(), configAction.isAssignable(), configAction.isHerarchyUserRol(), configAction.isCommentable(), stepsAUX.get(configAction.getNextStepName().toUpperCase()).getId(), true, wfwStep.getId(), configAction.getWfwAdmGralRole(),
	            			wfScheme.getId());	            		

		            for (final Entry<String, Object> workFlowSubActions : findSubActionsByActionName(wfwStep.getName(), wfwAction.getName(), changeRequestConfigWorkflowMapping.getWorkFlowSubActions()).entrySet()) {

		            	WorkFlowConfig configSubAction = (WorkFlowConfig) workFlowSubActions.getValue();
		            	
		                /* Generate sub-actions */
		            	try {
							WorkflowActionClass subActionSaveContent = addSubActionClass(
									configSubAction.getSubActionName(),
									wfwAction.getId(),
									actionClassesMetaDataMap.get(configSubAction.getSubActionName()), configSubAction.getOrder());							
						} catch (DotDataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DotSecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	
	            }

            } // for (final Entry<String, WorkflowStep> workFlowSteps : stepsAUX.entrySet())     
            
           this.reorderAction(changeRequestConfigWorkflowMapping);
        }
        
    }
    
	public void deleteStepsInScheme(WorkflowScheme scheme) {
		List<WorkflowStep> listSteps = new ArrayList<WorkflowStep>();

		try {
			listSteps = workflowAPI.findSteps(scheme);

			if (listSteps != null)
				for (WorkflowStep step : listSteps) {
					workflowAPI.deleteStepHardMode(step, user);
				}

		} catch (DotDataException e) {
			e.printStackTrace();
		}

	}
	
    /**
     * This method reorderAction
     * 
     * @param changeRequestConfigWorkflowMapping
     */
	private void reorderAction(ChangeRequestWorkflowConfigMapping changeRequestConfigWorkflowMapping) {
		List<WorkflowStep> listSteps = new ArrayList<WorkflowStep>();
		List<WorkflowAction> listActions = new ArrayList<WorkflowAction>();
		  
		try {
			
			listSteps = workflowAPI.findSteps(wfScheme);
			for (WorkflowStep step : listSteps) {
				listActions = workflowAPI.findActions(step, user);
				for (WorkflowAction action : listActions) {			
					//System.out.println( "step:" + step.getName() + "\n"  );
					//System.out.println( "acion:" + action.getName() + "\n"  );
					//System.out.println( "order:" + findOrderByWorkFlowConfig(changeRequestConfigWorkflowMapping, step, action) + "\n"  );
					workflowAPI.reorderAction(action, step, user, findOrderByWorkFlowConfig(changeRequestConfigWorkflowMapping, step, action));
				

		            /**
		             * FIX mapping add default action
		             */

		            if (changeRequestConfigWorkflowMapping.getWorkFlowScheme().getName().equalsIgnoreCase(WFWConfigConstants.WORK_FLOW_CHANGE_REQUEST)) {
		            
		            	changeRequestWorkflowActionMappingAddDefaultAction(changeRequestConfigWorkflowMapping.getWorkFlowScheme(), step, action);
		            
		            } else if (changeRequestConfigWorkflowMapping.getWorkFlowScheme().getName().equals(WFWConfigConstants.WORK_FLOW_SYSTEM)) {
		    			
		            	systemWorkflowActionMappingAddDefaultAction(changeRequestConfigWorkflowMapping.getWorkFlowScheme(), step, action);

		            }
		        
				}
			}
			
			
		} catch (DotDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DotSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int findOrderByWorkFlowConfig(ChangeRequestWorkflowConfigMapping changeRequestConfigWorkflowMapping, WorkflowStep step, WorkflowAction action) {

        for (final Entry<String, WorkflowStep> workFlowSteps : stepsAUX.entrySet()) {
        	
        	WorkflowStep wfwStep = workFlowSteps.getValue(); 
        	
            for (final Entry<String, Object> workFlowActions : findActionsByStepName(wfwStep.getName(), changeRequestConfigWorkflowMapping.getWorkFlowActions()).entrySet()) {
            	
            	WorkFlowConfig configAction = (WorkFlowConfig) workFlowActions.getValue();
            	
//            	if(step.getName().equals(WFWConfigConstants.PUBLISH_STEP_NAME) && wfwStep.getName().equals(WFWConfigConstants.PUBLISH_STEP_NAME))
//            		System.out.println("breakpoint");
                
            	if(step.getName().equalsIgnoreCase(wfwStep.getName()) && action.getName().equalsIgnoreCase(configAction.getActionName())) {
            	
            		return configAction.getOrder();
            	}
            }

        } // for (final Entry<String, WorkflowStep> workFlowSteps : stepsAUX.entrySet())     

		return -1;
	}

    /**
     * This method find action for step and nextstep
     * @param stepName
     * @param actions
     * @return actions are filter for just step and nextstep
     */
    private Map<String, Object>  findActionsByStepName(String stepName, Map<String, Object> actions) {
    	Map<String, Object> collect = actions.entrySet().stream()
                .filter(x -> StringUtils.contains(x.getKey().toUpperCase(), stepName.toUpperCase()+"@"))
                .filter(x -> StringUtils.contains(((WorkFlowConfig)x.getValue()).getStepName().toUpperCase(), stepName.toUpperCase()))
                .filter(x -> StringUtils.contains(x.getKey().toUpperCase(), "#"+((WorkFlowConfig)x.getValue()).getNextStepName().toUpperCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return collect;
    }
    
    
    /**
     * This method find subaction for step name and action name
     * @param stepName
     * @param actions
     * @return The sub actions are filter for just step and action name
     */
    private Map<String, Object>  findSubActionsByActionName(String stepName, String actionName, Map<String, Object> actions) {
        Map<String, Object> collect = actions.entrySet().stream()
				.filter(x -> {
					String string = x.getKey().toUpperCase();
					String[] parts = string.split("@");
					String part1 = parts[0];
					return StringUtils.equals(part1.toUpperCase(), stepName.toUpperCase());
				})
                .filter(x -> StringUtils.equals(((WorkFlowConfig)x.getValue()).getActionName().toUpperCase(), actionName.toUpperCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        return collect;
    }

    
    /**
     * Determines if it is the workflow system
     */
    protected static boolean isSystemWorkflow(final String schemeId) {
		WorkflowScheme scheme = null;

		try {
			scheme = workflowAPI.findScheme(schemeId);
		} catch (DotDataException | DotSecurityException e) {
			e.printStackTrace();
		}
		
		if (scheme.getName().equals(WFWConfigConstants.WORK_FLOW_SYSTEM))
			return true;
		else return false;
	}
    
    /**
     * Find a WorkflowScheme
     *
     * @param schemeName Name
     * @return the found scheme
     * @throws DotDataException 
     */
	protected static WorkflowScheme findWorkflowScheme(final String schemeName) throws DotDataException {
		WorkflowScheme scheme = null;

		scheme = workflowAPI.findSchemeByName(schemeName);

		return scheme;
	}
    
    /**
     * Archive a WorkflowScheme
     *
     * @param scheme to archive
     * @return the new Scheme
     */
	protected static void archiveWorkflowScheme(final WorkflowScheme scheme)
			throws DotDataException, DotSecurityException {

		try {
			workflowAPI.archive(scheme, user);
		} catch (AlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    /**
     * Delete a WorkflowScheme
     *
     * @param schemeName to delete
     * @return void
     */
	protected static void deleteWorkflowScheme(final WorkflowScheme scheme)
			throws DotDataException, DotSecurityException {
		try {
			workflowAPI.deleteScheme(scheme, user);
		} catch (AlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Modify a WorkflowScheme
     *
     * @param scheme to modify
     * @return the modified scheme
     */
    protected static WorkflowScheme modifyWorkflowScheme(final WorkflowScheme scheme)
            throws DotDataException, DotSecurityException {
        try {        	
        	Date currentDate = new Date();        	            
            scheme.setModDate(currentDate);
            scheme.setDescription("automatic workflow config - modify " + sdf.format(currentDate));
            workflowAPI.saveScheme(scheme, APILocator.systemUser());
        } catch (AlreadyExistException e) {
            //scheme already exist
        	e.printStackTrace();
        }
        return scheme;
    }

    
    /**
     * Create a WorkflowScheme
     *
     * @param schemeName Name of the new Scheme
     * @return the new Scheme
     */
    protected static WorkflowScheme addWorkflowScheme(final String schemeName)
            throws DotDataException, DotSecurityException {
        WorkflowScheme scheme = null;
        try {
        	Date currentDate = new Date();  
            scheme = new WorkflowScheme();
            scheme.setName(schemeName);            
            scheme.setCreationDate(currentDate);
            scheme.setDescription("automatic workflow config - creation " + sdf.format(currentDate));
            workflowAPI.saveScheme(scheme, APILocator.systemUser());
        } catch (AlreadyExistException e) {
            //scheme already exist
        	e.printStackTrace();
        }
        return scheme;
    }


    /**
     * Create a new Workflow Step
     *
     * @param name Name of the step
     * @param order step order
     * @param resolved Is resolved
     * @param enableEscalation Allows Escalations
     * @param schemeId Scheme Id
     * @return The created step
     */
    protected static WorkflowStep addWorkflowStep(final String name, final int order,
            final boolean resolved,
            final boolean enableEscalation, final String schemeId)
            throws DotDataException, DotSecurityException {    	

        WorkflowStep step = null;
        try {
            step = new WorkflowStep();
            step.setCreationDate(new Date());
            step.setEnableEscalation(enableEscalation);
            step.setMyOrder(order);
            step.setName(name);
            step.setResolved(resolved);
            step.setSchemeId(schemeId);
            workflowAPI.saveStep(step, user);
        } catch (AlreadyExistException e) {
            //scheme already exist
        }
        return step;
    }
    

    /**
     * Add a workflowAction
     *

     * @param isAssignable Step is assignable
     * @param isRoleHierarchyForAssign Step include parent role users
     * When showing the permissions with the current roles to be able to operate on the content, it is taken into account that if there is a role that allows the Edition, it may manipulate a specific or generic Content.  
     * @param nextStep next step
     * @param requiresCheckout is checkout required
     * @param stepId Current step id
     * @param whoCanUse Role permissions
     * @return A workflowAction
     */
    protected static WorkflowAction addWorkflowAction(final String name, 
    		final int order, 
    		final boolean isAssignable, 
    		final boolean isRoleHierarchyForAssign, 
    		final boolean isCommentable,
            final String nextStep,
            final boolean requiresCheckout, final String stepId, final Role whoCanUse,
            final String schemeId)
            throws DotDataException, DotSecurityException {
    	
    	WorkflowScheme scheme = null;
    	WorkflowStep step = null;
        WorkflowAction action = null;
        
        scheme = workflowAPI.findScheme(schemeId);
        step = workflowAPI.findStep(stepId);
        
        try {
            action = new WorkflowAction();
            action.setName(name);
            action.setSchemeId(schemeId);
            //action.setOwner(whoCanUse.getId());
            action.setOrder(order);            
            action.setRequiresCheckout(false);
            action.setStepId(stepId);            
            action.setCommentable(isCommentable); //true
            action.setAssignable(isAssignable);
            action.setRoleHierarchyForAssign(isRoleHierarchyForAssign);            

			// FIXME here it is assigned setShowOn with EnumSet just wfw change request
			if (scheme.getName().equalsIgnoreCase(WFWConfigConstants.WORK_FLOW_CHANGE_REQUEST)) {
				action.setShowOn(setEnumSet(step.getName(), action.getName()));
				action.setNextAssign(getNextAssign(step.getName(), action.getName()));
				action.setNextStep(workflowAPI.findStep(nextStep).getId());
				workflowAPI.saveAction(action, Arrays.asList(asListPermissionWhoCanUse(step.getName(), action)),
						APILocator.systemUser());
			}

			if (scheme.getName().equals(WFWConfigConstants.WORK_FLOW_SYSTEM)) {
				action.setShowOn(setEnumSetSystemWorkflow(step.getName(), action.getName()));
				action.setNextAssign(getNextAssignSystemWorkflow(step.getName(), action.getName()));
				action.setNextStep(getNextStepSystemWorkflow(step.getName(), action.getName(), nextStep));
				workflowAPI.saveAction(action,
						Arrays.asList(asListPermissionWhoCanUseSystemWorkflow(action, whoCanUse)),
						APILocator.systemUser());
			}

            workflowAPI.saveAction(action.getId(), stepId, APILocator.systemUser());

        
        } catch (DotDataException | AlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}

        return action;
    }    
    
	protected static WorkflowAction defaultShowOnSystemWorkflow(WorkflowAction action) {
		action.setShowOn(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED,
				WorkflowState.UNPUBLISHED);
		return action;
	}
    
	private static Permission[] asListPermissionWhoCanUseSystemWorkflow(WorkflowAction action, Role whocanuse)
			throws DotDataException {
		
		Permission[] permissions = null;

		permissions = new Permission[] {
				new Permission(action.getId(), whocanuse.getId(), PermissionAPI.PERMISSION_USE) };

		return permissions;
	}
    
	

    /**
     * This method add default action 
     * This method permit to the folder publish action utilizes the default publish action from your workflow.
     * @param scheme
     * @param step
     * @param action
     */
    private static void systemWorkflowActionMappingAddDefaultAction(final WorkflowScheme scheme, final WorkflowStep step ,final WorkflowAction action) {
    	
		SystemActionWorkflowActionMapping mapping = null;
		
		try {

	    	switch (action.getName()) {    	
	
		    	case WFWConfigConstants.SAVE_ACTION_NAME:
					if(WFWConfigConstants.UNPUBLISH_STEP_NAME.equalsIgnoreCase(step.getName())) {
						mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.NEW, action, scheme);
	    				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.EDIT, action, scheme);
					}
					
					break;

		    	case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
    				if(WFWConfigConstants.PUBLISH_STEP_NAME.equalsIgnoreCase(step.getName())) {
    					mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.PUBLISH, action, scheme);    					
    				}
    				
    				break;

		    	case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
    				if(WFWConfigConstants.UNPUBLISH_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.UNPUBLISH, action, scheme);    	
    				}

    				break;
    				
		    	case WFWConfigConstants.ARCHIVE_ACTION_NAME:
    				if(WFWConfigConstants.UNPUBLISH_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.ARCHIVE, action, scheme);   
    				}
    				
    				break;    				

		    	case WFWConfigConstants.UNARCHIVE_ACTION_NAME:
    				if(WFWConfigConstants.ARCHIVE_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.UNARCHIVE, action, scheme);   
    				}
    				
    				break;    				

		    	case WFWConfigConstants.DELETE_ACTION_NAME:
    				if(WFWConfigConstants.ARCHIVE_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.DELETE, action, scheme);    					
    				}

    				break;

		    	case WFWConfigConstants.DESTROY_ACTION_NAME:	
    				if(WFWConfigConstants.ARCHIVE_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.DESTROY, action, scheme);
    				}

    				break;
    				
    			default:
	    	}
	    	
		} catch (DotDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    /**
     * This method add default action 
     * This method permit to the folder publish action utilizes the default publish action from your workflow.
     * @param scheme
     * @param step
     * @param action
     */
    private static void changeRequestWorkflowActionMappingAddDefaultAction(final WorkflowScheme scheme, final WorkflowStep step ,final WorkflowAction action) {
    	
		SystemActionWorkflowActionMapping mapping = null;
		
		try {

	    	switch (action.getName()) {    	
	
		    	case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
					if(WFWConfigConstants.START_STEP_CHANGE_REQUEST.equalsIgnoreCase(step.getName())) {
	    				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.NEW, action, scheme);
	    				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.EDIT, action, scheme);
					}
					
					break;

		    	case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
		    		if(WFWConfigConstants.START_STEP_CHANGE_REQUEST.equalsIgnoreCase(step.getName())) {
		    			mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.PUBLISH, action, scheme);    					
		    		}
		    		
    				break;

		    	case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
    				if(WFWConfigConstants.START_STEP_CHANGE_REQUEST.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.UNPUBLISH, action, scheme);    					
    				}

    				break;
    				
		    	case WFWConfigConstants.REJECT_ACTION_NAME:
    				if(WFWConfigConstants.START_STEP_CHANGE_REQUEST.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.ARCHIVE, action, scheme);    					
    				}
    				
    				break;    				

		    	case WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME:
    				if(WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.UNARCHIVE, action, scheme);    					
    				}
    				
    				break;    				

		    	case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
    				if(WFWConfigConstants.START_STEP_CHANGE_REQUEST.equalsIgnoreCase(step.getName())) {
        				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme(WorkflowAPI.SystemAction.DELETE, action, scheme);    					

	    				// no tiene eliminar el wfw entonces seteo el destroy por default
	    				mapping = workflowAPI.mapSystemActionToWorkflowActionForWorkflowScheme( WorkflowAPI.SystemAction.DESTROY, action, scheme);    					
    				}

    				break;
    				
    			default:
	    	}
	    	
		} catch (DotDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

	
    /**
     * REFACTORME
     * SQLQUERY: SELECT cr1.id AS childId, cr1.role_name AS roleName, cr2.id AS parentId,  cr2.role_name AS parentName FROM cms_role cr1, cms_role cr2 
     * WHERE cr1.role_name = 'GRGDOTCMS-INGINTRA-VIS' AND cr1.parent = cr2.id AND cr1.parent != cr1.id ORDER BY lower(cr1.role_name)
     * 
     * @param param
     * @param action
     * @return <code>Permission[]</code> permissions
     * @throws DotDataException
     */
    private static Permission[] asListPermissionWhoCanUse(String stepName, WorkflowAction action) throws DotDataException {
    	Permission[] permissions = null;
    	switch (action.getName()) {    	
    		case WFWConfigConstants.ADD_PAGE_ACTION_NAME:
    			permissions = new Permission[]{
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    				break;
    		case WFWConfigConstants.REQUEST_ADD_OF_PAGE_ACTION_NAME:
				permissions = new Permission[]{
	                new Permission(action.getId(),
	                		roleAPI.findRoleByName("GRGDOTCMS-INGINTRA-VIS", roleAPI.findRoleByName("OSDE", null)).getId(),
	                        PermissionAPI.PERMISSION_USE)};
				break;
    		case WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME:
    			permissions = new Permission[]{
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-INGINTRA-VIS", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			break;
    		case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
    			permissions = new Permission[]{
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			break;
    		case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
    			if (ChangeRequestConfigMappingHandler.isSystemWorkflow(action.getSchemeId())){
    				permissions = new Permission[]{        	                
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE)};
    				break;
    			} else {
    			permissions = new Permission[]{
    					//Se elimina rol GRGDOTCMS-VALIDADORES-GENERAL
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};

    			break;
    			}
    		case WFWConfigConstants.REJECT_ACTION_NAME:
    			if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME) || 
    					stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME) ||
    					stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME)) {
        			permissions = new Permission[]{
        				//Se elimina rol GRGDOTCMS-VALIDADORES-GENERAL
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
        	        
        	                		PermissionAPI.PERMISSION_USE)};    				
    			} else {

    				permissions = new Permission[]{
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			}
    			break;
    		case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
    			if(stepName.equalsIgnoreCase(WFWConfigConstants.START_STEP_CHANGE_REQUEST) || stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME)) { 
        			permissions = new Permission[]{
        					
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                
        					
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	   
        	                
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AFILIACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ATENCION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AUTORIZACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-CAPACITACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COBRANZAS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COMERCIAL", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-DISCASMYAD", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-FACTURACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INSUMOS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INTERTURIS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ODONTOLOGIA", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PARTICULARIDADES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PRACYCIG", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE)};
        			 	break;

    			} else 
    			if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME) || stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME)) {
    				permissions = new Permission[]{
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			} else {
        			permissions = new Permission[]{
        	               //Se elimina rol GRGDOTCMS-VALIDADORES-GENERAL
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE)};    				
    			}
    			break;

    		case WFWConfigConstants.REQUEST_PUBLISH_ACTION_NAME:
    			permissions = new Permission[]{
    					
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                
    					
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AFILIACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ATENCION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AUTORIZACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-CAPACITACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COBRANZAS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COMERCIAL", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-DISCASMYAD", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-FACTURACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INSUMOS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INTERTURIS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ODONTOLOGIA", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PARTICULARIDADES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			 	break;

    		case WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME:
    			if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME)) {

    				permissions = new Permission[]{
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AFILIACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-APE", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ATENCION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AUTORIZACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-BIOQUIMICA", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-CAPACITACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COBGRANDESEMP", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COBRANZAS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COMERCIAL", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-DISCASMYAD", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-FACTURACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                
        	                //Se elimina rol GRGDOTCMS-VALIDADORES-GENERAL
        	                
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INSUMOS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INTERTURIS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),

        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-MEDICAMENTOS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),

        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-NOMENCLADOR", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),

        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ODONTOLOGIA", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PARTICULARIDADES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE),
        	                new Permission(action.getId(),
        	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PRACYCIG", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
        	                        PermissionAPI.PERMISSION_USE)};    				

    			} else {
    				permissions = new Permission[]{
    	                
    					new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GPRO-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                       PermissionAPI.PERMISSION_USE),
    	                
    						
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-ALTO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-BAJO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-GSNE-MEDIO", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	   
    	                
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AFILIACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ATENCION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-AUTORIZACIONES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-CAPACITACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COBRANZAS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-COMERCIAL", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-DISCASMYAD", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-FACTURACION", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INSUMOS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-INTERTURIS", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-ODONTOLOGIA", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PARTICULARIDADES", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE),
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES-PRACYCIG", roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			}
    			 	break;
    		default:
    			permissions = new Permission[]{    	              
    	                new Permission(action.getId(),
    	                		roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId(),
    	                        PermissionAPI.PERMISSION_USE)};
    			
    	}
    	
    	return permissions;
    }
    
    
    /**
     * Add a subaction
     *
     * @param name name of the subaction
     * @param actionId Action id where the subaction should be associated
     * @param actionClassToUse The subaction classs to use
     * @param order Order of executions
     */
    protected static WorkflowActionClass addSubActionClass(final String name, final String actionId,
            final Class actionClassToUse, final int order)
            throws DotDataException, DotSecurityException {
        WorkflowActionClass actionClass = null;
        
        try {
        	actionClass = new WorkflowActionClass();
            actionClass.setActionId(actionId);
            actionClass.setClazz(actionClassToUse.getCanonicalName());
            actionClass.setName(name);
            actionClass.setOrder(order);            
                            
            workflowAPI.saveActionClass(actionClass, APILocator.systemUser());            	

            // add scritping 
            if(actionClassToUse==VelocityScriptActionlet.class) {
				String code = "";
				
				final String codeUnpublish = "#set($headers = {})\r\n" + "\r\n"
						+ "$headers.put(\"Cookie\", $request.getHeader(\"Cookie\"))\r\n"
						+ "$headers.put(\"Referer\", $request.getHeader(\"Referer\"))\r\n" + "\r\n"
						+ "$json.fetch( \"$request.getScheme()://$request.getServerName():$request.getServerPort()/ingesta/?identifier=$content.identifier&action=unpublish\", $headers)\r\n"
						+ " \n";
				
				final String codePublish = "#set($headers = {})\r\n" + "\r\n"
						+ "$headers.put(\"Cookie\", $request.getHeader(\"Cookie\"))\r\n"
						+ "$headers.put(\"Referer\", $request.getHeader(\"Referer\"))\r\n" + "\r\n"
						+ "$json.fetch( \"$request.getScheme()://$request.getServerName():$request.getServerPort()/ingesta/?identifier=$content.identifier&action=publish\", $headers)\r\n"
						+ " \n";

				WorkflowAction workflowAction = workflowAPI.findAction(actionId, user);

				String workflowActionName = workflowAction.getName();

				switch (workflowActionName) {
				
				case "Eliminar Contenido":
					code = codeUnpublish;
					break;
				case "Despublicar":
					code = codeUnpublish;
					break;
				case "Guardar y Publicar":
					code = codePublish;
					break;
				case "Publicar":
					code = codePublish;
					break;
				case "Desarchivar":
					code = codeUnpublish;
					break;
//				default:
//					System.out.println("no coincide para " + workflowActionName);
				}

            	final List<WorkflowActionClassParameter> params = new ArrayList<>();
	            final WorkflowActionClassParameter parameter = new WorkflowActionClassParameter();
	            parameter.setActionClassId(actionClass.getId());
	            parameter.setKey("script");
	            parameter.setValue(code);
	            params.add(parameter);
	            final WorkflowActionClassParameter parameterResult = new WorkflowActionClassParameter();
	            parameterResult.setActionClassId(actionClass.getId());
	            parameterResult.setKey("resultKey");
	            parameterResult.setValue("result");
	            params.add(parameterResult);
	            workflowAPI.saveWorkflowActionClassParameters(params, APILocator.systemUser());
            } 

        } catch (AlreadyExistException e) {
            //scheme already exist
        		e.printStackTrace();
        }
        
        return actionClass;
    }

    

	/**
	 * This method set enum by step and action
	 * @return Set<WorkflowState> enumset
	 */
	private static java.util.Set<WorkflowState> setEnumSet(final String stepName, final String actionName) {

		java.util.Set<WorkflowState> enumset = null; //EnumSet.of();

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.START_STEP_CHANGE_REQUEST)) {
			switch (actionName) {
			case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.UNLOCKED, 
						WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.UNLOCKED, WorkflowState.LOCKED, WorkflowState.PUBLISHED);
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REQUEST_PUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			}
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING,WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;						
			}            		
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.REJECT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			}            		
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			}            		
    	}


    	/************************************************************************************************************************************
         * Mapping Step Solicitar Modificacion.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME)) {
    			enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
			}            		
    	}

    	/************************************************************************************************************************************
         * Mapping Step Solicitar creación de página.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.REQUEST_ADD_PAGE_STEP_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.REQUEST_ADD_OF_PAGE_ACTION_NAME)) {
    			enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
			}            		
    	}

    	/************************************************************************************************************************************
         * Mapping Step Pendiente de creacion de pagina.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.ADD_PAGE_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING,WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING,WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_OF_PAGE_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING,WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			}            		
    	}

        /************************************************************************************************************************************
         * Mapping Step Pendiente de validacion de pagina.
         ***********************************************************************************************************************************/                
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME)) {
    			enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
			}            		
    	}

		return enumset;

	}
	
	/**
	 * This method set enum by step and action
	 * @return Set<WorkflowState> enumset
	 */
	private static java.util.Set<WorkflowState> setEnumSetSystemWorkflow(final String stepName, final String actionName) {

		java.util.Set<WorkflowState> enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED,
				WorkflowState.UNPUBLISHED);

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.START_STEP_WORKFLOW_SYSTEM)) {
			switch (actionName) {
			case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW,
						WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED);
				break;
			}
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PUBLISH_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.COPY_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED);
				break;
			case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.LISTING, WorkflowState.EDITING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED);
				break;			
			}            		
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.ARCHIVE_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.UNARCHIVE_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			case WFWConfigConstants.DELETE_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.UNLOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNPUBLISHED, WorkflowState.ARCHIVED);
				break;
			}            		
    	}

    	if(stepName.equalsIgnoreCase(WFWConfigConstants.UNPUBLISH_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.LISTING, WorkflowState.EDITING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED);
				break;
			case WFWConfigConstants.COPY_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNLOCKED, WorkflowState.UNPUBLISHED);
				break;
			case WFWConfigConstants.PUBLISH_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.LOCKED, WorkflowState.UNLOCKED, WorkflowState.UNPUBLISHED);
				break;
			case WFWConfigConstants.ARCHIVE_ACTION_NAME:
				enumset = EnumSet.of(WorkflowState.EDITING, WorkflowState.LISTING, WorkflowState.LOCKED, WorkflowState.NEW, WorkflowState.PUBLISHED, WorkflowState.UNLOCKED, WorkflowState.UNPUBLISHED);
				break;
			}            		
    	}    	

		return enumset;

	}

	/**
	 * This method getNextAssignby step and action
	 * @return role.id
	 * @throws DotSecurityException 
	 * @throws NoSuchUserException 
	 */
	private static String getNextAssign(String stepName, String actionName) throws DotDataException, NoSuchUserException, DotSecurityException {
		String nextAssignedRoleId = null;
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.START_STEP_CHANGE_REQUEST)) {
			switch (actionName) {
			case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.UNPUBLISH_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("CMS Anonymous", roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null)).getId();
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				nextAssignedRoleId = roleAPI.loadRoleByKey(APILocator.getUserAPI().loadByUserByEmail( "admin@dotcms.com", user, false ).getUserId()).getId();
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				nextAssignedRoleId = roleAPI.loadRoleByKey(APILocator.getUserAPI().loadByUserByEmail( "admin@dotcms.com", user, false ).getUserId()).getId();
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("CMS Anonymous", roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null)).getId();
				break;
			case WFWConfigConstants.REQUEST_PUBLISH_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null).getId();
				break;
			}
    	}
    	
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("CMS Anonymous", roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null)).getId();
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null).getId();
				break;						
			}            		
    	}
    	
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.REJECT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null).getId();
				break;
			}            		
    	}

    	
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("CMS Anonymous", roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null)).getId();
				break;
			case WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			}            		
    	}


    	/************************************************************************************************************************************
         * Mapping Step Solicitar Modificacion.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME)) {
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
			}            		
    	}

    	/************************************************************************************************************************************
         * Mapping Step Solicitar creación de página.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.REQUEST_ADD_PAGE_STEP_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.REQUEST_ADD_OF_PAGE_ACTION_NAME)) {
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
			}            		
    	}

    	/************************************************************************************************************************************
         * Mapping Step Pendiente de creacion de pagina.
         ***********************************************************************************************************************************/
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME)) {
			switch (actionName) {
			case WFWConfigConstants.ADD_PAGE_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.REJECT_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
				break;
			case WFWConfigConstants.REQUEST_VALIDATION_OF_PAGE_ACTION_NAME:
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-VALIDADORES", null).getId();
				break;
			}            		
    	}

        /************************************************************************************************************************************
         * Mapping Step Pendiente de validacion de pagina.
         ***********************************************************************************************************************************/                
    	if(stepName.equalsIgnoreCase(WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME)) {
    		if(actionName.equalsIgnoreCase(WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME)) {
				nextAssignedRoleId = roleAPI.findRoleByName("GRGDOTCMS-WFW-ADM-GRAL", roleAPI.findRoleByName("OSDE", null)).getId();
			}            		
    	}


    	
    	return nextAssignedRoleId;

	}
	
	/**
	 * This method getNextAssign by step and action
	 * @return role.id
	 * @throws DotSecurityException 
	 * @throws NoSuchUserException 
	 */
	private static String getNextAssignSystemWorkflow(String stepName, String actionName) throws DotDataException, NoSuchUserException, DotSecurityException {
		String nextAssignedRoleId = null;
		switch (actionName) {
		case WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME:
			nextAssignedRoleId = roleAPI.loadRoleByKey(APILocator.getUserAPI().loadByUserByEmail( "admin@dotcms.com", user, false ).getUserId()).getId();
			break;
		default:
			nextAssignedRoleId = roleAPI.findRoleByName("CMS Anonymous", roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null)).getId();
    	}
    	
    	return nextAssignedRoleId;
	}
	
	/**
	 * This method getNextStep by step and action
	 * @return nextStepId
	 * @throws DotSecurityException 
	 * @throws NoSuchUserException 
	 */
	private static String getNextStepSystemWorkflow(String stepName, String actionName, String nextStep) throws DotDataException, NoSuchUserException, DotSecurityException {
		String nextStepId;	
		
		switch (actionName) {
		case WFWConfigConstants.COPY_ACTION_NAME:
			nextStepId = "currentstep";
			break;
		default:
			nextStepId = workflowAPI.findStep(nextStep).getId();    	
		}
		
		return nextStepId;
	}

	public WorkflowScheme getChangeRequestWFScheme() {
		return this.wfScheme;
	}

	public void setChangeRequestWFScheme(WorkflowScheme changeRequestWFScheme) {
		this.wfScheme = changeRequestWFScheme;
	}

    

}
