package com.day6.multithreading;

//class ticketCounter - availableSeats
//1. sync for entire method
//2. static sync
//3. use sync block instead method - only for critical section - shared updation happens

class ticketCounter3{
	private int availableSeats = 1; //shared resource 
	
	synchronized void bookTicket(String userName) {
		//statements
		System.out.println("Welcome to ticket booking app.");
		System.out.println(userName+ " is booking the seat...");
		
		//critical section  -- only section is needed to be blocked instead of blocking entire method
		synchronized(this) {   //sync only critical section
		if(availableSeats >0) {
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
		
		//statements
		System.out.println("Exiting the booking App.");
	}
}

public class ticketCounterApp2 {

	public static void main(String[] args) {
		
		ticketCounter3 counter = new ticketCounter3();

		Thread t1 = new Thread(() -> counter.bookTicket("A"));
		Thread t2 = new Thread(() -> counter.bookTicket("B"));
		Thread t3 = new Thread(() -> counter.bookTicket("C"));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
