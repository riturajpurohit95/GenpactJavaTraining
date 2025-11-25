package com.day3.oops;

public class MultilevelBankApp {
	
	public static void main(String[] args) {
		SavingType savingObj = new SavingType("Ritu", 30000, 2);
		
		savingObj.displaySavingsInfo();
		savingObj.calculateInterest();
		
		
	}

}
