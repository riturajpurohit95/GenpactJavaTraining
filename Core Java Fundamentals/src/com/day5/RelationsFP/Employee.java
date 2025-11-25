package com.day5.RelationsFP;

public class Employee implements Comparable<Employee> {

	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Employee other) {
		// asc order of salary
//		return Double.compare(this.salary, other.salary);
		return Integer.compare(other.id,this.id);//reverse order sorting
	}
	
	
	//case 1 : e1, e2, - e1.compareTo(e2)
	//Generic- list of Emps - collection - collection.sort()  -> by defualt it uses the compareTo()
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name = " + name + ", slary=" + salary + "]";
	}
	

}
