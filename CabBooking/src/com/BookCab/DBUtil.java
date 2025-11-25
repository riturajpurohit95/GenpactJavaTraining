package com.BookCab;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/cabbookingdb"; 
	private static final String USER = "root";
	private static final String PASSWORD = "Genpact@123456789";
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			System.out.println("MySQL Driver loaded successfully");
		}catch(ClassNotFoundException e) {
			System.out.println("Unable to load MySQL Driver "+ e.getMessage());
		}
	}
	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
//			System.out.println("Connection established");
		}catch (SQLException e) {
			System.out.println("Connection failed "+e.getMessage());
		}
		return connection;
	}
	
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
//				System.out.println("Database Connection closed.");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

