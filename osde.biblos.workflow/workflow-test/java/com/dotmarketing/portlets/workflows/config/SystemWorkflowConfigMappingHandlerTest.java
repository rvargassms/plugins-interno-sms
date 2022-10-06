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
 * This test is for configuring the system workflow
 */
public class SystemWorkflowConfigMappingHandlerTest extends IntegrationTestBase {

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
    public void test_workflow_system_config() {

    	ChangeRequestConfigMappingHandler handler = new ChangeRequestConfigMappingHandler(user, contentTypeAPI,
        		fieldAPI,
        		roleAPI,
        		workflowAPI);    	
    	
		WorkflowScheme scheme = null;
		
		try {
			scheme = ChangeRequestConfigMappingHandler.findWorkflowScheme(WFWConfigConstants.WORK_FLOW_SYSTEM);
		} catch (DotDataException e) {
			e.printStackTrace();
		}		
		
		if (scheme!= null) {
			handler.deleteStepsInScheme(scheme);
		}		
		
    	
        ChangeRequestWorkflowConfigMapping actionMapping = new ChangeRequestWorkflowConfigMapping(WFWConfigConstants.WORK_FLOW_SYSTEM, scheme);
        
        /**********************************************************************************************************************************
         * Mapping Step Nuevo.
         ***********************************************************************************************************************************/

        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.START_STEP_WORKFLOW_SYSTEM, 0, null);
        
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_ACTION_NAME, 0, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 2, user, null);
        
            
		actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 1, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.PUBLISH_STEP_NAME, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 3, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);


        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_ACTION_NAME, 2, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);


      
        /************************************************************************************************************************************
         * Mapping Step Despublicar.
         ***********************************************************************************************************************************/
        
        
    	actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_STEP_NAME, 1, null);
    	
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 2, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.PUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 3, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);

    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.ARCHIVE_ACTION_NAME, 2, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.ARCHIVE_STEP_NAME, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.ARCHIVE_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 1, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_ACTION_NAME, 3, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.PUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 3, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.COPY_ACTION_NAME, 4, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.COPY_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.LOCK_CONTENT_SUBACTION, 1, user, null);
                
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_ACTION_NAME, 5, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);

        /************************************************************************************************************************************
        * Mapping Step Publicar
        ***********************************************************************************************************************************/
        
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_STEP_NAME, 2, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_ACTION_NAME, 0, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 2, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, 1, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.PUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 3, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);

        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_ACTION_NAME, 2, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.PUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VALIDATION_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.SAVE_CONTENT_SUBACTION, 1, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.PUBLISH_CONTENT_SUBACTION, 2, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNLOCK_CONTENT_SUBACTION, 3, user, null);        
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 4, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_ACTION_NAME, 3, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);
        
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.COPY_ACTION_NAME, 4, user, false, false, true, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.START_STEP_WORKFLOW_SYSTEM, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.COPY_CONTENT_SUBACTION, 0, user, null);
        actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.LOCK_CONTENT_SUBACTION, 1, user, null);
                
        
        /************************************************************************************************************************************
         * Mapping Step Archivar.
         ***********************************************************************************************************************************/        
        
        actionMapping.mapStepToWorkflowActionForWorkflowScheme(WFWConfigConstants.ARCHIVE_STEP_NAME, 3, null);
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNARCHIVE_ACTION_NAME, 0, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.UNPUBLISH_STEP_NAME, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.MARK_COMPLETE_SUBACTION, 0, user, null);    
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.VELOCITY_SCRIPT_ACTIONLET_SUBACTION, 1, user, null);   
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 2, user, null);   
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNARCHIVE_SUBACTION, 3, user, null);
		
    	actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.DELETE_ACTION_NAME, 1, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.ARCHIVE_STEP_NAME, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.UNPUBLISH_CONTENT_SUBACTION, 0, user, null);
    	actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.REMOVE_SUBACTION, 1, user, null);

    	
        actionMapping.mapActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.DESTROY_ACTION_NAME, 2, user, false, false, false, TestUserUtils.getAnyoneWhoCanEditContentRole(), WFWConfigConstants.ARCHIVE_STEP_NAME, null);
		actionMapping.mapSubActionToWorkflowActionForWorkflowScheme(WFWConfigConstants.DESTROY_SUBACTION, 0, user, null);
		

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

		assertEqualsActions(actionMapping.getWorkFlowActions(), Arrays.asList(WFWConfigConstants.SAVE_ACTION_NAME, WFWConfigConstants.SAVE_AND_PUBLISH_ACTION_NAME, WFWConfigConstants.UNPUBLISH_ACTION_NAME));
		
		assertEqualsActions(actionMapping.getWorkFlowActions(), Arrays.asList(WFWConfigConstants.UNARCHIVE_ACTION_NAME, WFWConfigConstants.DELETE_ACTION_NAME, WFWConfigConstants.DESTROY_ACTION_NAME));
   	
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