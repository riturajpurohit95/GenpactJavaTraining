package com.day12.javafileio;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//filed - ensure version compatibility b/w serialized and deserialized objects
	
	// instance variables
	int empid;
	String name;
	transient double salary; 
	// empid, name - will be saved(Serialized)
	// salary - transient - tells jvm not to serialize this field 
	// salary will not be saved
	
	//when deserialize, salary will  take default value - 0.0
	public Employee(int empid, String name, double salary) {
		super();
		this.empid=empid;
		this.name = name;
		this.salary = salary;
	}

}
