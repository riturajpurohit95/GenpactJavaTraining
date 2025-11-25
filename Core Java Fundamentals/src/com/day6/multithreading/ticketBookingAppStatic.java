package com.day6.multithreading;

//static synchronization
//- when static method is synchronized
//- variable as static - does not belong to object, belongs to class
//- method also static - belongs to class not object
//- lock is acquired on the class object ticketCounter class, not on the instance
//- 

class ticketCounter2{
private static int availableSeats = 1; 
	
	synchronized static void bookTicket(String userName) {
		if(availableSeats >0) {
			System.out.println(userName+ " is booking the seat....");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			availableSeats--;
			System.out.println(userName+ " successfully booked the seat");
		}
		else {
			System.out.println("Sorry "+userName+" , seat already booked ");
		}
	}
}

public class ticketBookingAppStatic {

	public static void main(String[] args) {
		
		ticketCounter2 counter = new ticketCounter2();
		ticketCounter2 counter2 = new ticketCounter2();

		Thread t1 = new Thread(() -> counter.bookTicket("A"));
		//Thread t2 = new Thread(() -> counter.bookTicket("B"));
		//Thread t3 = new Thread(() -> counter.bookTicket("C"));
		
		t1.start();
		//t2.start();
		//t3.start();
		
		//till now lock is there at object level
		//second object counter2
		//create 2 threads for this
		Thread t4 = new Thread(() -> counter2.bookTicket("D"));
		//Thread t5 = new Thread(() -> counter2.bookTicket("E"));
		
		t4.start();
		//t5.start();
		//again problem -> 1 seat is getting booked by two .. counter and counter2.  --> static keyword willl be added to solve this
		
		//counter and counter2 are differenct objects
		//but method is static
		//lock will be acquired at class level
		//one object is accessing sync method then other cannot
		//both objects are belonging to same class
	}

}