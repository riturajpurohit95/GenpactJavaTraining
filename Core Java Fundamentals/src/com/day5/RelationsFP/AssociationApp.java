package com.day5.RelationsFP;

public class AssociationApp {

	public static void main(String[] args) {
		
		//creating 4 students
		//creating 2 course - java, python
		
		Student s1 = new Student("s01","Ritu");
		Student s2 = new Student("s02","Garima");
		Student s3 = new Student("s03","Anchal");
		Student s4 = new Student("s04","Harshita");
		
		Course c1 = new Course("001","Python");
		Course c2 = new Course("001","Java");
		Course c3 = new Course("001","HTML");
		Course c4 = new Course("001","CSS");
		Course c5 = new Course("001","C++");
		
		
		//enroll
		s1.enroll(c5);
		s1.enroll(c1);
		s2.enroll(c3);
		s2.enroll(c1);
		s3.enroll(c3);
		s4.enroll(c5);
		
		
		System.out.println("Studetns: ");
		System.out.println(s1.getName() + " enrolled in : ");
		s1.printCourses();
		System.out.println(s2.getName() + " enrolled in : ");
		s2.printCourses();
		System.out.println(s3.getName() + " enrolled in : ");
		s3.printCourses();
		System.out.println(s4.getName() + " enrolled in : ");
		s4.printCourses();
		
		
	
//		c1.addStudent(s1);
//		System.out.println(c1.getName());
		
		
		System.out.println("Courses: ");
		c1.printStudetns();
		c2.printStudetns();
		c3.printStudetns();
		c4.printStudetns();
		c5.printStudetns();
		
		
		
		
		
		

	}

}
