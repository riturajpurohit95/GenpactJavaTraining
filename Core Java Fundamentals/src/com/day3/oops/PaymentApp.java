package com.day3.oops;

public class PaymentApp {
	
	public static void main(String[] args) {
		
		//we can have parent refrence , refring to child class
		Payment payment1 = new CreditCardPayment();
		Payment payment2 = new UPIPyament();
		Payment payment3 = new PaytmPayment();
		
		
		payment1.makePayment(2000.00);
		payment1.display();
		CreditCardPayment paymentCD1 = new CreditCardPayment();
		paymentCD1.refund(1000);
		
		payment2.makePayment(2000.00);
		payment2.display();
		UPIPyament paymentUPI1 = new UPIPyament();
		paymentUPI1.refund(1000);
		
		payment3.makePayment(2000.00);
		payment3.display();
		PaytmPayment paymentPTM1 = new PaytmPayment();
		paymentPTM1.refund(1000);
	}

}
