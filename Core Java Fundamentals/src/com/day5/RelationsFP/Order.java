package com.day5.RelationsFP;

//Stream concept
public class Order {
	
	String id;
	double amount;
	
	public Order(String id, double amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public void printOrder() {
		System.out.println("Order is: "+id + " Order amount : "+amount);
	}
	
	public static boolean isHighValue(Order obj) {
		return obj.amount > 5000;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + "]";
	}

	
}
