package com.biblos.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.dotmarketing.common.db.DotConnect;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotHibernateException;
import com.liferay.portal.model.User;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;

public interface UserAdapter {
	
	/**
     * Retrieves the user associated to the key.
     * && Creates it if not exist.
     * @throws DotDataException
     * */
	public User getUserOrCreate(Usuario userESB);
	public User getUser(String username);
	public User updateUserOrCreate(Usuario usuario) throws SQLException;
	public void eliminateUserAndAllConstraintDataRelatedArrayString(ArrayList<String> usersToBeDeleted, DotConnect db) throws SQLException;
}