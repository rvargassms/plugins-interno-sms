package com.dotmarketing.portlets.workflows.config;


import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dotcms.IntegrationTestBase;
import com.dotcms.contenttype.business.ContentTypeAPIImpl;
import com.dotcms.contenttype.business.FieldAPI;
import com.dotcms.util.IntegrationTestInitService;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.CacheLocator;
import com.dotmarketing.business.PermissionAPI;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;
import com.dotmarketing.portlets.contentlet.business.HostAPI;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import com.dotmarketing.portlets.workflows.business.WorkflowCache;
import com.dotmarketing.portlets.workflows.model.WorkflowScheme;
import com.liferay.portal.model.User;


/**
 * This test is for configuring the change request workflow
 */
public class ChangeRequestConfigMappingHandlerTest extends IntegrationTestBase {

    private static User user;
    private static Host defaultHost;
    protected static ContentTypeAPIImpl contentTypeAPI;
    protected static FieldAPI fieldAPI;
    protected static WorkflowAPI workflowAPI;
    protected static RoleAPI roleAPI;
    protected static PermissionAPI permissionAPI;
    protected static ContentletAPI contentletAPI;
    protected static WorkflowCache workflowCache;
    
    private ChangeRequestWorkflowConfigMapping actionMapping;
    
        
    @BeforeClass
    public static void prepare() throws Exception {
        //Setting web app environment
        IntegrationTestInitService.getInstance().init();


        HostAPI hostAPI = APILocator.getHostAPI();
        user = APILocator.getUserAPI().getSystemUser();
        defaultHost = hostAPI.findDefaultHost(user, false);
        contentTypeAPI = (ContentTypeAPIImpl) APILocator.getContentTypeAPI(user);
        fieldAPI = APILocator.getContentTypeFieldAPI();
        workflowAPI = APILocator.getWorkflowAPI();
        roleAPI = APILocator.getRoleAPI();
        permissionAPI = APILocator.getPermissionAPI();
        contentletAPI = APILocator.getContentletAPI();
        workflowCache = CacheLocator.getWorkFlowCache();        

        
    }   
    

