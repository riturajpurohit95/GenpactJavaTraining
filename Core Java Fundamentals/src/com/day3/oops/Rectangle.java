package com.day3.oops;

public class Rectangle extends Shape{
	
	private double l;
	private double w;
	
	public Rectangle(double l, double w) {
		this.l = l;
		this.w = w;
	}
	
	
	@Override
	double area() {
		return l * w;
	}
	
	@Override
	double perimeter() {
		return  2*(l+w);
	}
	
	
}
