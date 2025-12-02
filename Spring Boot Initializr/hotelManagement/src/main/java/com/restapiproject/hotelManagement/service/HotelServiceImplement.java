package com.restapiproject.hotelManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapiproject.hotelManagement.exception.ResourceNotFoundException;
import com.restapiproject.hotelManagement.model.Hotel;
import com.restapiproject.hotelManagement.repository.HotelDao;

@Service
public class HotelServiceImplement implements HotelService{
	
	private final HotelDao hotelDao;
	
	public HotelServiceImplement(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelDao.save(hotel);
	}

	@Override
	public Hotel getHotelById(Long id) {
		return hotelDao.finById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id:"+id));
	}
	
	@Override
	public List<Hotel> getHotelByName(String name) {
		return hotelDao.finByName(name);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelDao.findAll();
	}

	@Override
	public Hotel updateHotel(Long id, Hotel hotel) {
		Hotel existing = getHotelById(id);
		existing.setName(hotel.getName());
		existing.setAddress(hotel.getAddress());
		existing.setTotalRooms(hotel.getTotalRooms());
		existing.setAvailableRooms(hotel.getAvailableRooms());
		existing.setPricePerNight(hotel.getPricePerNight());
		int rows = hotelDao.update(existing);
		if (rows<=0) throw new RuntimeException("Update failed for hotel id : "+id);
		return existing;
	}

	@Override
	public void deleteHotel(Long id) {		
		// ensure exists
		getHotelById(id);
		int rows = hotelDao.deleteById(id);
		if (rows<=0) throw new RuntimeException("Delete failed for hotel id : "+id);

}}
