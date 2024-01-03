package com.vivek.users.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.users.dao.UserDAO;

public class JDBCUserDAO extends JDBCbaseDao implements UserDAO {
	
	public JDBCUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean isUserExist(String userId, String password) throws SQLException {
		String sqlQuery = "SELECT id FROM user_creds WHERE user_id=? AND password=?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs.next()?true:false;
	}

	
}
 