package com.day6.multithreading;

//create thread by extending from thread Class
//Thread - inbuilt class

class myThread extends Thread{ //subclass from thread
	//need to override its run method
	public void run() {
		//code to run in a new thread
		
	}
}

public class threadClass {

	public static void main(String[] args) {
		
		myThread t1 = new myThread(); //thread belonging to myThread class
		t1.start(); //launch the thread -> call run() -> execute thread in the current state
		
		

	}

}
