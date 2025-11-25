package com.BookCab.model;

public class Routes {
	
	public Routes(int route_id, String source, String destination, String distance_km) {
		super();
		this.route_id = route_id;
		this.source = source;
		this.destination = destination;
		this.distance_km = distance_km;
	}
	
	public Routes() {}
	
	private int route_id;
	private String source;
	private String destination;
	private String distance_km;
	
	
	public int getRoute_id() {
		return route_id;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public String getDistance_km() {
		return distance_km;
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
	public void setDistance_km(String distance_km) {
		this.distance_km = distance_km;
	}

}
