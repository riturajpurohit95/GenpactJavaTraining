package com.day5.RelationsFP;

public class EmployeeComparator {
	
	int id;
	String name;
	double salary;
	
	public EmployeeComparator(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id = " + id + ", name= " + name + ", salary=" + salary + "]";
	}
	

}
