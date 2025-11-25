package com.day1.basics;

import java.util.Scanner;

public class ConditionalStatement {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//control statements - conditional, Looping 
		//program execution line by line 

		//if else , else if , switch  - keyword 
		 int num = 25 ;
		 //number is even or not 
		 //num % 2 == 0 -> reminder 0 -> even,
		 if ( num % 2 == 0) {
			 //true block 
			 System.out.println(num + "is even");	 
		 }
		 else {
			 //false block 
			 System.out.println(num + "is odd ");
		 }
		 // assignment 
		 // var age -> some age 
		 // decide person is eligible to vote or not , citizenshipIndian = true 
		 int age = 28;
		 String citizenshipIndian = "India" ;
		 if (age >= 18 && citizenshipIndian == "India"  ) {
			 System.out.println("eligible to vote");
		 }
		 else {
			 System.out.println("not eligible to vote");
		 }

		 //multiple conditions - if and else if blocks 
		 int marks = 90;
			 //marks >= 90 grade A 
			 //marks =(75 - <90 ) grade B 
			 //marks =(60 - <70 ) grade C
			 //marks =(40  - <60 ) grade D
			 //fail
			 if (marks >= 90 ) {
				 System.out.println("Grade is : A");
			 }
			 else if (marks >= 75 && marks <90) {
				 System.out.println("Grade is : B");	 
			 }
			 else if (marks >= 60 && marks <70) {
				 System.out.println("Grade is : C");
			 }
			 else if (marks >= 40 && marks <60) {
				 System.out.println("Grade is : D");
			 }
			 else {
				 System.out.println("Failed");
			 }
			//Scanner Object
				// - Scanner class- we take input from the user
				// -inbuilt scanner class we need to create an object that obj 
				// and we need to tell that we need to take an input 
				//Switch 
				// Restraunt menu 
				System.out.println("Press 1. Pasta");
				System.out.println("Press 2. Pizza");
				System.out.println("Press 3. Burger");
				System.out.println("Press 4,Exit ");
				System.out.println("Enter your choice:");
				Scanner sc=new Scanner (System.in);
				int choice = sc.nextInt();
				switch(choice) {
					//cases
				case 1:
					System.out.println("You ordered Pasta");
					System.out.println("Price :INR 250");
					break;
				case 2:
					System.out.println("You ordered Pizza");
					System.out.println("Price :INR 450");
					break;
				case 3:
					System.out.println("You ordered Burger");
					System.out.println("Price :INR 150");
					break;
				case 4:
					System.out.println("Thank You for visiting");
					break;
				default: // it will execute when all cases will fail			 

 
	
	}
				sc.close();
	}
	
 
}
