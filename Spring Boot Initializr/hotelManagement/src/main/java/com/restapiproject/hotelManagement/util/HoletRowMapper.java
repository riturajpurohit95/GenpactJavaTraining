package com.restapiproject.hotelManagement.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restapiproject.hotelManagement.model.Hotel;

public class HoletRowMapper implements RowMapper<Hotel>{
	
	@Override
	public Hotel mapRow(ResultSet rs, int rowNum)throws SQLException{
		Hotel h = new Hotel();
		h.setId(rs.getLong("id"));
		h.setName(rs.getString("name"));
		h.setAddress(rs.getString("address"));
		h.setTotalRooms(rs.getInt("total_rooms"));
		h.setAvailableRooms(rs.getInt("available_rooms"));
		h.setPricePerNight(rs.getBigDecimal("price_per_night"));
		java.sql.Timestamp created = rs.getTimestamp("created_at");
		if(created != null) h.setCreatedAt(created.toLocalDateTime());
		java.sql.Timestamp updated = rs.getTimestamp("updated_at");
		if(created != null) h.setUpdatedAt(created.toLocalDateTime());
		
		return h;
	}

}