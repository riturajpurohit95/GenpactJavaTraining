package com.BookCab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BookCab.DBUtil;
import com.BookCab.model.Routes;



public class RoutesDao {
	
	public void createRoute(Routes routes) {
		String sql = "insert into routes(route_id, source, destination, distance_km) values ( ?, ?, ?, ?)";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, routes.getRoute_id());
			ps.setString(2, routes.getSource());
			ps.setString(3, routes.getDestination());
			ps.setString(4, routes.getDistance_km());
			
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("Insertion failed");
			}
	
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	}
	
	
	public void showAllRoutes() {
		String sql  = "select route_id, source, destination, distance_km from routes";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
			System.out.println("----------------------------------------------------------------------");
			System.out.printf("%-10s %-20s %-20s %-10s%n", "routeId", "from", "to", "distance (km)");
			System.out.println("----------------------------------------------------------------------");
			
			boolean hasData = false;
			while(rs.next()) {
				hasData=true;
				int id=rs.getInt("route_id");
				String source=rs.getString("source");
				String destination=rs.getString("destination");
				double distance=rs.getDouble("distance_km");
				
				
				System.out.println(String.format("%- 10d %-20s %-20s %-10.2f",id,source,destination,distance));
				
			}
			if(!hasData) {
				System.out.println("No routes found.");
			}
			
			System.out.println("-------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public double getDistanceFromDB(String source, String destination) {
		double distance =0;
		String sql = "select distance_km from routes where source=? and destination =?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				distance = rs.getDouble("distance_km");
			}else {
				System.out.print("Sorry! route does not exist.");
//				System.out.println("Route not found, using default distance 10 km.");
//				distance = 10;
				return -1;
			}
			
		}catch (SQLException e){
			System.out.println("Error fetching route distance: "+ e.getMessage());
		}
		return distance;
	}
	
	public int getRouteIdFromDB(String source, String destination) {
		int routeId=0;
		String sql = "select route_id from routes where source=? and destination =?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				routeId = rs.getInt("route_id");
			}else {
				return -1;
			}
			
		}catch (SQLException e){
			System.out.println("Error fetching route distance: "+ e.getMessage());
		}
		return routeId;
	}
	
	
	
	
	

}
