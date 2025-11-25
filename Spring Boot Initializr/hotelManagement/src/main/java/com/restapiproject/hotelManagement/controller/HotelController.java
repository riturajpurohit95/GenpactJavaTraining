package com.restapiproject.hotelManagement.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapiproject.hotelManagement.dto.HotelDto;
import com.restapiproject.hotelManagement.model.Hotel;
import com.restapiproject.hotelManagement.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/hotels")
public class HotelController {
	
	private final HotelService hotelService;
	public HotelController(HotelService hotelService) {
		this.hotelService=hotelService;
	}
	
	//DtotoEntity
	private Hotel dtoToEntity(HotelDto dto) {
		Hotel h = new Hotel();
		h.setId(dto.getId());
		h.setName(dto.getName());
		h.setAddress(dto.getAddress());
		h.setTotalRooms(dto.getTotalRooms());
		h.setAvailableRooms(dto.getAvailableRooms());
		h.setPricePerNight(dto.getPricePerNight());
		return h;
	}
	
	//EntitytoDto
	private HotelDto entityToDto(Hotel h) {
		HotelDto dto = new HotelDto();
		dto.setId(h.getId());
		dto.setName(h.getName());
		dto.setAddress(h.getAddress());
		dto.setTotalRooms(h.getTotalRooms());
		dto.setAvailableRooms(h.getAvailableRooms());
		dto.setPricePerNight(h.getPricePerNight());
		return dto;
	}
	
	//Get request
	@GetMapping
	public ResponseEntity<List<HotelDto>> getAll() {
		List<Hotel> list = hotelService.getAllHotels();
		List<HotelDto> dtoList = list.stream().map(this::entityToDto).collect(Collectors.toList());
		//return http response - use response entity
		
		return ResponseEntity.ok(dtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelDto> getById(@PathVariable Long id) {
		//@PathVariable - tell spring to extract {id} 
		//-from url and assign it to the id variable
		// /api/hotels/4
		
		Hotel h = hotelService.getHotelById(id);
		return ResponseEntity.ok(entityToDto(h));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<HotelDto>> getByName(@RequestParam String name){
		List<Hotel> hotels = hotelService.getHotelByName(name);
		List<HotelDto> dtoList = hotels.stream().map(this::entityToDto).collect(Collectors.toList());
		
		return ResponseEntity.ok(dtoList);
	}
	
//	@GetMapping("/search")
//	public ResponseEntity<List<HotelDto>> searchByName(@RequestParam(value="name",required=false)String name) { 
//		// @PathVariable - tell spring to extract {id}
//		// - from URL and assign it to the id variable
//		// /api/hotels/4		
//		List<Hotel> hotels = hotelService.getHotelByName(name);
//		List<HotelDto> dtoList = hotels.stream().map(this::entityToDto)
//                .collect(Collectors.toList());
//
//		return ResponseEntity.ok(dtoList);		
//	}
	
	@PostMapping
	public ResponseEntity<HotelDto> create(@Valid @RequestBody HotelDto dto) {
		Hotel h = dtoToEntity(dto);
		Hotel created = hotelService.createHotel(h);
		return ResponseEntity.created(URI.create("/api/hotels/"+created.getId()))
								.body(entityToDto(created));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<HotelDto> update(@PathVariable Long id, @Valid @RequestBody HotelDto dto){
		
		Hotel h = dtoToEntity(dto);
		Hotel updated = hotelService.updateHotel(id, h);
		return ResponseEntity.ok(entityToDto(updated));
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		hotelService.deleteHotel(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
