package com.day3.oops;

public class Account extends Bank{
	
	protected String accountHolder;
	protected double balance;
	
	public Account(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public void displayAccountInfo() {
		displayBankName();
		System.out.println("Account Holder : " + accountHolder);
		System.out.println("Balance : "+ balance);
	}

}
