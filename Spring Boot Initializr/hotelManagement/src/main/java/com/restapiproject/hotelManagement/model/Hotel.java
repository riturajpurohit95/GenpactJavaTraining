package com.restapiproject.hotelManagement.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Hotel {
	
	public Hotel() {
	}
	
	public Hotel(Long id, String name, String address, int totalRooms, int availableRooms, BigDecimal pricePerNight,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.totalRooms = totalRooms;
		this.availableRooms = availableRooms;
		this.pricePerNight = pricePerNight;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Hotel(Long id, String name, String address, int totalRooms, int availableRooms, BigDecimal pricePerNight) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.totalRooms = totalRooms;
		this.availableRooms = availableRooms;
		this.pricePerNight = pricePerNight;
	}
	
	private Long id;
	private String name;
	private String address;
	private int totalRooms;
	private int availableRooms;
	private BigDecimal pricePerNight;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public BigDecimal getPricePerNight() {
		return pricePerNight;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
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
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	public void setPricePerNight(BigDecimal pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", totalRooms=" + totalRooms
				+ ", availableRooms=" + availableRooms + ", pricePerNight=" + pricePerNight + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
