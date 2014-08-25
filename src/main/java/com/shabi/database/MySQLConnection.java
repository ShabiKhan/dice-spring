package com.shabi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static Connection getConnection(){
		String dbUrl = "jdbc:mysql://FIROZ_XPS16:3307/training_db";
		String dbUsername = "root";
		String dbPassword = "firoz@123";
		Connection conn = null;
		//Registring the driver 
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// obtaining the connection 
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	
	}

}
