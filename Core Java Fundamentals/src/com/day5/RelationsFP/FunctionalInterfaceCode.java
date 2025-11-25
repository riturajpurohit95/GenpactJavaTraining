package com.day5.RelationsFP;

@FunctionalInterface
public interface FunctionalInterfaceCode {

	double applyDiscount(double price);
	//only single abstract method
	//some helper methods are permitted - default and static methods
	
	
	//instance methods - which we have to call with object
	default void printREceipt() {
		System.out.println("Receipt printed successfully");
	}
	
	//at the application level - no need of object. - utility methods - belong to interface only. - no need to instance
	static void showCurrency() {
		System.out.println("Currency : INR");
	}
	
	//lambda expr can only be used for abstract methods only - to give implementations of abstract methods.
	
	
}
