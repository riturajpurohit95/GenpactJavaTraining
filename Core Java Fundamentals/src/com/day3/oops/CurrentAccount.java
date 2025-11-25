package com.day3.oops;

//public class CurrentAccount extends bankAccount{
//		private double transactionFee;
//		
//		public CurrentAccount(int accountNumber, String accHolderName, double balance, double fee) {
//			//calling the super class constructor to initiate values
//			super(accountNumber, accHolderName, balance);
//			this.transactionFee = fee/100;
//
//		}
//		
//		@Override
//		public void depositeAmount(double amount ) {
//
//			if (amount > 0 ) {
//
//				double newBalance = getBalance() + amount - (transactionFee * amount);
//
//				System.out.println("deposite successfull. update balance:" + newBalance);
//
//			}
//			else {
//				System.out.println("Invalid amount");
//			}
//
//		}
//		
//		
//		@Override
//		public void withdraw(double amount)  {
//			if(amount>0 && amount <= (getBalance())) {
//				setBalance(getBalance()-amount- (transactionFee * amount));
//				
//				System.out.println("withdrawl successful from overriden method. Updated balance: "+ getBalance());
//				
//			}
//			else if (amount < 0) {
//					System.out.println("Invalid amount.");
//			}
//		}
//}


public class CurrentAccount extends bankAccount {

	double transactionfee;
 
	public CurrentAccount(int acNum, String name, double bal,double fee) {

		super(acNum, name, bal);

		this.transactionfee=fee;	

		// TODO Auto-generated constructor stub

	}
 
	@Override

	public void depositAmount(double amount)  {

		// TODO Auto-generated method stub

		//super.depositAmount(amount);

		double am=(getBalance()+amount);

		double newf=(transactionfee/100)*amount;

		double newb=am-newf;

		System.out.println("after fee:"+newb);

	}
 
	@Override

	public void withdrawlAmount(double amount) {

		// TODO Auto-generated method stub

		//super.withdrawlAmount(amount);

		double am=(getBalance()-amount);

		double newf=(transactionfee/100)*amount;

		double newb=am-newf;

		System.out.println("after fee:"+newb);

	}

 
}

 