package com.day5.RelationsFP;

public class FunctionalInterfaceMain {

	public static void main(String[] args) {
		
		double originalPrice = 10000.00;
		
		//lamda expression
		FunctionalInterfaceCode regularCustomer = price -> price * 0.9;
		FunctionalInterfaceCode premiumCustomer = price -> price * 0.8;
		FunctionalInterfaceCode festivalOffer = price -> price * 0.7;
		
		System.out.println("Regular customer bill : "+ regularCustomer.applyDiscount(originalPrice));
		System.out.println("Premium customer bill : "+ premiumCustomer.applyDiscount(originalPrice));
		System.out.println("Festival Offer bill   : "+ festivalOffer.applyDiscount(originalPrice));
		
		
		//called default method
		regularCustomer.printREceipt();
		
		//call static method - by classname and interface name only
		FunctionalInterfaceCode.showCurrency();
		

	}

}
