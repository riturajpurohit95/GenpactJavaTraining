package com.day1.basics;

public class fundamentals {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		//- which can hold some value and that can be changed
		//- variable declaration- define variable should hold what can of value 
		//- integer, decimal, text
		//data types 
		//- tell us what kind of value we can store in variable 
		//-strongly typed language 
		//operators 
		//- tells what kind of operation we have to perform
		//- a + b ->  + is an operation and a & b are operands 
		//integer type in java 
//		byte byteVar = 100;
//		short shortVar = 2000;
//		int intNum = 10000;
//		long longNum = 1500000L;
//		System.out.println("value of the variable : " + intNum);
//		//floating types
//		float floatNum = 12.56f; // after decimal we can store upto 6 digits
//		double doubleNum = 123.7868; //after decimal we can store upto 14 digits	
//		//character type
//		 char grade = 'A';
//		//string - collection of characters
//		String message =" we are creating a srting type ";
//		//boolean type 
//		//- which has only two possible value true and false 
//		boolean hasAadharCard = false;
		//operators 
			int a= 10, b=4; 
		//Arithmetic operators 
		System.out.println("a +b :" + (a+b));
		System.out.println("a - b:" + (a-b));
		System.out.println("a * b:" + (a * b ));
		System.out.println("a / b:" + (a / b ));
		// Relational Operators - comparison equal, unequal, < >
		// Boolean result
		System.out.println("a == b : " + (a == b) ); // Equality
		System.out.println("a != b : " + (a != b) ); // In equality
		// < > <= >=
		//logical operator - combine conditions
		// && ||
		boolean cond1 = true ;
		boolean cond2 = false;
		System.out.println("cond1 && cond2 ;" + (cond1 && cond2)); //logical AND
		//|| -> true even if any one is true 
		// ! -> logicl not -> works with only one operand 
		// !cond1 => true -> false, false -> true
		System.out.println("cond1 || cond2 ;" + (cond1 || cond2)); //logical AND
		System.out.println("cond1 && cond2 ;" + (cond1 && cond2)); //logical AND
		System.out.println("!cond1 :" + !cond1); //negation
		//short hand operators 
		System.out.println( a += 15);
		System.out.println( a -= 15);
		System.out.println( a *= 15);
		System.out.println( a /= 15);
		System.out.println( a %= 15);
		// increment / decrement operators 
		// inc ++
		// Dec --
		System.out.println("---------------------------");
		int count = 10;
		System.out.println("initial count :" + count  );
		System.out.println("After ++count: " + (++count)); // pre increment 
		System.out.println("After count++: " + (count++)); // post increment 
		System.out.println("After post increment: " + count); // pre increment 
		//pre-decrement and post-decrement
		System.out.println("initial count :" + count  );
		System.out.println("After --count: " + (--count)); // pre decrement
		System.out.println("After count--: " + (count--)); // post decrement
		System.out.println("After post increment: " + count);  

 
	}
 
}
