package com.restapiproject.hotelManagement.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.restapiproject.hotelManagement.model.Hotel;
import com.restapiproject.hotelManagement.util.HoletRowMapper;


@Repository
public class HotelDaoImplement implements HotelDao{

	private final JdbcTemplate jdbcTemplate;
	
	public HotelDaoImplement(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Hotel save(Hotel hotel) {
		String sql = "insert into hotels(name, address, total_rooms, available_rooms, price_per_night)"
				+ "values(?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
				
		jdbcTemplate.update(connection ->{
			PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, hotel.getName());
				ps.setString(2, hotel.getAddress());
				ps.setInt(3, hotel.getTotalRooms());
				ps.setInt(4, hotel.getAvailableRooms());
				ps.setBigDecimal(5, hotel.getPricePerNight());
				
				return ps;
			}, keyHolder);
		
		Number key = keyHolder.getKey();
		if(key!=null) {
			hotel.setId(key.longValue());
		}
		return hotel;
	}

	@Override
	public Optional<Hotel> finById(Long id) {
		String sql = "select * from hotels where id=?";
		
		List<Hotel> result = jdbcTemplate.query(sql, new HoletRowMapper(), id);
		if(result.isEmpty()) return Optional.empty();
		
		return Optional.of(result.get(0));
	}
	
	@Override
	public List<Hotel> finByName(String name) {
		String sql = "select * from hotels where LOWER(name) like ?";
		
		String pattern = "%"+name.toLowerCase()+"%";
		
		List<Hotel> result = jdbcTemplate.query(sql, new HoletRowMapper(), pattern);
		if(result.isEmpty()) {
			String sql2 = "select * from hotels";
			return jdbcTemplate.query(sql2, new HoletRowMapper());
		}
		
		return result;
	}

	@Override
	public List<Hotel> findAll() {
		String sql = "select * from hotels";
		
		return jdbcTemplate.query(sql, new HoletRowMapper());
		
	}

	@Override
	public int update(Hotel hotel) {
		String sql = "update hotels set name=?,address=?,total_rooms=?,available_rooms=?,price_per_night=? where id=?";
		
		return jdbcTemplate.update(sql,
				hotel.getName(),
				hotel.getAddress(),
				hotel.getTotalRooms(),
				hotel.getAvailableRooms(),
				hotel.getPricePerNight(),
				hotel.getId()
				);
	}

	@Override
	public int deleteById(Long id) {
		String sql = "delete from hotels where id=?";
		return  jdbcTemplate.update(sql,id);
	}
	
	

}
