package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	private String model;
	private List<Tyre> tyres = new ArrayList<>();
	
	public Car(String model) {
		this.model = model;
	}
	
	
	public void addTyres(int number, double size) {
		Tyre t = new Tyre(number, size);
		tyres.add(t);
	}
	
	public void printTyres() {
		System.out.println(model + " has tyres : ");
		if(tyres.isEmpty()) {
			System.out.println("None");
			return ;
		}
		for(Tyre r : tyres) {
			System.out.println(r.getNumber());
		}
	}
	
	public String getModel() {
		return model;
	}
	

}
