package com.day3.oops;

// small implementation of payment gateway
//diff payment methods - creditCard, debit,  upi, paytm... can process payments


public interface Payment {
	
	// by default methods are abstract and public
	void makePayment(double amount);
	//concrete method
//	public void display() {
//		System.out.println("Testing concrete");
//	}
	
	void display();

}
