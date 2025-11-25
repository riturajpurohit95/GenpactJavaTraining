package com.BookCab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BookCab.DBUtil;
import com.BookCab.model.Users;

public class UsersDao {
	
	public int createUser(Users user) {
		String sql = "insert into users(name, email, password, phone) values (?, ?, ?, ?)";
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){ 
		
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getPhone());
				
				int rows = ps.executeUpdate(); 
				
				if (rows > 0) {
					System.out.println("Inserted successfully");
				}else {
					System.out.println("Insertion failed");
				}
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public Users findByEmail(String email) {
		String sql = "select * from users where email= ?";
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, email);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					Users user = new Users();
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setPhone(rs.getString("phone"));
					return user;
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public Users findById(int id) {
		String sql = "select * from users where user_id= ?";
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					Users user = new Users();
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setEmail("email");
					user.setPassword("password");
					user.setPhone("phone");
					return user;
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
