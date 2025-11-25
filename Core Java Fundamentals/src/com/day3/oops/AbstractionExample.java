package com.day3.oops;

abstract class AbstractionExample{
	private int num;
	
	public AbstractionExample(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	//we just give the method header/signature but no body is given
	abstract void multiply(int digit);
	
	//we have given implementation - concrete methods
	public void display() {
		System.out.println("Value of num: "+ num);
	}
}
