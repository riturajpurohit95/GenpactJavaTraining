package com.day3.oops;

public class UPIPyament implements Payment, Refundable{
	
	@Override
	public void makePayment(double amount) {
		System.out.println("Paid INR "+ amount + " using UPI");
	}
	
	@Override
	public void refund(double amount) {
		System.out.println("Refunded INR "+ amount + " to UPI");
	}
	
	@Override
	public void display() {
		System.out.println("Using UPI as payment method");
	}

}