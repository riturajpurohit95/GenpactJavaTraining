package com.day3.oops;

//Derived class Level 1
//SavingType from Account inherited from Bank
public class SavingType extends Account{
	
	private double interestRate;
	
	public SavingType(String accountHolder, double balance, double interestRate) {
		super(accountHolder, balance);
		this.interestRate = interestRate;
	}
	
	void displaySavingsInfo() {
		//SavingType will have access to all public and protected member from Account, Bank
		displayBankName();
		displayAccountInfo();
		System.out.println("Interest Rate : "+ interestRate);
	}
	
	public void calculateInterest() {
		double interest = balance * (interestRate / 100);
		
		//directly accessed protected members without getter setter
		System.out.println("Annual Interest : "+ interest);
		System.out.println("Bank Name : "+ bankName);
	}

}
