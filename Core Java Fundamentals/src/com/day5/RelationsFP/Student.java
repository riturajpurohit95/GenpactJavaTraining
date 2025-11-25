package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String id;
	private String name;
	private List<Course> courses = new ArrayList<>();
	//List will be of Course type
	
	public Student (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//method enroll
	public void enroll(Course c) {
		//methods (int a)
		if (!courses.contains(c)) {
			
			courses.add(c); // added new course to the course list
			c.addStudent(this); // add a student in that c course,  bidireactional relationship
			
		}
	}
	
	//print courses
	public void printCourses() {
//		System.out.println("Enrolled in: ");
		if(courses.isEmpty()) {
			System.out.println("None");
			return;
		}
		for(Course c : courses) {
			System.out.println(c.getName()+ " ");
		}
	}
	
	//will use in course to get name of student
	public String getName() {
		return name;
	}

}
