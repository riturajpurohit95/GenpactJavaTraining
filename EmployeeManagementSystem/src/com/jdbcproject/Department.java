package com.jdbcproject;

//department model class

public class Department {
	
	
	private int dept_id;
	private String dept_name;
	private String dept_head;
	
	//constructor
	public Department(String dept_name, String dept_head) {
		this.dept_name = dept_name;
		this.dept_head = dept_head;
	}
	
	
	//gettera and setters
	public int getDept_id() {
		return dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public String getDept_head() {
		return dept_head;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public void setDept_head(String dept_head) {
		this.dept_head = dept_head;
	}


	//toString method
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_head=" + dept_head + "]";
	}
	
	
	

}
