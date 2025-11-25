package com.day5.RelationsFP;

public class CompositionApp {

	public static void main(String[] args) {
		
//		House h1 = new House("House1");
//		House h2 = new House("House2");
//		
//		h1.addRooms("01",10.00);
//		h1.addRooms("02",11.00);
//		h1.addRooms("03",12.00);
//		h1.addRooms("04",13.00);
//		
//		
//		h1.printRooms();
//		h2.printRooms();
//		
//		System.out.println("Address of house1 : "+h1.getAddress());
//		
//	
//		h1.getAddress();
		
////		Room r1 = new Room("12",23);
////		System.out.println(r1.getAreaSqm());
		
		
		Car c1 = new Car("Car");
		Car c2 = new Car("Truck");
		
		c1.addTyres(4, 60);
		c2.addTyres(6, 90);
		
		c1.printTyres();
		c2.printTyres();
		
		System.out.println(c1.getModel());
		

	}

}
