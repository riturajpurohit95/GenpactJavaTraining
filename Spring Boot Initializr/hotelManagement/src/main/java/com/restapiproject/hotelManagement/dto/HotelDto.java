package com.restapiproject.hotelManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public class HotelDto {
	
	public HotelDto() {
	}

	public HotelDto(Long id, @NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Address is required") String address,
			@NotNull(message = "Enter number of Total rooms") @Min(value = 1, message = "Total rooms must be >= 1") Integer totalRooms,
			@NotNull(message = "Enter number of Available rooms") @Min(value = 0, message = "Available rooms must be >= 0") Integer availableRooms,
			@NotNull(message = "Price is required") @DecimalMin(value = "0.0", message = "Price must be >= 0") BigDecimal pricePerNight) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.totalRooms = totalRooms;
		this.availableRooms = availableRooms;
		this.pricePerNight = pricePerNight;
	}

	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotNull(message = "Enter number of Total rooms")
	@Min(value=1, message="Total rooms must be >= 1")
	private Integer totalRooms;
	
	@NotNull(message = "Enter number of Available rooms")
	@Min(value=0, message="Available rooms must be >= 0")
	private Integer availableRooms;
	
	@NotNull(message = "Price is required")
	@DecimalMin(value="0.0", message="Price must be >= 0")
	private BigDecimal pricePerNight;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public Integer getAvailableRooms() {
		return availableRooms;
	}

	public BigDecimal getPricePerNight() {
		return pricePerNight;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}

	public void setAvailableRooms(Integer availableRooms) {
		this.availableRooms = availableRooms;
	}

	public void setPricePerNight(BigDecimal pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	

}
