package com.day12.javafileio;

public class JDBCDrivers {
	
	//JDBC defines 4 types of drivers
	//- based on how they communicate with database
	
	//type 1
	//- named as - jdbc-odbc bridge driver
	//- convert jdbc calls into odbc calls
	//- requires odbc driver installation/ connection
	//- not used anymore
	//- obsolete now
	//odbc - open database connectivity 
	//- microsoft standard api - accessing relational databases
	//- platform dependent
	
	
	//type 2
	//- native api drivers
	//- uses native client librabries
	//- oracle - oci to communicate with databases
	//- platform specific
	//- convert jdbc calls into native api calls of db client
	//- java app - jdbc api - type 2 driver (java + native code) - db's native clietn library (like oracle oci) - db
	//- oracle db - type 2 - oracle.jdbc.driver.oracleDriver
	//- oci - oracle call interface
	
	
	//type 3
	//- network protocol driver
	//- acts a middle layer n/w driver b/w java app and db
	//- instead of directly connecting to db, communicate with middleware(app server)
	//- actually handles the actual db connection
	//- java app -> jdbc api -> type 3 driver -> middle server(translate call to db protocol) -> db
	//- web app java - connect to db in a diff n/w 
	//- clients - instead of direct access - use type 3 driver
	//- send db ro to middleware server - weblogic, ibm webshpere -
	//- platform independent
	
	//type 4
	//- pure java driver
	//- thin driver
	//- most widely used driver
	//- jdbc call into db protocol - no need of native libraries, middleware
	//- thin - eliminates all extra translation layers - no odbc, no native api, no middleware
	//- java app - jdbc api - type 4 driver - db
	
	
	//mysql driver - >   com.mysql.cj.jdbc.driver - type 4 driver
	//direct db connection, easy deployment, hifh performance, support all dbs
	//mysql, post

}
