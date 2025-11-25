package com.jdbcproject;

import java.math.BigDecimal;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class EmployeeMainApp {

	public static void main(String[] args) {
		
		//create connection
		
//		Connection conn = DBUtil.getConnection();
//		try {
//			if(conn!=null) {
//				System.out.println("Connected to database: "+conn.getCatalog());  // getCatalog() - give database name
//			}
//			else {
//				System.out.println("Connection returned null.");
//			}
//		}catch(SQLException e) {
//			System.out.println("Connection failed. "+e.getMessage());
//		}
		
		//create an employee object - no id will be provided
		
//		Employee emp1 = new Employee("Karishma", "karishma@gmail.com", true, new BigDecimal("55000.00"), LocalDate.of(2025, 8, 03));
		
		//object of EmployeeDAO class
		EmployeeDAO emp_dao = new EmployeeDAO();
//		Scanner sc = new Scanner(System.in);
		
		//make use of this dao object to insert emp1 data into sql table via addEmployee method
//		emp_dao.addEmployee(emp1);
		
//		Employee updated_emp = new Employee("Anil Tada","anil@gmail.com",true,new BigDecimal("70000.00"), LocalDate.of(2025, 8, 3));
		
//	    updated_emp.setId(2);
	    
//	    emp_dao.updateEmployee(updated_emp);
		
		
//		emp_dao.deleteEmployee(6);
		
//		System.out.println(emp_dao.readEmployee());
		
//		List<Employee> emp_list = emp_dao.readEmployee();
//		for(Employee e: emp_list) {
//			System.out.println(e);
//		}
		
//		System.out.println("Enter employee id to get : ");
//		int id = sc.nextInt();
//		
//		Employee emp = emp_dao.readEmployeeById(id);
//		
//		if(emp!=null) {
//			System.out.println("Employee Found: ");
//			System.out.println(emp);
//		}
//		else {
//			System.out.println("Employee Not Found. ");
//		}
//
//		sc.close();
		
//		emp_dao.createTableDepartment();
		
//		emp_dao.adminTasks();
		
//		emp_dao.getSalaryById(2);
//		emp_dao.getSalaryById(8);
		
//		emp_dao.fetchEmployeesBySalary(new BigDecimal("25000"),new BigDecimal("50000"));
		
//		emp_dao.fetchActiveEmployees();
		
//		emp_dao.fetchEmployeeDepartmentJoin();
		
//		emp_dao.showEmployeeTableMetaData();
		
//		emp_dao.showDatabaseMetadata();
		
		String imagePath = "C:\\Users\\703438507\\Desktop\\profile_pic_image1.webp";
		
//		emp_dao.updateProfilePicAndLastLogin(2, imagePath , LocalDateTime.now());
		
//		emp_dao.fetchProfilePic(2, "C:\\Users\\703438507\\Desktop\\retrieved_profile_pic_image1.webp");
		
//		emp_dao.fetchProfilePic(1, imagePath);
		
		
		
		
		
	}

}
