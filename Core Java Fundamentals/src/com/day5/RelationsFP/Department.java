package com.day5.RelationsFP;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private String d_name;
	private List<Professor> professors = new ArrayList<>();
	
	public Department(String d_name) {
		this.d_name = d_name;
	}
	
	//add professor
	public void addProfessor(Professor p) {
		if(!professors.contains(p)) {
			professors.add(p);
		}
	}
	
	//print professor
	public void printProfessors() {
		System.out.println("Department "+ d_name);
		if(professors.isEmpty()) {
			System.out.println("None");
			return;
		}
		for(Professor p: professors) {
			System.out.println(p.getName());
		}
//		System.out.println();
	}
	
}
