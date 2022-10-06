package com.biblos.adapter;

import com.dotmarketing.business.Role;
import com.liferay.portal.model.User;

import java.util.Set;

public interface RoleAdapter {
	
	public Role getRoleFromPermissionOrCreate(String name, String description);
	
	public boolean removeAllRolesFromUser(User user);

	public void loadParentRole(String parentRoleName);
	
	public void loadParentRole();
	
    public Role getPermissionParentRole();

    /**
     * Actualiza los roles del usuario
     * @param rolesActuales
     * @param user
     * @return
     */
    boolean updateRolesFromUser(Set<Role> rolesActuales, User user);

}
