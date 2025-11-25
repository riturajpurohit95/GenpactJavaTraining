package com.day3.oops;

public class AbstractionInherited extends AbstractionExample{

	private int num2;
	
	public AbstractionInherited(int num, int num2) {
		super(num);//super always calls parent class constructor
		this.num2 = num2;
	}
	
	@Override
	void multiply(int digit) {
		int result = getNum()* digit;
		setNum(result);
	}
}
