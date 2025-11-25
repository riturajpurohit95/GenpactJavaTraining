package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "emp1", 90000));
		employees.add(new Employee(103, "emp3", 50000));
		employees.add(new Employee(102, "emp2", 30000));
		
		System.out.println("Before sorting: " + employees);
		
		employees.forEach(System.out::println);//will call toString()
		System.out.println();
		Collections.sort(employees); //will use compareTo method which we have overriden 
		System.out.println("After sorting: "+ employees);
		employees.forEach(System.out::println);
		

	}

}
