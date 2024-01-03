package com.vivek.users.dao;

import java.sql.SQLException;

public interface UserDAO {
	
	public boolean isUserExist(String userId,String password) throws SQLException;

}
