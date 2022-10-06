package com.biblos.adapter.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.dotmarketing.business.DotStateException;
import com.dotmarketing.business.Role;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.business.RoleAPIImpl;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.util.Logger;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PropsUtil;
import com.biblos.adapter.RoleAdapter;
import com.biblos.loader.AuthorizationPropertiesLoader;

public class RoleAdapterImpl implements RoleAdapter {

	private static String OSDE_PARENT_ROLE = "osdeParentRole";
	private RoleAPI rapi;
	private String parentRoleName;

	public RoleAdapterImpl() {
		rapi = new RoleAPIImpl();
		try {
			this.loadParentRole();
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
		}
	}
	
	public void loadParentRole() {
		try {
			Properties properties = AuthorizationPropertiesLoader.loadAllProperties();
			parentRoleName = AuthorizationPropertiesLoader.getProperty(properties, OSDE_PARENT_ROLE);
			this.setParentRoleName(parentRoleName);
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
		}
		
	}

	public void loadParentRole(String parentRoleName) {
		this.setParentRoleName(parentRoleName);
	}

	/**
	 * Creates a new role with the name and saves it as a parent sub-category.
	 * */
	private Role createNewRole(String name, String description, Role parent) {
		try {
			Role newRole = new Role();
			newRole.setName(name);
			newRole.setDescription(description);
			if (parent != null)
				newRole.setParent(parent.getId());
			rapi.save(newRole);
			return this.getRole(name,parent);
		} catch (DotDataException e) {
			Logger.error(this, e.getMessage(), e);
		}
		return null;
	}

	/**
	 * This method retrieves the parent role configured which groups all the
	 * roles.
	 * */
	private Role getRole(String name, Role parent) {
		if (name.compareTo("") == 0)
			return null;
		Role role = null;
		try {
			role = rapi.findRoleByName(name, parent);
		} catch (DotDataException e) {
			Logger.error(this, e.getMessage(), e);
		}
		return role;
	}
	
	private Role getRoleOrCreate(String name, String description, Role parent) {
		Role role = this.getRole(name,parent);
		if (role == null) {
			role = createNewRole(name, description, parent);
		}
		return role;
	}

	public RoleAPI getRapi() {
		return rapi;
	}
	public void setRapi(RoleAPI rapi) {
		this.rapi = rapi;
	}
	public String getParentRoleName() {
		return parentRoleName;
	}
	public void setParentRoleName(String parentRoleName) {
		this.parentRoleName = parentRoleName;
	}

	
	
/* -- Implement interface -- */	
	
	public Role getRoleFromPermissionOrCreate(String name, String description){
		return this.getRoleOrCreate(name, description, this.getPermissionParentRole());
	}
	
	public Role getRoleFromPermission(String name){
		return this.getRole(name, this.getPermissionParentRole());
	}
	
	public boolean permissionExist(String name){
		try {
			return rapi.roleExistsByName(name, this.getPermissionParentRole());
		} catch (DotDataException e) {
			Logger.error(this, e.getMessage(), e);
		}
		return false;
	}

	public Role getPermissionParentRole() {
		return this.getRoleOrCreate(this.getParentRoleName(),"",null);
	}
	
	public boolean addRoleToUser(Role role, User user) {
		try {
			if (!rapi.doesUserHaveRole(user,role)) {
				rapi.addRoleToUser(role, user);
			}
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		}
		return true;
	}

	public boolean removeAllRolesFromUser(User user) {
		try {				
			if(user != null) {
				List<Role> roles = rapi.loadRolesForUser(user.getUserId(), false);
				for (Role role:roles) {
					if (rapi.doesUserHaveRole(user,role)) {
						rapi.removeRoleFromUser(role, user);
					}
				}
			}			
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		}
		return true;
	}
	
	public boolean removeRoleFromUser( Role role, User user ) {
		try {
			if (rapi.doesUserHaveRole(user,role)) {
				rapi.removeRoleFromUser(role, user);
			}
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		}
		return true;
	}
	
	public boolean deleteRole(Role role) {
		if (role == null)
			return false;
		
		try {
			rapi.delete(role);
		} catch (DotStateException e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		} catch (DotDataException e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		}
		
		return true;
	}

	public Role findRoleByName(String name, Role parent) throws DotDataException {
		return rapi.findRoleByName(name, parent);
	}

	@Override
	public boolean updateRolesFromUser(Set<Role> rolesActuales, User userDot) {
		try {
			
			if(userDot == null) {
				return false;
			}
			
			List<Role> rolesExistentes = rapi.loadRolesForUser(userDot.getUserId(), false);
							
			Set<Role> rolesNuevos = new HashSet<Role>(rolesActuales);
			rolesNuevos.removeAll(rolesExistentes);
			
			Set<Role> rolesQuitados = new HashSet<Role>(rolesExistentes);
			rolesQuitados.removeAll(rolesActuales);
			
			for (Role role:rolesQuitados) {
				if( !role.isSystem() && rapi.doesUserHaveRole(userDot,role) ) {
					Logger.info(this, " SE QUITA DEL USUARIO " + userDot.getUserId().toUpperCase() + " EL ROL " + role.getName() + ": " + role.getDescription() );
					rapi.removeRoleFromUser(role, userDot);
				}
			}
			
			for (Role role:rolesNuevos) {
				Logger.info(this, " SE AGREGA AL USUARIO " + userDot.getUserId().toUpperCase() + " EL ROL " + role.getName() + ": " + role.getDescription() );
				rapi.addRoleToUser(role, userDot);
			}

			rolesExistentes = rapi.loadRolesForUser(userDot.getUserId(), false);
			Logger.info(this, "Roles actuales "+ rolesExistentes.size() );
			
		} catch (Exception e) {
			Logger.error(this, e.getMessage(), e);
			return false;
		}
		
		return true;
	}
}
