package com.BookCab.model;

public class Drivers {
	
	public Drivers(int driver_id, String name, String vehicle_no, String vehicle_type, boolean availability) {
		this.driver_id = driver_id;
		this.name = name;
		this.vehicle_no = vehicle_no;
		this.vehicle_type = vehicle_type;
		this.availability = availability;
	}
	
	public Drivers() {}
	
	
	private int driver_id;
	private String name;
	private String vehicle_no;
	private String vehicle_type;
	private boolean availability=true;
	
	
	public int getDriver_id() {
		return driver_id;
	}
	public String getName() {
		return name;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public void setVehicle_type(String vehicle_no) {
		this.vehicle_no = vehicle_type;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	

}
