package com.day3.oops;

// to be inherited from BankAccount class
// extends - keyword
// super - keyword - referring to BankAccount class - base class of SAvingAccount

//when you inherit from abstract class you should implement the abstract methods
//public class SavingsAccount extends bankAccount{
//	
//	//specific to saving account class
//	private double InterestRate;
//
//	public SavingsAccount(int accountNumber, String accHolderName, double balance, double interestrate) {
//		//calling the super class constructor to initiate values
//		super(accountNumber, accHolderName, balance);
//		this.InterestRate = interestrate;
//
//	}
//
//	public double getInterestRate() {
//		return InterestRate;
//	}
//
//	public void setInterestRate(double interestRate) {
//		InterestRate = interestRate;
//	}
//
//	@Override
//	public String toString() {
//		return "SavingsAccount [AccountNumber=" + getAccountNumber()+ "AccountHolderName"+ getAccHolderName()+ "Balance= "+ getBalance() + " getInterestRate=" + InterestRate + "]";
//	}
//	
//	//create method addInterest
//	public void addInterest() {
//		//added to the balance
//		//balance * interestrate / 100
//		//calculate the interest
//		double interest = getBalance() * InterestRate / 100;
//		//add interest to balance
//		double newBalance = getBalance() + interest;
//		setBalance(newBalance);
//		
//		System.out.println("intrest added "+ newBalance);
//		
//	}
//	
//	@Override
//	public void withdraw(double amount){
//		//minimum balance - 5000 
//		//updated definition
//		if(amount>0 && amount <= (getBalance() -5000)) {
//			setBalance(getBalance()-amount);
//			
//			System.out.println("withdrawl successful from overriden method. Updated balance: "+ getBalance());
//			
//		}
//		else {
//			if (amount < 0) {
//				System.out.println("Invalid amount.");
//			}
//			else {
////				System.out.println("cannot withdraw minimum balance 5000 should be there");
//	
//			}
//		}
//	}
//	
//
//
//}


public class SavingsAccount extends bankAccount {
	 
	private double InterestRate; //specific to saving account class

	public SavingsAccount(int acNum, String name, double bal, double interestrate) {
		super(acNum, name, bal);
		this.InterestRate=interestrate;
		// TODO Auto-generated constructor stub
	}
 
 
	public double getInterestRate() {
		return InterestRate;
	}
 
 
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
 
 
	@Override
	public String toString() {
		return "Savingaccount [AccountNumber="+getAccountNumber()+"AccountHolderNmae="+getAccHolderName() +"Balance:"+getBalance()+ "InterestRate=" + InterestRate + "]";
	}
 
	public void addInterest() {
		//added to balance
		//balance*interest/100
		//calculate interest
		double interest= getBalance()*InterestRate/100;
		//add interest to balance
		//double update = interest+getBalance();
		setBalance(getBalance() + interest);
		System.out.println("Account no.:"+getAccountNumber());
		System.out.println("Name:"+getAccHolderName());
		System.out.println("updated balance:"+getBalance());
		System.out.println("interest added");
	}
 
 
	@Override
	public void withdrawlAmount(double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		//super.withdrawlAmount(amount);
		if(amount>0 && amount<= (getBalance()-5000)){
			setBalance(getBalance()-amount);
			System.out.println("withdrawl successful.update balance:"+getBalance());
		}
		else if(amount>getBalance()){
			throw new InsufficientBalanceException("Withdrawl Denied Insufficient Funds");
		}
		else{
			if(amount<0) {
				System.out.println("invalid amount");
			}
			else {
				System.out.println("cannot withdraw minimum balance is 5000");
			}
		}
	}

}
