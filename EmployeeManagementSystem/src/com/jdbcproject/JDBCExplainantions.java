package com.jdbcproject;

public class JDBCExplainantions {
	
	//Statements, PreparedStatement
	
	//statement -> interface - 
	//crud operations - send SQL commands to the database
	//statement - interface used to execute static SQL queries
	//static - query is fixed and doesnot accept parameters
	//executeQuery(sql) - method return resultSet - select
	//executepdate(sql) - method used to insert, update, delete
	//simple one time queries 
	
	//PreparedStatement 
	//used for dynamic or parameterized queries
	//query can accept parameters
	//input values from user
	//sql query - precompiled once - can be used multiple times
	//repeated executions
	
	//Statement:
	//- Run static SQL queries 
	//- queries that do not include user input
	//- no placeholder
	//- DDL, select * from employee, 
	//- admin related queires - 
	//- create dept table 
	
	
	//CallableStatement interface
	//- MySQL - stored procedures - function
	//- used for stored procedures
	//- used to call stored processes that are created and stored inside db - mysql
	
	//Stored procedure
	//function - set of statements
	//fetch emp salary by id
	//sql query -
	//create a stored procedure for this - function (java)
	//fetch emp salary by id - call sp (3)
	
	
	//select - executed query - all employees - resultSet
	//keeps the connection open while reading data
	
	//RowSet interface - 
	//updated version of resultSet
	//javax.sql - package - extension of java.sql package
	//types of rowset:
	//subinterfaces
	//cached , jdbc, filter, join, web - RowSets
	
	
	//JDBCRowSEt - wrapper around ROowSet - connected RowSet - keeps the connection open while reading
	
	//CachedRowSet - disconnected rowSet
	//			   - can be modified offline - changes updates
	//			   - disconnects the connection and then changes are made offline
	//			   - later we can synchronize with database
	
	
	//FilterRowSet - CachedRowSe with filterting capability
	//				- based on condition - subset of rows
	
	//JoinRowSet - used to join two or more RowSet in memory w/o using SQL join
	//				 - employee, dept
	//				 - join the results from employee rowset and dept rowset
	
	
	//WebRowSet - XML based rowset - can read/write xml format for data interchange
	
	//why?
	//to work offline with data
	//update data in memory
	//sync back later
	//filter join
	//web servise - send data over network
	//scrollable - forward/ backword easily
	
	//ResultSetMetaData -    get emta data about the columns
	//- db reports - tool, db inspection utility
	//- an interface
	//- metadata - data about data
	//- columns count
	//- names of columns
	//- types of cols
	
	//Fetch db metadata
	//database level details
	//- db version, db name,
	//- list of tables in db,
	//- stored procedure, primary keys
	//- report generation, documentation
	
	
	//project:
	//creating tables to inserting data to updation to deletions
	// all these should be done via jdbc api
	
	//Interoperability between jdbc and mysql data types
	//- when java communication with mysql through jdbc
	//- both system - use different data representations
	//- java- java.lang, java.sql
	//- int, float, double, string
	//- mysql: int, varchar, date, decimal
	//- jdbc - provides a mapping layer - ensures type capability
	//- ensure data consistency
	//- prevent type mismatch errors - insert, select, updated
	//- preparedstatement,resultset - setint, getint
	//- mysql type			equivalent java type		setXXX, getXXX()
	//- int, integer		int							setInt, getInt
	//- bigint				long - long int				setlong, getlong
	//- smallint			short, byte					setshort, getshort
	//- tiyint				
	//- real				float
	//- float
	//- decimal				double
	//- char, varchar		String
	//- time				java.sql.time
	//- datetime			
	//- timestamp			java.sql.timestamp
	//- blob				java.sql.blob
	//- boolean				boolean
	

	//employee - profile_pic = NULL - longblob
	//last_login - timestamp - date and time both
	
	
	//last_login - simply add using timestamp
	//profile_pic - binary object
	
	//files concept - 
	//image -  image path
	
	//add image
	//- create a File object in java - give image path
	//- File is predefined class in java - work with binary data
	//- input - FileinputStream - create a file object with image path as input
	
	//retrieve image
	//- File output stream - get the image from the SQL table and we store it in some path
	
}
