package com.BookCab.model;

import java.time.LocalDateTime;

public class Bookings {
	
	public Bookings(int booking_id, int user_id, int driver_id, int route_id, String source, String destination, double fare,
			LocalDateTime booking_time, String status) {
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.driver_id = driver_id;
	this.route_id = route_id;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.booking_time = booking_time;
		this.status = status;
	}
	
	public Bookings() {}
	
	
	private int booking_id;
	private int user_id;
	private int driver_id;
	private int route_id;
	private String source;
	private String destination;
	private double fare;
	private LocalDateTime booking_time;
	private String status;
	
	
	public int getBooking_id() {
		return booking_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public int getRoute_id() {
		return route_id;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public double getFare() {
		return fare;
	}
	public LocalDateTime getBookingTime() {
		return booking_time;
	}
	public String getStatus() {
		return status;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public void setBookingTime(LocalDateTime booking_time) {
		this.booking_time = booking_time;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
