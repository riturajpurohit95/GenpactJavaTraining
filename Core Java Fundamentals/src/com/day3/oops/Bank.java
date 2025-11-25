package com.day3.oops;

public class Bank {
	
	//protected -> directly accesible in the inherited class
	protected String bankName = "National Bank";
	
	public void displayBankName() {
		System.out.println("Bank Name : "+ bankName);
	}

}
