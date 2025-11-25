package com.day3.oops;

public class CreditCardPayment implements Payment, Refundable{
	
	//we must override and implement the abstract methods of interface
	@Override
	public void makePayment(double amount) {
		System.out.println("Paid INR "+ amount + " using Credit Card");
	}
	
	@Override
	public void refund(double amount) {
		System.out.println("Refunded INR "+ amount + " to Credit Card");
	}
	
	//one single implementation of display and no ambiguity (multiple inheritance)
	@Override
	public void display() {
		System.out.println("Using Credit Card as payment method");
	}

}
