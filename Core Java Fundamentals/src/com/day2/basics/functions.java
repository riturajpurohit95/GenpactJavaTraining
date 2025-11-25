package com.day2.basics;

import java.util.Scanner;

public class functions {
 
	//function(methods)
			//block of code that performs a specific task and can be reused 
			//separeate block of coode for each purpose 
			//create a function(method) - does not get executed ]
			// call method - then it gets executed 
			//syntax:
			//modifier returnType functionName(parameters) {
			 		//logic of function 
					//return value 
// function should be outside the main function

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("calling function____");
	welcomeUser();
	int result = addNumber(12 , 23);
	System.out.println("result of addition:" + result);
	System.out.println("addition of 23 and 45 is :" + addNumber(23, 45));
	//calling areaRect function
	 System.out.println("area of rect is :" + areaRect(4, 5));
	//calling areaCircle function
	 System.out.println("area of circle is:" + areaCircle(3.14 , 4, 4));
	 //calling greetuser function
	 greetuser();

	}



	//function with no parameters
	public static void welcomeUser() {
		System.out.println("welcome to java training");
	}
	// function with parameters
	public static int addNumber(int a, int b) {
		int sum = a+b;
		return sum;
	}
	//function overloading 
		//create multiple function with same name but with different parameter list 
		//rules- no of parameter can be different 
		//data types of parameter can be diffent 
		// return type alone cannot be used to overload
	//function overloading - different return type of parameter
	public static double addNumber(double a, double b) {
		double sum = a + b;
		return sum;
	}
	//function overloading - different no of parameter
	public static int addNumber(int a, int b, int c) {
		int sum = a+b+c;
		return sum;
	}

	//function to calculate area of rectangle 
	public static double areaRect(double leng, double wdth) {
		double area = leng * wdth;
		return area;
	}
	//function for calculate area of circle 
	public static double areaCircle(double pie , double r , double r2 ) {
	  double area= 3.14 * r * r2;
	  return area;	
	}
	// function greetuser(name of user) - welcome vandana 
	public static void greetuser() {
		Scanner sc = new Scanner(System.in);
		int name = sc.nextInt();
		System.out.println("welcome"+ name);
		sc.close();
	}

	

}
