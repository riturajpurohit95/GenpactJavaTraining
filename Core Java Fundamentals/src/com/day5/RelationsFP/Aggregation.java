package com.day5.RelationsFP;

public class Aggregation {

	public static void main(String[] args) {
		
		Professor p1 = new Professor("101", "pr1");
		Professor p2 = new Professor("102", "pr2");
		Professor p3 = new Professor("103", "pr3");
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName());
		
		Department d1 = new Department("Maths");
		Department d2 = new Department("CS");
		
		d1.addProfessor(p3);
		d2.addProfessor(p1);
		d2.addProfessor(p2);
		
		d1.printProfessors();
		d2.printProfessors();
		

	}

}
