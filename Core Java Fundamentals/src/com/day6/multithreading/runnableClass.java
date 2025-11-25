package com.day6.multithreading;

//Runnable is inbuilt interface
// - only one abstract method - run()
// - you can implement runnable when your class already extends another class
// - pass the runnable object to a thread class constructor

class myTask implements Runnable{
	@Override
	public void run() {
		
	}
}

public class runnableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myTask task = new myTask();
		Thread t1  = new Thread(task);
		t1.start();

	}

}
