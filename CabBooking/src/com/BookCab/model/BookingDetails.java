package com.BookCab.model;

public class BookingDetails {
	
	public BookingDetails(int booking_id, String user_name, String driver_name, String source, String destination,
			double distance_km, double fare, String status, String bookingTime) {
		super();
		this.booking_id = booking_id;
		this.user_name = user_name;
		this.driver_name = driver_name;
		this.source = source;
		this.destination = destination;
		this.distance_km = distance_km;
		this.fare = fare;
		this.status = status;
		this.bookingTime = bookingTime;
	}
	
	
	private int booking_id;
	private String user_name;
	private String driver_name;
	private String source;
	private String destination;
	private double distance_km;
	private double fare;
	private String status;
	private String bookingTime;
	
	
	public void display() {
		System.out.println("----------------------------------------------");
		System.out.println("BookingId: "+booking_id);
		System.out.println("User: "+user_name);
		System.out.println("Driver: "+driver_name);
		System.out.println("Route: "+source+" -> "+destination);
		System.out.println("Distance: "+distance_km+" km");
		System.out.println("Fare: Rs."+fare);
		System.out.println("Status: "+status);
		System.out.println("Booked on: "+bookingTime);
	}
	
	

}
