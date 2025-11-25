package com.day5.RelationsFP;

public class Room {

	private String name;
	private double areaSqm;
	
	Room(String name, double areaSqm) {// should not allow direct public constrctor..
		this.name = name;
		this.areaSqm = areaSqm;
	}
	
	//should  not initiate a room object direcly because it is completly dependent on house
	
	public String getName() {
		return name;
	}
	
	public double getAreaSqm() {
		return areaSqm;
	}
	
}
