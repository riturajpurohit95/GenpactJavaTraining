package com.day5.RelationsFP;

public class FunctionalProgrammingConcepts {

	public static void main(String[] args) {
		
		//Java B
		//defore java 8 -> oops
		//after java 8 -> functional programming
		//- focusing on what to do and not how to do
		//- lamda expressions -> 
		//- FP - boilerplate code reduced by this
		//- improved readability also
		//- enabled parallel stream execution - stream API
		//- filter map, ...
		//- lamdas, streams, functional interfaces, --- focueses on what to achieve
		//Comparator<EmployeeComaparator> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);
		
		
		//Functional interface - 
		//- interface which contain exactly one abstract method
		//- ex. - customer - discount -> regularCustomer - 10%,  but for premiumCustomer - 20%, festiveDiscount - 30%....
		//- we can use lamda expressions
		
		
		//Lambda expressions-
		//- short unnamed funstion
		//- concise way to implement function or functional interface
		//- no need to define the proper function
		//- also called - anonymous method
		//- syntax -  () -> expression
		//- short calculation
		//- streams
		//- not to use for complex logic
		//- normal interface - more than abstract methods - not to use lambda functions
		//- forEach - 
		
		
		//Method Refrences -> ::  -> refrence operator
		//- with method refrence 
		//- call a constructor -> Employee :: new 
		//- call instance method -> ClassNAme :: instanceMethod
		//- call static method -> classNAme :: staticmethod
		
		
		//Streams - 
		//- java 8
		//- used to process collections in a more functional, declarativ way
		//- pipeline - takes data - performs transformations - produces result
		//- without modifying the original data
		//- takes sequence of elements from List
		
		//- ex. --- Employee - dept
		//- filter emp who are from it department - let 2 emp came out
		//- convert name to Upper case
		//- fetch only it emps -> using filter()
		//- name - upper case -> use map()
		

	}

}
