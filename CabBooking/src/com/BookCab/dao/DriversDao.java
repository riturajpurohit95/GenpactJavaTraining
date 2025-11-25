package com.BookCab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.BookCab.DBUtil;
import com.BookCab.model.Drivers;

public class DriversDao {
	
	public List<Drivers> getAvailableDrivers(){
		String sql = "select * from drivers where availability = true";
		List<Drivers> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Drivers drivers = new Drivers(
						rs.getInt("driver_id"), 
						rs.getString("name"),
						rs.getString("vehicle_no"),
						rs.getString("vehicle_type"),
						rs.getBoolean("availability")
						);
				list.add(drivers);
			}
			return list;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return  null;
	}
	
	
	public Drivers getDriverByType(String type){
		String sql = "select * from drivers where LOWER(vehicle_type) = LOWER(?) and availability = true  LIMIT 1";
		
		
		try(Connection conn = DBUtil.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Drivers(
						rs.getInt("driver_id"), 
						rs.getString("name"),
						rs.getString("vehicle_no"),
						rs.getString("vehicle_type"),
						rs.getBoolean("availability")
						);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return  null;
	}
	
	
	
	public Drivers findById(int id) throws SQLException{
		String sql="select * from drivers where driver_id=?";
		
		try(Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql) ){
			
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					return new Drivers(
							rs.getInt("driver_id"), 
							rs.getString("name"),
							rs.getString("vehicle_no"),
							rs.getString("vehicle_type"),
							rs.getBoolean("availability")
							);
				}
			}
		}
		return null;
	}
	
	
	public void setAvailability(int driverId, boolean available) {
		String sql = "update drivers set availability = ? where driver_id = ?";
		
		try(Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setBoolean(1, available);
			ps.setInt(2, driverId);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public List<String> getAvailableVehicleTypes() throws SQLException{
		List<String> types = new ArrayList<>();
		String sql = "select distinct vehicle_type from drivers where availability=true";
		try(Connection conn = DBUtil.getConnection(); 
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				types.add(rs.getString("vehicle_type"));
			}
		}
		return types;
	}
	
	
	//for admin
	public int  addDriver(Drivers drivers) {
		int id=0;
		String sql = "insert into drivers (name, vehicle_no, vehicle_type, availability) values (?, ?, ?, ?)";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps  = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1,drivers.getName());
			ps.setString(2,drivers.getVehicle_no());
			ps.setString(3,drivers.getVehicle_type());
			ps.setBoolean(4,drivers.isAvailability());
			
			int rows = ps.executeUpdate(); 
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return id;
	}
	

}
