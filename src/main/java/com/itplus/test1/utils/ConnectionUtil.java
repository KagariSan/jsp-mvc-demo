package com.itplus.test1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	// Connection Pool
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// Old version
		Class.forName("com.mysql.jdbc.Driver");
		
		// Connection URL - Connection String
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?user=root&password=toor");
		return connection;
	}
}
