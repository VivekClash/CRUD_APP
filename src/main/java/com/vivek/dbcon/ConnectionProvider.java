package com.vivek.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DBConstants.DRIVER);
			connection = DriverManager.getConnection(DBConstants.URL,DBConstants.USERID,DBConstants.PASSWORD);
			
			System.out.println(connection.getCatalog());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
