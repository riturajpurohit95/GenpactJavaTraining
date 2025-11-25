package com.BookCab.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.BookCab.DBUtil;

public class SQLDao {
	
	public void createTableUsers() {
		String sql_create_users = "create table if not exists users (\n"+
							" user_id int auto_increment primary key, \n"+
							" name varchar(100) not null, \n"+
							"email varchar(150) not null unique, \n"+
							"password varchar(200) not null, \n"+
							"phone varchar(20)"+
							")";
		
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
						)
		{
			stat.execute(sql_create_users);
			System.out.println("create statement executed successfully.");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createTableDrivers() {
		String sql_create_drivers = "create table if not exists drivers (\n"+
							" driver_id int auto_increment primary key, \n"+
							" name varchar(100) not null, \n"+
							"vehicle_no varchar(50) not null, \n"+
							"vehicle_type varchar(50) not null, \n"+
							"availability boolean default true"+
							")";
		
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
						)
		{
			stat.execute(sql_create_drivers);
			System.out.println("create statement executed successfully.");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void createTableBooking() {
		String sql_create_booking = "create table if not exists bookings (\n"+
							" booking_id int auto_increment primary key, \n"+
							" user_id int not null, \n"+
							"driver_id int not null, \n"+
							"route_id int not null, \n"+
							"source varchar(200) not null,"+
							"destination varchar(200) not null,"+
							"fare double not null, \n"+
							"booking_time datetime default current_timestamp, \n"+
							"status varchar(20) default 'Booked', \n"+
							"foreign key (user_id) references users(user_id), \n"+
							"foreign key (driver_id) references drivers(driver_id), \n"+
							"foreign key (route_id) references routes(route_id)"+
							")";

		
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
						)
		{
			stat.execute(sql_create_booking);
			System.out.println("create statement executed successfully.");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void createTableRoutes() {
		String sql_create_routes = "create table if not exists routes ( \n"+
									"route_id int auto_increment primary key, \n"+
									"source varchar(50) not null, \n"+
									"destination varchar(50) not null, \n"+
									"distance_km int not null,"+
									"unique(source, destination) "+
									")";
									
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
				)
		{
			stat.execute(sql_create_routes);
			System.out.println("create statement executed successfully.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
