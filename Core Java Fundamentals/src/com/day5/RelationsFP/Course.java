package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String code;
	private String c_name;
	private List<Student> students = new ArrayList<>();
	
	public Course(String code, String name) {
		super();
		this.code = code;
		this.c_name = name;
	}
	
	public void addStudent(Student s) {
		if(!students.contains(s)) {
			students.add(s);
		}
	}
	
	//print students
	public void printStudetns() {
		System.out.println(c_name + " has studetns : ");
		if(students.isEmpty()) {
			System.out.println("None");
			return ;
		}
		for(Student s : students) {
			System.out.println(s.getName()+ " ");
		}
	}
	
	public String getName() {
		return c_name; //return course name
	}

}
