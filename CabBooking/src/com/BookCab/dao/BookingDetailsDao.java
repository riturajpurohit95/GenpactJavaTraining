package com.BookCab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BookCab.DBUtil;
import com.BookCab.model.BookingDetails;

public class BookingDetailsDao {
	
		public List<BookingDetails> checkBookingsByUserId(int userId, String statusFilter){
			List<BookingDetails> bookings = new ArrayList<>();
			
			String sql = """ 
					select b.booking_id, u.name, d.name, r.source, r.destination,
					r.distance_km, b.fare, b.status, b.booking_time
					from bookings b
					join users u on b.user_id = u.user_id
					join drivers d on b.driver_id = d.driver_id
					join routes r on b.route_id = r.route_id
					where b.user_id = ?;
					""";
			
			
			if(statusFilter != null && !statusFilter.isEmpty()) {
				sql +=" and b.status=?";
			}
			
			try(Connection conn = DBUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1, userId);
				
				if(statusFilter != null && !statusFilter.isEmpty()) {
					ps.setString(2, statusFilter);
				}
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					BookingDetails b = new BookingDetails(
							rs.getInt("booking_id"),
							rs.getString("name"),
							rs.getString("name"),
							rs.getString("source"),
							rs.getString("destination"),
							rs.getDouble("distance_km"),
							rs.getDouble("fare"),
							rs.getString("status"),
							rs.getString("booking_time")
							);
					bookings.add(b);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
			
			return bookings;
		}

}
