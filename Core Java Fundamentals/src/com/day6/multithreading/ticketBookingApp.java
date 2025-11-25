package com.day6.multithreading;

//without synchronization
//class ticketCounter - avialableSeates

class ticketCounter{
	private int availableSeats = 1; //shared resource 
	
//	void bookTicket(String userName) {   ---> this will cause problem -> a,b,c will all book that 1 seat
	synchronized void bookTicket(String userName) {
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

public class ticketBookingApp {

	public static void main(String[] args) {
		
		ticketCounter counter = new ticketCounter();

		//create 2 threads for this
		Thread t1 = new Thread(() -> counter.bookTicket("A"));
		Thread t2 = new Thread(() -> counter.bookTicket("B"));
		Thread t3 = new Thread(() -> counter.bookTicket("C"));
		
		t1.start();
		t2.start();
		t3.start();
	}

}

//both threads checked availableSeats > 0  at ssame time and proceeded
//add 
//make the method - where shared resources is used - as synchronized method
//- lock the thread before executing and releases that after finishing 
//- t1 - bookTicket, t2 will not
//- t1 is in sync method, no other method can execute that method 

