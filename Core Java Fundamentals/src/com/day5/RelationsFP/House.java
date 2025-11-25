package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.List;

public class House {
	
	private String address;
	
	public List<Room> rooms = new ArrayList<>();
	
	public House(String address){
		this.address = address;
	}
	
	//house composes rooms, rooms are created inside house
	//create rooms in house not in main class
	
	public void addRooms(String roomName, double areaSqm) {
		Room r = new Room(roomName, areaSqm);//room is created and owned by house - composition
		rooms.add(r);
	}
	
	//printRooms
	public void printRooms() {
		System.out.println(address + " has rooms : ");
		if(rooms.isEmpty()) {
			System.out.println("None");
			return ;
		}
		for(Room r : rooms) {
			System.out.println(r.getName());
		}
	}
	
	public String getAddress() {
		return address;
	}
	
//	public void printRoomDetails() {
//		for(Room r : rooms) {
//		System.out.println(r.getName()+ " " + r.getAreaSqm());
//		}
//	}

}
