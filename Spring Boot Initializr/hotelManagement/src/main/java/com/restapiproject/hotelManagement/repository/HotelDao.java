package com.restapiproject.hotelManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.restapiproject.hotelManagement.model.Hotel;


public interface HotelDao{
	
	Hotel save(Hotel hotel);
	Optional<Hotel> finById(Long id);
	List<Hotel> finByName(String name);
	List<Hotel> findAll();
	int update(Hotel hotel);
	int deleteById(Long id);

}
