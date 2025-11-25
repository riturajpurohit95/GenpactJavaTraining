package com.day3.oops;

//public class bankAccount {
//
//	//for all calsses - super - is the Object class
//	//attributes and behavior - implement with methods 
//
//	//make the data private by using private specifier, modifier
//
//	//priavte - cannot be accessed outside the class
//
//	private int accountNumber;
//
//	private String accHolderName;
//
//	private double balance;
//
//	//special method - constructor - purpose is to initiate objects 
//
//	//it has same name as class
//
//	//constructor 
//
//	public bankAccount(int acNum , String name , double bal) {
//
//		//special keyword -> this 
//
//		this.accountNumber = acNum;
//
//		this.accHolderName = name;
//
//		this.balance = bal;			
//
//	}
//	
//	//getters and setters
//	//getters are used to fetch the values of private attributes
//	public int getAccountNumber() {
//		return accountNumber;
//	}
//	public String getAccHolderName() {
//		return accHolderName;
//	}
//	public double getBalance() {
//		return balance;
//	}
//	
//	//setters are used to set or update the values of private attributes
//	public void setAccHolderName(String accHolderName) {
//		this.accHolderName = accHolderName;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//	
//	//getters and setters can be created directly  -> right click and go to source 
//	
//	//display method 
//
//	public void display() {
//
//		System.out.println("accNum :" + accountNumber);
//
//		System.out.println("acc holder name " + accHolderName);
//
//		System.out.println("acc balance :" + balance);
//
//	}
//
//	//methods - behaviors 
//
//	//depositAmount ()
//
//	public void depositeAmount(double amount ) {
//
//		if (amount > 0 ) {
//
//			balance += amount;
//
//			System.out.println("deposite successfull. update balance:" + balance);
//
//		}
//		else {
//			System.out.println("Invalid amount");
//		}
//
//	}
//
//
//
//	//withdraw()
//	
//	public void withdraw(double amount)  throws InsufficientBalanceException{
//		if(amount > 0 && amount <= balance) {
//			balance -= amount;
//			System.out.println("withdrawl successful. Update balance: "+ balance);
//		}
//		else {
//			System.out.println("Invalid Amount");
//		}
//	}
//	
//	//abstract function
////	abstract void withdraw(double amount);
//	//we have given only method signature
//
//	//checkBalance()
//	
//	public void checkBalance() {
//		System.out.println("Current balance: "+ balance);
//	}
//
//	
//
//	
//
//	
//	//used to give string representation of the object
//	@Override
//	public String toString() {
//		return "bankAccount [accountNumber=" + accountNumber + ", accHolderName=" + accHolderName + ", balance="
//				+ balance + "]";
//	}
//	
// 
//}

 
import java.util.*;

public class bankAccount {
	// TODO Auto-generated method stub
			//Attributes and behaviour - implemented with methods
 
			
			//attribute,properties
			//data belonging to object
			//data should be secured
			//inaccessible publicly
	Scanner sc=new Scanner(System.in);
	//make the data private by using private specifier
	//private- these attribute are not accessed outside class
		private int accountNumber;
		private String accHolderName;
		private double balance;
		//constructor
		public bankAccount(int acNum,String name,double bal) {
			//this- special Keyword
			this.accountNumber=acNum;
			this.accHolderName = name;
			this.balance=bal;
		}
		//getters and setters
		//getters and setters are used to fetch the value of private attribute
		//setters are used to set the value and update
		public int getAccountNumber() {
			return accountNumber;
		}
 
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
 
		public String getAccHolderName() {
			return accHolderName;
		}
 
		public void setAccHolderName(String accHolderName) {
			this.accHolderName = accHolderName;
		}
 
		public double getBalance() {
			return balance;
		}
 
		public void setBalance(double balance) {
			this.balance = balance;
		}
 
	
		//to display the data
		public void display() {
			System.out.println("account no.:"+accountNumber);
			System.out.println("account name:"+accHolderName);
			System.out.println("balance:"+balance);
		}
			//methods=  depositAmount() , withdrawAmount() , checkBalance()
 
 
		@Override
		public String toString() {
			return "BankAccount [sc=" + sc + ", accountNumber=" + accountNumber + ", accHolderName=" + accHolderName
					+ ", balance=" + balance + "]";
		}
		public void depositAmount(double amount) {
			if(amount>0) {
				balance += amount;
				System.out.println(balance);
			}
		}
		public void withdrawlAmount(double amount) throws InsufficientBalanceException {
			if(amount>0 && amount <=balance) {
				balance -= amount;
				System.out.println("withdrawl successfully. updated balance: "+balance);
			}
			else if(amount>balance) {
				throw new InsufficientBalanceException("withdrawl denied.Insuffcient funds");
			}
			else {
				System.out.println("invalid amount");
			}
		}
		public void checkBalance() {
			System.out.println("current balance: "+balance);
		}
		//abstract void withdraw(double amount);
}
