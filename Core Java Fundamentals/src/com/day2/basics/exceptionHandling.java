package com.day2.basics;

import java.util.InputMismatchException;
import java.util.Scanner;
 
//creating a custom exception
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message);  // super- calling exception class to print the messgae 
	}
}
 
public class exceptionHandling {
	//built in exception 
	//compile time exception - checked Exception - IOexception , fileNotFoundException
	//runtime Exception - unchecked exception , array not found 
	public static void withdraw(double balance, double amount) throws InsufficientBalanceException{
		if(amount>balance) {
			throw new InsufficientBalanceException("insufficinet balance : withrawal cannnot be done.");
		}
		System.out.println("withrawal succesfull.");
	}
 
	public static void main(String[] args) {
		double balance = 100000;
		double w_amount= 12000;

		try {
			withdraw(balance, w_amount);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

		// TODO Auto-generated method stub
		//exception
		//errrors - wrong parameter, missing ; , error -> syntax error 
		//runtime errors 
//		int a = 123;
//		int b = 0;
//		System.out.println(a/b); //run time error 
		//program has crashed abruptly 
		//handle these exception gracefully 
		//try-catch-finally blocks 
		//try -> put that code that might throw an exception a/b
		//catch -> handles that exception
		//finally -> optional block 
		Scanner sc = new Scanner(System.in);
//		System.out.println("enter numerator:");
//		int num = sc.nextInt();
//		System.out.println("enter denominator :");
//		int denom = sc.nextInt();
//		int marks[] = new int[5];
//		marks[0] = 10;
//		marks[1] = 20;
//		marks[2] = 30;
//		marks [3] = 40;
//		marks[4] = 50;
//		
//		try {
//			System.out.println("enter numerator:");
//			int num = sc.nextInt();
//			System.out.println("enter denominator :");
//			int denom = sc.nextInt();
//			int marks[] = new int[5];
//			marks[0] = 10;
//			marks[1] = 20;
//			marks[2] = 30;
//			marks[3] = 40;
//			marks[4] = 50;
//			
//			int result = num / denom; // may result in an exception
//			System.out.println("result :" + result );
//			System.out.println(("marks :" +  marks[5]));
//		}//multiple catch blocks 
//		 //sppecific exception catch blocks 
//		
//		catch (ArithmeticException e) {
//			System.out.println("eerror : division by 0 is not possible.");	
//		}
//		catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("array index is out of bounds");	
//		}
//		catch(InputMismatchException e)
//		{
//			System.out.println("enter only integer value");
//		}
//		//generic catch block 
//		//generic class - exception
//		catch(Exception e) {
//			System.out.println("some exception occured." + e.getMessage());
//		}
//		finally {
//			// run irrespective of there is an exception or not
//			//closing statement are written 
//			//closing resources
//			System.out.println("task finished");
//			sc.close();
//		}
		//built in exception 
		//custom exception in java 
		// usefull for domain specific errors 
		//extends from exception class
		//bank account 
		// - withraw money -> witAount 

 
}
}
