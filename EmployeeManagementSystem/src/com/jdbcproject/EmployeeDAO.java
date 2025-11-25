package com.jdbcproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class EmployeeDAO {
	
	//DAO - Data Access Object
	//CRUD operations
	//Employee - record representation
	//addEmp - query - insert, delete...
	//define various methods to carryout the crub operations
	//this class encapsulates all jdbc interaction for the employee table
	
	//statement, preparedStatement, 
	
	//preparedStatement
	
	//insert employee method
	public void addEmployee(Employee emp) {
		String sql_i = "INSERT INTO employee(name, email, is_active, salary, hire_date) values (?,?,?,?,?)";
		//? - placeholder -- dynamic query 
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_i)){//precompile sql query and store 
		
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getEmail());
				ps.setBoolean(3, emp.isActive());
				ps.setBigDecimal(4, emp.getSalary());
				ps.setDate(5, Date.valueOf(emp.getHireDate()));
				
				//executeUpdate() - insertion
				int rows = ps.executeUpdate(); //return how many rows affected, resultSet also
				if (rows > 0) {
					System.out.println("Employee inserted successfully");
				}else {
					System.out.println("Insertion failed");
				}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//update employee method
	public void updateEmployee(Employee emp) {
		
		String sql_u = "UPDATE employee SET name=?, email=?, is_active=?, salary=?, hire_date=? where id=?";
		
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql_u)){
				
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getEmail());
				ps.setBoolean(3, emp.isActive());
				ps.setBigDecimal(4, emp.getSalary());
				ps.setDate(5, Date.valueOf(emp.getHireDate()));
				ps.setInt(6,  emp.getId());
				
				int rows = ps.executeUpdate(); 
				if (rows > 0) {
					System.out.println("Employee updated successfully");
				}else {
					System.out.println("Updation failed");
				}
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	// delete employee method
	// sql_d = "delete from employee where id=?" 
	public void deleteEmployee(int id) {
		
		String sql_d = "delete from employee where id=?";
		
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql_d)){
				
				ps.setInt(1,id);
				
				int rows = ps.executeUpdate(); 
				if (rows > 0) {
					System.out.println("Employee deleted successfully");
				}else {
					System.out.println("Deletion failed");
				}
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//read all data
	
	public List<Employee> readEmployee() {
		
		List<Employee> list = new ArrayList<>();
		
		String sql_r = "select * from employee";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_r);
				ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) { //rs, 5th row 
				Employee emp = new Employee (
						rs.getString("name"),
						rs.getString("email"),
						rs.getBoolean("is_active"),
						rs.getBigDecimal("salary"),
						rs.getDate("hire_date") != null ? rs.getDate("hire_date").toLocalDate() : null
				);
				emp.setId(rs.getInt("id"));
				list.add(emp);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}
	
	
	//get employee by id
	
	public Employee readEmployeeById(int id) {
		
		String sql_r2 = "select * from employee where id = ?";
		Employee emp = null;
		
		
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_r2);
				){
			
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp = new Employee(
					
					rs.getString("name"),
					rs.getString("email"),
					rs.getBoolean("is_active"),
					rs.getBigDecimal("salary"),
					rs.getDate("hire_date")!= null ? rs.getDate("hire_date").toLocalDate() : null
					);
				emp.setId(rs.getInt("id"));
					}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return emp;
		
	}
	
	
	//Statement Interface
	
	//execute DDL statement - create
	//import java.sql.Statement;
	
	public void createTableDepartment() {
		String sql_create = "create table if not exists Department (\n"+
							" dept_id int auto_increment primary key, \n"+
							" dept_name varchar(30) not null, \n"+
							"dept_head varchar(30) not null \n"+
							")";
		
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
						)
		{
			stat.execute(sql_create);
			System.out.println("create statement executed successfully.");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//admin - maintenance db task
	//mysql - analyze table employee
	//		- optimize table employee
	
	public void adminTasks() {
		String sql1 = "analyze table employee";
		String sql2 = "Optimize table employee";
		
		try (Connection conn = DBUtil.getConnection();
				Statement stat = conn.createStatement()
				)
		{
			stat.execute(sql1);
			stat.execute(sql2);
			System.out.println("Admin maintenance tasks completed");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// callableStatement - call get_salary_by_d
	
	public BigDecimal getSalaryById(int empid) {
		
		String sql_sp = "{call get_salary_by_id (?, ?)}";
		BigDecimal salary = null;
		
		try(Connection conn = DBUtil.getConnection();
				CallableStatement cs = conn.prepareCall(sql_sp)
						)
		{
			
			//set in parameter
			cs.setInt(1, empid);
			
			
			//register out parameter
			cs.registerOutParameter(2, java.sql.Types.DECIMAL);
			
			//execute cs
			cs.execute();
			
			salary = cs.getBigDecimal(2);
			if(salary != null) {
				System.out.println("Employee ID : "+empid+ " has salary : "+salary);
			}else {
				System.out.println("No record found for ID: "+empid);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return salary;
	}
	
	//RowSet
	
	//CachedRowSet
	
	public void fetchEmployeesBySalary(BigDecimal minSalary, BigDecimal maxSalary) {   //salary range - min and max
		
		String sql_crs = "select id, name, email, salary, hire_date from employee where salary between ? and ?";
		
		try(// Connection conn = DBUtil.getConnection();
				CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet()
						){
			
			//set conn directly 
			crs.setUrl("jdbc:mysql://localhost:3306/ems_db");
			crs.setUsername("root");
			crs.setPassword("Genpact@123456789");
			
			//set sql commands and parameters
			crs.setCommand(sql_crs);
			crs.setBigDecimal(1,  minSalary);
			crs.setBigDecimal(2, maxSalary);
			
			//execute query
			//rowset connect, fetch data and then disconnect
			crs.execute();
			
			System.out.println("Employees with salary between : "+ minSalary+ " and "+maxSalary);
			
			//iterate over the results in cache rowset
			while (crs.next()) {
				int id = crs.getInt("id");
				String name = crs.getString("name");
				String email = crs.getString("email");
				BigDecimal salary = crs.getBigDecimal("salary");
				java.sql.Date hire_date = crs.getDate("hire_date");
				System.out.println(id + "    "+name+"    "+email+"    "+salary+"    "+hire_date);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//FilterRowSet
	//Predicate - created filter
	
	public void fetchActiveEmployees() {  
			
			String sql_frs = "select id, name, email, is_active from employee ";
			
			try(// Connection conn = DBUtil.getConnection();
					FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet()
							)
			{
				
				//set conn directly 
				frs.setUrl("jdbc:mysql://localhost:3306/ems_db");
				frs.setUsername("root");
				frs.setPassword("Genpact@123456789");
				
				//set sql commands and parameters
				frs.setCommand(sql_frs);
				
				//execute query
				//rowset connect, fetch data and then disconnect
				frs.execute();
				
				//apply filter
				//create an object of activeEmployeeFilter
				ActiveEmployeesFilter filter = new ActiveEmployeesFilter();
				frs.setFilter(filter);
				
				System.out.println("Active employees: ");
				
				
				while (frs.next()) {
					int id = frs.getInt("id");
					String name = frs.getString("name");
					String email = frs.getString("email");
					boolean active = frs.getBoolean("is_active");
					System.out.println(id + "    "+name+"    "+email+"    "+active);
				}
				
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	
	
	//JoinRowSet  - joins the two rowsets based on common column - dept_id
	
	//employee and department
	//employee - dept_id added
	
	//sql1 = select id, name, email, dept_id from employee
	//sql2 = select dept_id, dept_name, dept_head from department
	
	//CachedRowSet - sql1
	//CachedRowSet - sql2
	
	
	//JoinRowSet
	//jrs.addRowSet(emp_rs,"dept_id")
	//jrs.addRowSet(dept_rs, "dept_id")
	
	//modify employee table - include column dept_id
	//insert rows in department 
	//create 4 depts - hr, it, finace, sales
	//add foreign constraint - dept_id

	
	//update rows - add dept_id for each row
	
	public void fetchEmployeeDepartmentJoin() {
		
		try {
			
			//cached row sets
			CachedRowSet empRS = RowSetProvider.newFactory().createCachedRowSet();
			CachedRowSet deptRS = RowSetProvider.newFactory().createCachedRowSet();
			
			//set connection properties
			empRS.setUrl("jdbc:mysql://localhost:3306/ems_db");
			empRS.setUsername("root");
			empRS.setPassword("Genpact@123456789");
			
			deptRS.setUrl("jdbc:mysql://localhost:3306/ems_db");
			deptRS.setUsername("root");
			deptRS.setPassword("Genpact@123456789");
			
			//set sql commands
			empRS.setCommand("SElect id, name, email, dept_id from employee");
			deptRS.setCommand("select dept_id, dept_name, dept_head from department");
			
			//execute these rowsets
			empRS.execute();
			deptRS.execute();
			
			//create join rowset
			JoinRowSet joinRS = RowSetProvider.newFactory().createJoinRowSet();
			
			//add both rowsets with common column to join rowsets
			joinRS.addRowSet(empRS,"dept_id");
			joinRS.addRowSet(deptRS,"dept_id");
			
			System.out.println("Employee Department Join: ");
			
			while(joinRS.next()) {
				
				int id = joinRS.getInt("id");
				String name = joinRS.getString("name");
				String email = joinRS.getString("email");
				int dept_id = joinRS.getInt("dept_id");
				String dept_name = joinRS.getString("dept_name");
				String dept_head = joinRS.getString("dept_head");
				
				System.out.println(id+" "+name+ " "+email+ " "+dept_id+" "+dept_name+" "+dept_head);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

	
	//ResultSetMetaData
	
	//show emp table - meta data
	
	public void showEmployeeTableMetaData() {
		String sql_md = "select * from employee";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_md);
				ResultSet rs = ps.executeQuery())
		{
			//get the metdata object
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//get the number of columns
			int colCount = rsmd.getColumnCount();
			System.out.println("Total columns : "+colCount);
			
			//Print detailed information of each column
			for(int i =1; i<=colCount; i++) {
				
				System.out.println("Column "+i+" : ");
				System.out.println("Name "+rsmd.getColumnName(i));
				System.out.println("Type : "+rsmd.getColumnTypeName(i));
				System.out.println("Size : "+rsmd.getColumnDisplaySize(i));
				System.out.println("Table : "+rsmd.getTableName(i));
				System.out.println("Nullable : "+rsmd.isNullable(i));
				System.out.println("Auto increment : "+rsmd.isAutoIncrement(i));
				System.out.println("---------------------------------------");
				
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//create method to getmetadata about database
	
	public void showDatabaseMetadata() {
		
		try(Connection conn = DBUtil.getConnection()){
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Database Metadata : ");
			
			System.out.println("Database Product : "+dbmd.getDatabaseProductName());
			System.out.println("Database Version : "+dbmd.getDatabaseProductVersion());
			System.out.println("Driver Name : "+dbmd.getDriverName());
			System.out.println("Driver Version : "+dbmd.getDriverVersion());
			System.out.println("Database Username : "+dbmd.getUserName());
			
			
			//List all tables in database
			
			ResultSet tables = dbmd.getTables(null, null, "%", new String[] {"TABLE"});  //return resultset
			
			while(tables.next()) {
				String tableName = tables.getString("TABLE_NAME");
				System.out.println("Table : "+tableName);
			}
			
			//Display primary keys
			
			
			ResultSet pk = dbmd.getPrimaryKeys(null, null, "employee");
			
			while(pk.next()) {
				System.out.println("Primary key column: "+pk.getString("COLUMN_NAME"));
			}
			
	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//two methods to add image
	
	//1. update profile_pic and last login - id=?  ------   input pic
	public void updateProfilePicAndLastLogin(int empid, String imagePath, LocalDateTime loginTime) {
		
		String sql = "update employee set profile_pic = ?, last_login = ? where id = ?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				FileInputStream fis = new FileInputStream(new File(imagePath))){
			
			//set the blob data (profile_pic)
			
			ps.setBinaryStream(1, fis, (int) new File(imagePath).length());   // calculate number of bytes
			
			//set timestamp - lastlogin
			ps.setTimestamp(2, Timestamp.valueOf(loginTime));
			
			//set empid
			ps.setInt(3, empid);
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Employee with id : "+empid+" updated successfully.");
			}else {
				System.out.println("Update for amployee id : "+empid+" failed.");
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//get the data - profile pic
	
	public void fetchProfilePic(int empid, String outputPath) {
		
		String sql = "select profile_pic from employee where id = ?";
		
	    try(Connection conn = DBUtil.getConnection();
	    		PreparedStatement ps = conn.prepareStatement(sql);
	    		){
	    	
	    	ps.setInt(1, empid);
	    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
	    		// read the binary stream from profile pic column
	    		InputStream is = rs.getBinaryStream("profile_pic");   //get in bytes
	    		if (is == null) {  //is=null, when for id there is no profile pic
	    			System.out.println("No profile picture found for id : "+empid);
	    			return;
	    		}
	    		
	    		// store in some path using FileOutputStream
		    	FileOutputStream fos = new FileOutputStream(outputPath);
		    	byte[] buffer = new byte[1024];    //byte array buffer
		    	//buffer holding chunk of data of size 1024 bytes
		    	
		    	int bytesRead;     // store how many bytes were read into buffer
		    	while((bytesRead = is.read(buffer))!=-1) {    // != -1, no more data, is.read returns -1
		    		//keep on reading from input stream till -1 is not returned
		    		//is.read(buffer) - read from is into buffer
		    		//fill buffer up to buffer .length(1024) bytes
		    		//and returning how many bytes are read
		    		//buffer[0]
		    		
		    		fos.write(buffer, 0, bytesRead);    //write bytes from buffer into output file
		    	}
		    	
		    	is.close();
		    	fos.close();
		    	System.out.println("Profile pic retrieved and saved at path : "+outputPath);
	    	}else {
	    		System.out.println("Employee with id : "+empid +" not found");
	    		
	    	}
	    	
	    }catch(SQLException e) {
	    	System.out.println(e.getMessage());
	    }catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
		
	}
	
	

}
