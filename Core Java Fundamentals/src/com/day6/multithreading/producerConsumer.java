package com.day6.multithreading;

class shop{
	int item;
	boolean available=false;
	
	synchronized void putItem(int i) {
		while(available) {
			try {
				wait();
			}catch(Exception e) {
				e.getMessage();
			}
			}
			item =i;
			available=true;
			System.out.println("Shopkeeper put: "+i);
			notify();
		}
		
	synchronized void getItem() {
			while(!available) {
				try {
					wait();
				}catch(Exception e) {
					e.getMessage();
				}
				}
			System.out.println("Customer bought : "+item);
				available=false;
				notify();
	}
}

class shopKeeper extends Thread{
	private shop s;
	shopKeeper(shop s){
		this.s =s;
	}
	
	public void run() {
		for ( int i=1;i<=5;i++) {
			s.putItem(i);
			try {
				Thread.sleep(1000);
			}catch (Exception e){
				e.getMessage();
			}
		}
	}
	
}

class customer extends Thread{
	private shop s;
	
	customer(shop s){
		this.s = s;
	}
	
	public void run() {
		for ( int i=1;i<=5;i++) {
			s.getItem();
			try {
				Thread.sleep(1000);
			}catch (Exception e){
				e.getMessage();
			}
		}
	}
}

public class producerConsumer {
	
	//producer - generates data and stores it in shared resource
	//consumer - reads and processes data
	//shared resource - must be synchronized -> producer doesn't add
	
	//example shop
	//producer cannot add item after - shop full
	//customer cannot take item - shop empty
	//shop  - shared resource
	public static void main(String args[]) {
	
	shop s = new shop();
	
	shopKeeper sk = new shopKeeper(s);
	customer c = new customer(s);
	
	sk.start();
	c.start();
	}
	

}
