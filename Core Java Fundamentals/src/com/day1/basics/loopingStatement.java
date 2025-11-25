package com.day1.basics;

import java.util.Scanner;

public class loopingStatement {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//for - print number 1 to some range
//      System.out.println("Enter ending number");
//		int end = sc.nextInt();
//		
//		for(int i=1 ; i<=end; i++ ) {
//			//initialization, stopping condition, increment/ decrement
//			System.out.println(i);
//		}
//		
//		System.out.println("-----------------------");
//		
//		for(int i=end; i>1 ; i--) {
//			System.out.println(i);
//		}
//		
//		//table 
//	
//		for(int i=1 ; i<=10; i++ ) {
//			//initialization, stopping condition, increment/ decrement
//			System.out.println("6 x " + i + "=" + (6 * i));
//		}
//		
//		
//		System.out.println("Write the table you want to print");
//
//		int num1 = sc.nextInt();
//
//		for(int j=1;j<=10;j++) System.out.println(num1+" x "+j+" = "+num1*j);	
//		
//		//nested loop 
//		
//		for(int j=5 ; j<=end ; j++) {
//				
//				for(int i=1; i<=10 ; i++) {
//					System.out.println(j + "*" + i + "=" + (j*1) );
//				}	
 
		
//		
//		int balance = 10000;
//		int choice = 0;
//		while (choice != 4) { // loop continues till user chooses exit
//			System.out.println("1. Deposit Money");
//			System.out.println("2. Withdraw Money");
//			System.out.println("3. Check Balance");
//			System.out.println("4. Exit");
//			System.out.println("Enter choice:");
//			choice =  sc.nextInt();
//		
//			if(choice == 1) {
//				System.out.println("Enter amount to be deposited");
//				int amount = sc.nextInt();
//				balance += amount;
//				System.out.println("Amount Deposited. New balance is: + balance");
//		}
//		
//			else if (choice == 2) {
//				System.out.println("Enter amount to be withdrawn");
//				int amount = sc.nextInt();
//				balance -= amount;
//				System.out.println("Amount Withdrawn. New balance is: + balance");
//		}
//		
//			else if (choice == 3) {
//				System.out.println("Current balance is: + balance");
//				else if (choice == 4) {
//					System.out.println("Thankyou for using ATM");
//					break;
//		}
		// do while loop
		// ensures that the loop runs at least once
		// condition is checked at the end of the loop
		// enter password
		String correctpwd = "java123";
		String EnterPwd ;
		do {
			System.out.println("enter your password");
			EnterPwd = sc.next();
			if(!EnterPwd.equals(correctpwd)) {
				System.out.println("incorrect passpword. Try again.");
			}
		}
			while (!EnterPwd.equals(correctpwd));
			System.out.println( "Access given.");
			sc.close();

			//continue - skip the iteration



	}
 
 
}
