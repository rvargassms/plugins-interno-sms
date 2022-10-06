package com.biblos.adapter.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

//import com.dotcms.repackage.com.sun.syndication.io.impl.PropertiesLoader;
import org.apache.commons.lang3.StringUtils;
import com.dotmarketing.business.CacheLocator;
import com.dotmarketing.business.DuplicateUserException;
import com.dotmarketing.business.NoSuchUserException;
import com.dotmarketing.business.UserAPI;
import com.dotmarketing.business.UserAPIImpl;
import com.dotmarketing.cms.factories.PublicCompanyFactory;
import com.dotmarketing.common.db.DotConnect;
import com.dotmarketing.db.DbConnectionFactory;
import com.dotmarketing.db.HibernateUtil;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotHibernateException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.util.Logger;
import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.model.User;
import com.biblos.adapter.UserAdapter;
import com.biblos.enums.EnumRoleKey;
import com.dotcms.enterprise.PasswordFactoryProxy;
import com.dotcms.enterprise.de.qaware.heimdall.PasswordException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;

public class UserAdapterImpl implements UserAdapter {
	
	private UserAPI uapi;
	private static final String INSERT_ROLE_TO_ALL_USERS = "EXEC dbo.sp_assign_role_allusers @role_key = '%s';";
	
	public UserAdapterImpl() {
		uapi = new UserAPIImpl();
	}
	
	public UserAPI getUapi() {
		return uapi;
	}
        
	public void setUapi(UserAPI uapi) {
		this.uapi = uapi;
	}
	
	public static void CreateRolToAllUsers(EnumRoleKey roleKey) throws DotDataException {
		try {
			DotConnect dbConnection = new DotConnect();
			String procedure = String.format(INSERT_ROLE_TO_ALL_USERS, roleKey.key());
			dbConnection.executeStatement(procedure);
		} catch (Exception e) {
			Logger.error("Error asignando rol a usuarios", e);
		}
	}

	private boolean createUserFor(Usuario userESB) throws DotDataException, SQLException {
			// FIX Fixed an error about the list usernames that has a short username, I had to modify to the synchronization process of users permits from intranet to backoffice. For that it add users that has short names.
			if(userESB == null || userESB.getUsername().length() < 3) {
				Logger.error(this, "No fue posible obtener el usuario desde la intranet de OSDE, intente más tarde o certifiquese de el servicio se encuentra disponible");
				return false;
			}
			User admin  = uapi.getSystemUser();
			String username = userESB.getUsername().toLowerCase().trim();
			String email = userESB.getEmail();
			ArrayList<User> users = new ArrayList<>();			
						
			if( !this.isValidEmailAddress(email)) {
				email = username + "@osde.com.ar";
			}					
			
			String newEmail = email.toLowerCase().trim();
																	
			try {						
				List<User> usuariosBiblos = new ArrayList<>();			
				DotConnect dbConnection = new DotConnect();
				DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date fechaModificacion = null;
				String currentPassword = null;
				Date dateCreated = null;
				
				StringBuilder sql = new StringBuilder("SELECT userId, mod_date FROM User_ WHERE userId IN (SELECT userId FROM User_ WHERE userId LIKE ");				 											
				sql.append("'%" + username.substring(2) + "%')");									
				dbConnection.setSQL(sql.toString());											
								
				ArrayList<Map<String, Object>> usersWithSameDNI = dbConnection.loadResults();								
								
				if(usersWithSameDNI.isEmpty()) {
					
					if (userExistsWithEmail(newEmail)){
						newEmail = this.createTemporaryEmail(newEmail, username);
					}
					
					this.updateUserAndAllConstraintDataRelated(null, userESB, admin, username, newEmail, null, null);
										
				}else{
					
					fechaModificacion = null;
					
					for(int i = 0; i < usersWithSameDNI.size(); i++) {
						Map<String, Object> hash = usersWithSameDNI.get(i);
						String userId = (String) hash.get("userid");
						
						if(userId != null && !userId.isEmpty()) {							
							User u = uapi.loadUserById(userId);
							currentPassword = u.getPassword();
							dateCreated = u.getCreateDate();
							users.add(u);
							String modDate = (String) hash.get("mod_date");
							if(modDate != null && !modDate.isEmpty()) {
								if(fechaModificacion == null || fechaModificacion.before(formatDate.parse((String)hash.get("mod_date")))) {
									fechaModificacion = (Date) formatDate.parse((String) hash.get("mod_date"));
									currentPassword = u.getPassword();
									dateCreated = u.getCreateDate();
								}
							} else {
								currentPassword = u.getPassword();
								dateCreated = u.getCreateDate();
							}
						}								
					}
					
					this.updateUserAndAllConstraintDataRelated(users, userESB, admin, username, newEmail, currentPassword, dateCreated);
				}																	
							
			} catch (Exception e) {
				Logger.error(this,"No existe el usuario: " +  userESB.getUsername() + " " + e.getMessage(), e);
			}	
			
		return isUserCreated(userESB);			
    }

