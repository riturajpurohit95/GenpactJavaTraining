package com.day3.oops;

public class PaytmPayment implements Payment,Refundable{
	
	@Override
	public void makePayment(double amount) {
		System.out.println("Paid INR "+ amount + " using Credit Card");
	}
	
	@Override
	public void refund(double amount) {
		System.out.println("Refunded INR "+ amount + " to Paytm");
	}
	
	@Override
	public void display() {
		System.out.println("Using Paytm as payment method");
	}

}
