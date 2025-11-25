package com.day6.multithreading;

//scenario - simulate multiple file downloads concurrently
// - like browser multiple files download
// - Runnable interface

class fileDownloader implements Runnable{
	private String fileName;
	
	public fileDownloader(String fileName) {
		this.fileName = fileName;
		
	}
	
	@Override
	public void run() {
		System.out.println("Starting download : "+ fileName + " Thread: "+ Thread.currentThread().getName());
		
		//simulate download
		for(int i=1; i<=5; i++) {
			System.out.println("Downloading "+fileName+" : "+(i*20)+"% completed.");
			try {
				Thread.sleep(1000);// introducing delay
			}catch(InterruptedException e) {
				System.out.println(fileName+ "download interrupted.");
			}
		}
		System.out.println("completed downloading :"+fileName+" Thread : "+Thread.currentThread().getName());
	}
}

public class downloadManager {

	public static void main(String[] args) {
		// multiple threads - download multiple files
		Runnable file1 = new fileDownloader("Document1.pdf");
		Runnable file2 = new fileDownloader("Music.mp3");
		Runnable file3 = new fileDownloader("Movie.mp4");
		
		//assign each task to its own thread
		Thread t1 = new Thread(file1, "Downloader-1");
		Thread t2 = new Thread(file2, "Downloader-2");
		Thread t3 = new Thread(file3, "Downloader-3");
		
		//start all threads - call run() method
		t1.start();
		t2.start();
		t3.start();
		
		//main thread
		System.out.println("main thread has finished scheduling.");

	}

}
