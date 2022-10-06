package com.dotmarketing.portlets.workflows.config;

import java.util.Map;

import com.dotcms.business.WrapInTransaction;
import com.dotcms.datagen.RoleDataGen;
import com.dotmarketing.beans.Host;
import com.dotmarketing.beans.Permission;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.PermissionAPI;
import com.dotmarketing.business.Role;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.business.PermissionAPI.PermissionableType;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.google.common.collect.ImmutableMap;
import com.liferay.portal.model.User;

public class TestUserUtils {

    @WrapInTransaction
    public static Role getOrCreateWfwAdmGralRole() {
        try {
			return getOrCreateWfwAdmGralRole(APILocator.systemHost());
		} catch (DotDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DotSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
    
    @WrapInTransaction
    public static Role getOrCreateWfwAdmGralRole(final Host host)
            throws DotDataException, DotSecurityException {
        final String roleName = "GRGDOTCMS-WFW-ADM-GRAL";
        final int permissions = (PermissionAPI.PERMISSION_READ | PermissionAPI.PERMISSION_USE);
        final Map<PermissionableType, Integer> permissionsAndTypes =
                new ImmutableMap.Builder<PermissionableType, Integer>()
                        .put(PermissionableType.FOLDERS, permissions)
                        .put(PermissionableType.HTMLPAGES, permissions)
                        .put(PermissionableType.LINKS, permissions)
                        .put(PermissionableType.STRUCTURES, permissions)
                        .put(PermissionableType.CONTENTLETS, permissions)
                        .build();
        final Role parent = APILocator.getRoleAPI().findRoleByName("Osde", null);
        return getOrCreateRole(host, roleName, parent, true, permissionsAndTypes);
    }

    @WrapInTransaction
    private static Role getOrCreateRole(final Host host, final String roleName,
            final Role parentRole, boolean editLayouts,
            final Map<PermissionableType, Integer> typesAndPermissions)
            throws DotDataException, DotSecurityException {
        final RoleAPI roleAPI = APILocator.getRoleAPI();
        Role role = roleAPI.findRoleByName(roleName, parentRole);
        if (role == null) {
            final User user = APILocator.systemUser();
            final String parentId = parentRole != null ? parentRole.getId() : null;
            role = new RoleDataGen().name(roleName).key(roleName).editPermissions(true)
                    .editUsers(true).editLayouts(editLayouts).parent(parentId).nextPersisted();

            for (final PermissionableType type : typesAndPermissions.keySet()) {
                final int permission = typesAndPermissions.get(type);
                final Permission permissions = new Permission(
                        type.getCanonicalName(),
                        host.getPermissionId(),
                        role.getId(),
                        permission);
                APILocator.getPermissionAPI().save(permissions, host, user, false);
            }
        }
        return role;
    }
    
	public static Role getAnyoneWhoCanEditContentRole() {
		final RoleAPI roleAPI = APILocator.getRoleAPI();
		Role anyone = null;
		try {
			anyone = roleAPI.findRoleByName("Anyone who can Edit Content",
					roleAPI.findRoleByName(RoleAPI.SYSTEM_ROOT_ROLE_KEY, null));
		} catch (DotDataException e) {
			e.printStackTrace();
		}
		return anyone;
	}

}
