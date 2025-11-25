package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoparatorMain {

	public static void main(String[] args) {
		
		List<EmployeeComparator> employees = new ArrayList<>();
		
		
		employees.add(new EmployeeComparator(101,"emp2",60000));
		employees.add(new EmployeeComparator(102,"emp2",25000));
		employees.add(new EmployeeComparator(102,"emp2",35000));
		employees.add(new EmployeeComparator(103,"aemp1",40000));
		
		//create comparator for sorting by name a-z
		Comparator<EmployeeComparator> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);  //lamda expression
		
		
		Comparator<EmployeeComparator> salaryComparator = (e1, e2) -> Double.compare(e1.salary,e2.salary);
		
		
		System.out.println("Before sorting: " + employees);
		employees.forEach(System.out::println);
//		System.out.println();
//		Collections.sort(employees,nameComparator); 
//		System.out.println("After sorting: "+ employees);
//		employees.forEach(System.out::println);
//		System.out.println();
//		Collections.sort(employees,salaryComparator); 
//		System.out.println("After sorting: "+ employees);
//		employees.forEach(System.out::println);
		
		//sorting based on both name and salary?
		
		Comparator<EmployeeComparator> combinedComparator = Comparator.comparing((EmployeeComparator e) -> e.name)
																.thenComparing((EmployeeComparator e) -> e.salary);
		System.out.println();
		Collections.sort(employees,combinedComparator); 
		System.out.println("After sorting: "+ employees);
//		employees.forEach(System.out::println);
		employees.forEach(item -> System.out.println(item));
		
	}

}
