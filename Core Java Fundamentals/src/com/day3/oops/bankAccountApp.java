package com.day3.oops;
//import java.util.Scanner;
//
//public class bankAccountApp {
//	 
//	public static void main(String[] args) {
//
//		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//
////		bankAccount account1 = new bankAccount(101 , "vandana goyal", 20000.00);
////
////		//initialize the object 
////
////		//constructor is called automatically 
////
////		bankAccount account2 = new bankAccount(102 , "Ritu Rajpurohit", 20000.00);
////
////		account1.display();
////		
////		System.out.println();
////
////		account2.display();
////		
////		//deposit, withdraw, checkbalance
////		//acount1 = 20000
////		// read from scanner - how much amount to be deposited -> depositeAmount
////		System.out.println("how much amount you want to deposite"+ account1 + ": ");
////		double depositeAmount = sc.nextDouble();
////		//call deposite method 
////		account1.depositeAmount(depositeAmount);
////		//check balance
////		account1.checkBalance();
////		//read from scanner how much amount to be withdrawn -> withdrawAmount
////		System.out.println("how much amount you want to withdraw "+ account1+ ": ");
////		double withdrawAmount = sc.nextDouble();
////		//call withdraw method
////		account1.withdraw(withdrawAmount);
////		//check balance
////		account1.checkBalance();
//		
//		
//		
////		//in main bankAccountApp
////		//create object for SavingsAccount class
////		SavingsAccount savingAcc1 = new SavingsAccount(103 , "Ritu", 20000.00,6);
////		
////		// check balance
////		savingAcc1.checkBalance();
////		//call add Interest method
////		savingAcc1.addInterest();
////		
////		System.out.println(savingAcc1);
////		savingAcc1.withdraw(5000);
//		
//		CurrentAccount currAcc1 = new CurrentAccount(104, "Raj", 10000, 2);
//		
//		currAcc1.depositeAmount(5000);
//		
//		
//		currAcc1.withdraw(2000);
//		currAcc1.checkBalance();
//		
//		sc.close();
//	}
// 
//}
// 


import java.util.*;

public class bankAccountApp {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
		bankAccount account1= new bankAccount(101,"vandana Goyal",20000.00);
		//initialize object
		//constructor automatically called
		bankAccount account2= new bankAccount(102,"Ritu Rajpurohit",2000.00);
		account1.display();
		account2.display();
		// deposit, withdraw, checkbalance
		// account1 - 20000
		// read from scanner - how much amount to be deposited -> depositAmount
		// call deposit method
		// check balance
		// rad from scaaner - how much amount to be withdrawn -> withdrawAmount
		// call withdraw method
		// check balance
		System.out.println("Enter amount to deposit :");
		double depositAmount1 = sc.nextInt();
		account1.depositAmount(depositAmount1);
		account1.checkBalance();
		System.out.println("Enter amount to withdraw :");
		double withdrawAmount = sc.nextInt();
		try{
			account1.withdrawlAmount(withdrawAmount);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		account1.checkBalance();
		sc.close();
		System.out.println(account1.getAccountNumber());
		System.out.println(account1.getAccHolderName());
		System.out.println(account1.getBalance());
		//create object for savingsbankaccount class
		//check balance
		//call add interest method
		SavingsAccount account3=new SavingsAccount(100,"rashi",10000.00,6);
		account3.getInterestRate();
		account3.addInterest();
		System.out.println(account3);	
		try{
			account3.withdrawlAmount(3000);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		CurrentAccount account4=new CurrentAccount(1000,"gupta",10000.00,2);
		//try{
			account4.depositAmount(5000.00);
		//}
		//catch(InsuffcientBalanceException e) {
		//System.out.println(e.getMessage());
		//}
		account4.withdrawlAmount(5000.00);
 
	}
 
}
