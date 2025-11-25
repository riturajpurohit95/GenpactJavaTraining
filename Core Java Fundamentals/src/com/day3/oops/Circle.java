package com.day3.oops;

public class Circle extends Shape{
	
	private double r;
	
	public Circle(double r) {
		this.r = r;
	}
	
	
	@Override
	double area() {
		return Math.PI * r * r;
	}
	
	@Override
	double perimeter() {
		return Math.PI * 2* r;
	}
	
	
}
