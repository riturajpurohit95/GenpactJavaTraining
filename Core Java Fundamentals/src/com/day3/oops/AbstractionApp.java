package com.day3.oops;

public class AbstractionApp {
		public static void main(String[] args) {
			//abstract classes cannot be instantiated
			//AbstractionExample obj = new AbstractionExample();
			AbstractionInherited obj1 = new AbstractionInherited(23,34);
			obj1.multiply(4);
			obj1.display();
		}
}
