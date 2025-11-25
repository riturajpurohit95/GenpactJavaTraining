package com.day3.oops;

public class oopsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//- Encapsulation  - Hidding internal details of a class using private firlds
		//					- getters and setters
		//- Inheritance = create a class
		//				- SavingsAccount - minbalance = 5000, interestRate = 7%
		//				- is a BankAccount only
		//				- accNum, HolderName, balance
		//				- reuse bankAccount class
		//				- inherit savingsAccount from BankAccount
		//				- BankAccount - base class, parent class, super class
		//				- SAvingsAccount - Derived class, child class, sub class
		//				- single inheritence
		//	BankAccount - inherit any number of class, curretn account
		//				- Hierarchical inheritence - multiple subclasses are inherited from sinle super class
		// multiple inheritence
		// multilelvel inheritence - BA -> SA -> SC
		// class sample extends SavingsAccount
		
		//- Polymorphism - poly means many , morphism means forms
		//					- humans exhibit polymorphic behavior
		//			methods - function overloading -> behaving differently for diff. list of arguments
		//					- method overriding
		//					- bankAccount - method -withdraw
		//					- savingsAccount - updated definition of withdraw -> transaction fee, min balance should be maintained 5000, 
		
		
		//Hierarical inheritance
		//- from bankAccount inherit another class - curretnAccount
		// - transactionFee (attribute) - 2%
		// - override both deposite and withdraw
		// - deposite - 10000, 5000 - 2% 5000= 100 has to be deducted from balance
		//				- 10000 + 5000 -100
		//Similarly withdraw
		// - 2% fee on amount to be withdrawn
		// currentAccountTested
		
	
		//- Exception - Custom Exception - Insufficient Balance
		//
		//- Abstraction 
		// -> hide the complexity from the users
		// -> present simplified view of the object
		// -> focus on what and not how
		// -> abtract classes -> which has atleast one abstract method
		//   - we declare method in class but we do not the implementation of the method
		// withdraw() and all are concreat methods because they have declaration
		// can have both concreate and abstract methods
		//    use keyword abstract - for creation of abstract method
		//      class is abstract -> cannot instanciate that class
		//        we cannot create object of that classes
		//			they are implemented by inheriting
		//			when inherited their subclass nust override and give implementation of the base class (madatory)
		
		// take situation - in certain bank 
		// accounts can be created of either the type saving or current acc type
		// common things are in bank account class
		//bankAccount we do not want to create obj then will make bankAccount class abstract class
		
		
		
		
		
		//abstract class shape - abstract methods area(), perimeter()
		//inherit 3 classes - circle class(radius - override area and perimeter
		//rectangle (len, wdth) - override area abd perimter 
		//shapeApp - main() - test the circle and abstract
		
		// -> Interfaces 
		// - defines a set of abstract methods
		// - all methods are abstract only
		// - by default they are public and abstract
		// - interface keyword -> contracg every inherited class has to implement
		// - for extending class - another keyword - implement
		// - why? - abstraction
		// - with interfaces we can implemetn multiple inheritence as well
		// - we can implement polymorphism also, diff classes can implement same interface and we can treat them uniformly
		
		
//		class A{
//			void show() {//---------------};
//				
//			}
//		class B{
//			void show() {//-----------------};
//			}
//			
//		class Test extends A,B{
//			//TEst will have two implementations of show method
//			// ambiguity -> obj.show() ->  diamond problem
//			// here interface helps};
//		}
		
		//Multilevel - class A -> Class B -> Class C
		// public private , protected, available directly to inherited class
		// bankAccount -> protected
		
	}

}