    @Test
    public void test_change_request_config() {

    	ChangeRequestConfigMappingHandler handler = new ChangeRequestConfigMappingHandler(user, contentTypeAPI,
        		fieldAPI,
        		roleAPI,
        		workflowAPI);
    	
    	WorkflowScheme scheme = null;
		
		try {
			scheme = ChangeRequestConfigMappingHandler.findWorkflowScheme(WFWConfigConstants.WORK_FLOW_CHANGE_REQUEST);
		} catch (DotDataException e) {
			e.printStackTrace();
		}		
		
		if (scheme!= null) {
			handler.deleteStepsInScheme(scheme);
		}		
    	
        ChangeRequestWorkflowConfigMapping actionMapping = new ChangeRequestWorkflowConfigMapping(WFWConfigConstants.WORK_FLOW_CHANGE_REQUEST, scheme);
        
        /**********************************************************************************************************************************
         * Mapping Step Iniciado.
         ***********************************************************************************************************************************/

        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.START_STEP_CHANGE_REQUEST, 0, null);
        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.ARCHIVE_SUBACTION, 3, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REMOVE_SUBACTION, 4, user, null);
        
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_ACTION_NAME, 1, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST,null);		
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 2, user, null);

            
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 2, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 0, user, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 2, user, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 3, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 5, user, null);

        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, 3, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
        
      
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REJECT_ACTION_NAME, 4, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 3, user, null);
        

        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_PUBLISH_ACTION_NAME, 5, user, true, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME, null);		
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
        
        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME, 6, user, true, true, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME,null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 1, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);
                        
        	        
        /************************************************************************************************************************************
         * Mapping Step Pendiente de Publicacion (contenido).
         ***********************************************************************************************************************************/
        
        
    	actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME, 1, null);
    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.ARCHIVE_SUBACTION, 3, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REMOVE_SUBACTION, 4, user, null);
          
        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 2, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 3, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 4, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 5, user, null);

        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, 2, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);

        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REJECT_ACTION_NAME, 3, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 3, user, null);

        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME, 4, user, true, true, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 1, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);

        
        
        /************************************************************************************************************************************
         * Mapping Step Pendiente de Publicacion (solicitud).
         ***********************************************************************************************************************************/
        
        
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME, 2, null);
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REJECT_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 2, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 3, user, null);
        
    	
    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 1, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 2, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 3, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 4, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 5, user, null);
    	
    	
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, 2, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.LOCK_CONTENT_SUBACTION, 1, user, null);
    	
		
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME, 3, user, true, true, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 1, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);
    	

    	/************************************************************************************************************************************
         * Mapping Step Pendiente de validacion.
         ***********************************************************************************************************************************/
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME, 3, null);
        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, 0, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_VALIDATION_STEP_NAME, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.LOCK_CONTENT_SUBACTION, 1, user, null);
    	
    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.PENDING_OF_PUBLISH_STEP_NAME, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
    	
    	actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME, 2, null);
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME, null);


    	/************************************************************************************************************************************
         * Mapping Step Solicitar Modificacion.
         ***********************************************************************************************************************************/
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_MODIFY_STEP_NAME, 4, null);
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_MODIFY_ACTION_NAME, 0, user, false, false, false, TestUserUtils.getOrCreateWfwAdmGralRole(), WFWConfigConstants.PENDING_OF_PUBLISH_REQUEST_STEP_NAME, null);        
        
        

    	/************************************************************************************************************************************
         * Mapping Step Solicitar creación de página.
         ***********************************************************************************************************************************/
    	actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_ADD_PAGE_STEP_NAME, 5, null);
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_ADD_OF_PAGE_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME, null);


    	/************************************************************************************************************************************
         * Mapping Step Pendiente de creacion de pagina.
         ***********************************************************************************************************************************/
        
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME, 6, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.ADD_PAGE_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 2, user, null);
    	
    	
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REJECT_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.START_STEP_CHANGE_REQUEST, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.NOTIFY_ASSIGNEE_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 1, user, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 2, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RESET_WORKFLOW_SUBACTION, 3, user, null);

    	
    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REQUEST_VALIDATION_OF_PAGE_ACTION_NAME, 2, user, true, true, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 0, user, null);
    	
    	
        /************************************************************************************************************************************
         * Mapping Step Pendiente de validacion de pagina.
         ***********************************************************************************************************************************/
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PENDING_OF_VALIDATION_PAGE_STEP_NAME, 7, null);
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getOrCreateWfwAdmGralRole(),WFWConfigConstants.PENDING_OF_ADD_PAGE_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 0, user, null);

        
        
        
    	
        try {
        	
			handler.save(actionMapping);

        } catch (DotDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DotSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    	assertNotNull("user can not be null", user);

        assertNotNull("wfschema can not be null", actionMapping.getWorkFlowScheme());

		assertEqualsActions(actionMapping.getWorkFlowActions(), Arrays.asList(WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME, WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, WFWConfigConstants.REJECT_ACTION_NAME, WFWConfigConstants.REQUEST_PUBLISH_ACTION_NAME,WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME, WFWConfigConstants.UNPUBLISH_ACTION_NAME));
		
		assertEqualsActions(actionMapping.getWorkFlowActions(), Arrays.asList(WFWConfigConstants.REMOVE_CONTENT_ACTION_NAME, WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, WFWConfigConstants.SAVE_FOR_WORK_ACTION_NAME, WFWConfigConstants.REJECT_ACTION_NAME, WFWConfigConstants.REQUEST_VALIDATION_ACTION_NAME));

		assertEqualsActions(actionMapping.getWorkFlowActions(), Arrays.asList(WFWConfigConstants.RETURN_TO_CONTENTS_ACTION_NAME));
    	
    }
    
	private void assertEqualsActions(final Map<String, Object> mapActions,
            final List<String> actionsName) {

        for (final String param : actionsName) {

            Map<String, Object> collect = mapActions.entrySet().stream()
                    .filter(x -> x.getKey().equals(param))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        	            
        	assertNotNull("wfwactions can not be null", collect);    
        }        
    }

}