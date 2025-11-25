package com.jdbcproject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

	//corresponding to employee table in ems_db
	//serves as model class
	
	//CRUD operations - create read update delete
	//read update delete
	//with java application
	//insert some row in employee
	// - inserting that with Java Application
	//class - store the record in mysql table
	//no need of provide id
	//simple POJO class - plain old java object - represents an employee record
	
	private int id;
	private String name;
	private String email;
	private boolean isActive;
	private BigDecimal salary;
	private LocalDate hireDate;
	private LocalDateTime lastlogin;
	
	//constructor - without id
	
	public Employee(String name, String email, boolean isActive, BigDecimal salary, LocalDate hireDate
			) {
		this.name = name;
		this.email = email;
		this.isActive = isActive;
		this.salary = salary;
		this.hireDate = hireDate;
//		this.lastlogin = lastlogin;
	}
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public boolean isActive() {
		return isActive;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public LocalDateTime getLastlogin() {
		return lastlogin;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	//toString method 
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", isActive=" + isActive + ", salary="
				+ salary + ", hireDate=" + hireDate + ", lastlogin=" + lastlogin + "]";
	}
	

}