	private void updateUserAndAllConstraintDataRelated(ArrayList<User> users, Usuario userESB, User admin,
			String username, String newEmail, String currentPassword, Date dateCreated) throws DotHibernateException, DotDataException, DotSecurityException, SQLException {
		
		Connection conn = null;
		try {			
			conn = DbConnectionFactory.getDataSource().getConnection();
			DotConnect db = new DotConnect();
			conn.setAutoCommit(false);
			if(users != null) {
				this.eliminateUserAndAllConstraintDataRelated(users, db);
				if (userExistsWithEmail(newEmail)){
					newEmail = this.createTemporaryEmail(newEmail, username);
				}
			}
			this.createUserInBiblos(userESB, admin, username, newEmail, currentPassword, dateCreated, db);
			
			conn.commit();
		} catch(SQLException ex) {
			conn.rollback();
		} finally {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}
	}

	/**
     * Retrieves the user associated to the key.
     * */
    private User getUser(Usuario userESB){
    	try{
    		return uapi.getUsersByNameOrEmailOrUserID(userESB.getUsername().toLowerCase().trim(),1,1).get(0);
    	}catch(DotDataException e){
    		Logger.error(this, e.getMessage(), e);
    		return null;
    	}
    }
    
    
   private void createUserInBiblos(Usuario usuarioIntranet, User usuarioWithSystemPermissions, String username, String email, String password, Date createDate, DotConnect db) 
		   throws DotHibernateException, DotDataException, SQLException, DotSecurityException{
    
	   try {
		   
	   if(username.length() > 3) {
					User userDot = null;				
					userDot = uapi.createUser(username, email);	
					userDot.setCreateDate((createDate != null) ? createDate : new java.util.Date());
					userDot.setFirstName(usuarioIntranet.getNombres());
					userDot.setLastName(usuarioIntranet.getApellidos());
					userDot.setCompanyId(PublicCompanyFactory.getDefaultCompanyId());
					userDot.setEmailAddress(email);
					userDot.setModificationDate(new java.util.Date());
					userDot.setPassword(PasswordFactoryProxy.generateHash(email));
					userDot.setPasswordEncrypted(true);
					
					uapi.save(userDot, usuarioWithSystemPermissions, true);
										
					/**
					 *  SE ACTUALIZA LAS RELACIONES CON LA TABLA DE USUARIO
					 */
						// Update Temporary Content and Workflow to real owners
						db.executeStatement("UPDATE contentlet SET mod_user = '" + username + "' WHERE mod_user = 'anonymous'");
						db.executeStatement("UPDATE contentlet_version_info SET locked_by = '" + username + "' WHERE locked_by = 'anonymous'");
		    			db.executeStatement("UPDATE template SET mod_user = '" + username + "' WHERE mod_user = 'anonymous'");
		    			db.executeStatement("UPDATE template_version_info SET locked_by = '" + username + "' WHERE locked_by = 'anonymous'");
		    			db.executeStatement("UPDATE dot_containers SET mod_user = '" + username + "' WHERE mod_user = 'anonymous'");
		    			db.executeStatement("UPDATE container_version_info SET locked_by = '" + username + "' WHERE locked_by = 'anonymous'");
				
	   }else {
		   Logger.error(this, "El usuario " + username + " registrado en dot no tiene un ID valido con los patrones de la intranet");
	   }
	   } catch(PasswordException ex) {
		   Logger.error(this, "Error al generar hash para la contraseña del usuario " + username);
	   }
    }
        
    
    private void eliminateUserAndAllConstraintDataRelated(ArrayList<User> usersToBeDeleted, DotConnect db) throws SQLException {	

    		for(User uniqueUser : usersToBeDeleted) {
        				// Update Temporary Content and Workflow owners    				        				        		
        				db.executeStatement("UPDATE contentlet SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser.getUserId() + "'");
        				db.executeStatement("UPDATE contentlet_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser.getUserId() + "'");
	        			db.executeStatement("UPDATE template SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser.getUserId() + "'");
	        			db.executeStatement("UPDATE template_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser.getUserId() + "'");
	        			db.executeStatement("UPDATE dot_containers SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser.getUserId() + "'");
	        			db.executeStatement("UPDATE container_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser.getUserId() + "'");
	        			        			
	        			db.executeStatement("DELETE FROM permission WHERE roleid IN (SELECT id FROM cms_role WHERE role_key='" + uniqueUser.getUserId() + "')");
						db.executeStatement("DELETE FROM users_cms_roles WHERE user_id= '" + uniqueUser.getUserId() + "'");
						db.executeStatement("DELETE FROM User_ WHERE userid = '" + uniqueUser.getUserId() + "'");										
    		}    		
    		CacheLocator.getUserCache().clearCache();
    }
    
    public void eliminateUserAndAllConstraintDataRelatedArrayString(ArrayList<String> usersToBeDeleted, DotConnect db) {	

		for(String uniqueUser : usersToBeDeleted) {
    				
					try {
						// Update Temporary Content and Workflow owners
	    				db.executeStatement("UPDATE contentlet SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser + "'");
	    				db.executeStatement("UPDATE contentlet_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser + "'");
	        			db.executeStatement("UPDATE template SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser + "'");
	        			db.executeStatement("UPDATE template_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser + "'");
	        			db.executeStatement("UPDATE dot_containers SET mod_user = 'anonymous' WHERE mod_user = '" + uniqueUser + "'");
	        			db.executeStatement("UPDATE container_version_info SET locked_by = 'anonymous' WHERE locked_by = '" + uniqueUser + "'");
        			        			
        			
						db.executeStatement("DELETE FROM permission WHERE roleid IN (SELECT id FROM cms_role WHERE role_key='" + uniqueUser + "')");
						db.executeStatement("DELETE FROM users_cms_roles WHERE user_id= '" + uniqueUser + "'");					
						db.executeStatement("DELETE FROM User_ WHERE userid = '" + uniqueUser + "'"); 
						db.executeStatement("INSERT into bitacora_sincronizacion (userId, estado, fecha_ejecucion ) values ('" + uniqueUser + "', '" + "Eliminado" + "', GETDATE())");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					
		}    		
		CacheLocator.getUserCache().clearCache();
}

    
    private boolean userExistsWithEmail( String email ) {
    	try{
    		return uapi.userExistsWithEmail(email);
    	} catch(DotDataException e){
    		return false;
    	}
    }
    
    
    private String createTemporaryEmail( String mail, String username ) {		
    	// TODO add randomNUmber
    	int randomNumber = ThreadLocalRandom.current().nextInt(100) + 1;
    	String newEmail = username + randomNumber + "@";							

		  if (mail.indexOf("@") > 0) {
			newEmail += mail.split("@")[1];
		}else {
			newEmail += "tempmail.com.ar";
		}
		  
		return newEmail;
    }
    
    
    private boolean isValidEmailAddress(String email) {
    	if( StringUtils.isEmpty(email) ) {
    		return false;
    	}
    	final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    
    /**
     * Retrieves the user associated to the key.
     * */
    public User getUser(String username){
    	try{
    		return uapi.loadUserById(username);
    	}catch(Exception e){
    		Logger.error(this, e.getMessage(), e);
    		return null;
    	}
    }
    
	
	public User updateUserOrCreate(Usuario userESB) throws SQLException {
		try {
			if (!createUserFor(userESB)) {
				Logger.error(this, "El usuario " + userESB.getUsername() + " no pudo ser creado");
				return null;
			} else {
				Logger.info(this, "El usuario " + userESB.getUsername() + " fue creado con exito");
			}
		} catch (DotDataException e) {
			// TODO Auto-generated catch block
			Logger.error(this, e.getMessage(), e);
		}
		return getUser(userESB);
	}

	
	/**
     * Checks whether the user is already created or not.
     * @throws DotDataException
     * */
    private boolean isUserCreated(Usuario userESB){
    	try{
    		return (uapi.getCountUsersByNameOrEmailOrUserID(userESB.getUsername().toLowerCase().trim()) > 0);
    	}catch(DotDataException e){
    		Logger.error(this, e.getMessage(), e);
    		return false;
    	}
	}
	
	@Override
	public User getUserOrCreate(Usuario userESB) {
		try {
			// FIXME add trim function that eliminates leading and trailing spaces
			if(this.getUser(userESB.getUsername().trim()) != null){
				
			}
		} catch (NoSuchUserException e) {
			
		}
		return null;
	}	
}
