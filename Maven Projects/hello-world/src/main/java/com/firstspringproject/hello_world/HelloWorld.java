package com.firstspringproject.hello_world;


//POJO Class
//Plain Java Class


public class HelloWorld {
	
	private String message;
	private Address address;
	
	public HelloWorld() {
		
	}
	
	//constructor for dependency injection
	public HelloWorld(String msg, Address address) {
		this.message =  msg;
		this.address = address;
	}
	
	public void setMessage(String msg) {
		this.message =  msg;
	}
	
	public void displayMessage() {		
		
		System.out.println("Your message is :  " + message);
		System.out.println("Address is : " + address);		
		
	}

}
