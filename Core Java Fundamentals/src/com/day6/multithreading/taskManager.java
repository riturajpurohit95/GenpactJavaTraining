package com.day6.multithreading;

//TaskDownloader
//- get extended from Thread
//- taskName as private variable
//- constructor will be needed
//- override run method
//- starting task
//- i*33 (for 3 times)
//- 33% task completed
//- 66% task completed
//- 99% task completed

class taskDownloader extends Thread{
	private String taskName;
	
	public taskDownloader(String taskName) {
		this.taskName = taskName;
	}
	
	@Override
	public void run() {
		System.out.println("Starting download : "+ taskName + " Thread: "+ Thread.currentThread().getName());
		
		for(int i=1; i<=3; i++) {
			System.out.println("Downloading "+taskName+" : "+(i*33)+"% completed.");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(taskName+ "download interrupted.");
			}
		}
		System.out.println("completed downloading :"+taskName+" Thread : "+Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
	}
}

public class taskManager {

	public static void main(String[] args) {
		// create 3 threads for 3 tasks - start them
		
		taskDownloader t1 = new taskDownloader("task1");
		taskDownloader t2 = new taskDownloader("task2");
		taskDownloader t3 = new taskDownloader("task3");
		
		//get state
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());
		
		t1.start();
		t2.start();
		t3.start();
		
		//get state
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());
		
		//main thread
		System.out.println("main thread has finished scheduling.");

	}

}
