package com.day5.RelationsFP;

public class ComparingInterfaces {

	public static void main(String[] args) {
		
		//comparable and comparator
		//- list.sort() -> sorting happens by comparing
		
		//- to sort custom objects like - Employee objects(nased on salary, rating)
		//Students - marks, products - prices
		
		//Collections - TreeSet, TreeMap -> Collections.sort() 
		//way - to compare ? 
		
		//2 interfaces - 
		
		//comparable interface -
		//- logic is defined inside the class
		//-natural sorting, default sorting
		//- defined in package java.lang
		//- predefined method -> compareTo
		//- public int compareTo(T other)
		//- sort employees by salary ->  ex....
		
		
		//comparator interface -
		//- logic is defined outside the class
		//- when we want custom sorting - on our own criteria
		//- can enable multiple sorting strategies
		//- 2 key methods -> compare
		//- int compare(T obj1, T obj2)
		//- boolean equals(Object obj);  -> rarly used
		//- sort emp by name then by salary -> ex..
		//- 

	}

}
