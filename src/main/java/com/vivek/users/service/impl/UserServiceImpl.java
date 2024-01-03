package com.vivek.users.service.impl;

import java.io.InvalidObjectException;
import java.sql.Connection;

import com.vivek.commonutils.ValidateUtils;
import com.vivek.dbcon.ConnectionProvider;
import com.vivek.users.dao.UserDAO;
import com.vivek.users.dao.jdbcdao.JDBCUserDAO;
import com.vivek.users.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean verifyLoginCreds(String userId, String password) throws Exception {
		
		if (ValidateUtils.isStringEmpty(userId)) {
			throw new InvalidObjectException("User Id is Mandatory");
		}
		else if (ValidateUtils.isStringEmpty(password)) {
				throw new InvalidObjectException("password is Mandatory");
			}
		
		
	
		Connection connection = ConnectionProvider.getConnection();
		UserDAO userDAO = new JDBCUserDAO(connection);
		 
		
		if(userDAO.isUserExist(userId, password)) {
			return true;
		}else {
			throw new InvalidObjectException("invalid credentials");
		}
		
	}
		
		
	}

	


