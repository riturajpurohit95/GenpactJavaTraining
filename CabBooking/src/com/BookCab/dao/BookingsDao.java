package com.BookCab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.BookCab.DBUtil;
import com.BookCab.model.BookingDetails;
import com.BookCab.model.Bookings;

public class BookingsDao {
	
	public int createBooking(Bookings bookings) {
		String sql = "insert into bookings(user_id, driver_id, route_id, source, destination, fare, booking_time, status) values (?, ?, ?, ?, ?, ?, NOW(), ?)";
		
		RoutesDao routes_dao = new RoutesDao();
		int routeId = routes_dao.getRouteIdFromDB(bookings.getSource(),bookings.getDestination());
		
		if(routeId==-1) {
			return 0;
		}
		
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setInt(1, bookings.getUser_id());
			ps.setInt(2, bookings.getDriver_id());
			ps.setInt(3, bookings.getRoute_id());
			ps.setString(4, bookings.getSource());
			ps.setString(5, bookings.getDestination());
			ps.setDouble(6, bookings.getFare());
			ps.setString(7, bookings.getStatus());
			
			int rows = ps.executeUpdate();
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
	
	
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
		
		return 0;
	}
	
	
	public List<Bookings> getBookingsByUser(int userId){
		String sql = "select * from bookings where user_id = ? order by booking_time desc";
		List<Bookings> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, userId);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
				Bookings bookings = new Bookings();
				bookings.setBooking_id(rs.getInt("booking_id"));
				bookings.setUser_id(rs.getInt("user_id"));
				bookings.setDriver_id(rs.getInt("driver_id"));
				bookings.setSource(rs.getString("source"));
				bookings.setDestination(rs.getString("destination"));
				bookings.setFare(rs.getDouble("fare"));
				bookings.setStatus(rs.getString("status"));
				Timestamp ts = rs.getTimestamp("booking_time");
				if(ts != null) bookings.setBookingTime(ts.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				list.add(bookings);
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	public void updateBookingStatus(int bookingId, String status) {
		String sql = "update bookings set status = ? where booking_id = ?";
		
		try(Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, status);
			ps.setInt(2, bookingId);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public String getBookingStatus(int bookingId, int userId) {
		String sql = "select status from bookings where booking_id = ? and user_id = ?";
		
		try(Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, bookingId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
