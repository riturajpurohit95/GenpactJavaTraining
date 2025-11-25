package com.jdbcproject;

// create the connection of java with mysql
import java.sql.Connection; //represent a session with the database - ems_db  , connection - predefined interface
import java.sql.DriverManager; // manages JDBC drivers and connections
import java.sql.SQLException; //handle database related errors

public class DBUtil {
	
	//JDBC - URL(url for ems_db), username - root, password - 
	
	//static - class level
	//final - should not be modifiable
	
	private static final String URL = "jdbc:mysql://localhost:3306/ems_db"; //tells where db is hosted
	private static final String USER = "root";
	private static final String PASSWORD = "Genpact@123456789";
	
	//load MySQL JDBC Driver
	//create connection only once
	//when class id loaded first
	//static - load mysql jdbc into memory
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //tell Java to look for driver class in .jar file - added
			System.out.println("MySQL Driver loaded successfully");
		}catch(ClassNotFoundException e) {
			System.out.println("Unable to load MySQL Driver "+ e.getMessage());
		}
	}
	
	//Establish Connection
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connection established");
		}catch (SQLException e) {
			System.out.println("Connection failed "+e.getMessage());
		}
		return connection;
	}
	
	//Close Connection
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
				System.out.println("Database Connection closed.");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
