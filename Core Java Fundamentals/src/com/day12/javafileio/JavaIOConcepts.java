package com.day12.javafileio;

public class JavaIOConcepts {
	
	
	//JAVA io
	//- java io and console i/o
	//- file i/o and console i/o
	//- serialization and desertalization
	// JDBC arch and drivers
	
	//java i/o
	//- mechanism throw whihch java applications read data from sources - like files, keyboard
	//- write data to destination - like files, console
	
	
	//streams
	//- stream represents a sequence of data
	// byte stream - handle binary data (images, audio, pdf)
	//				- classes - inputstream - used for reading data
	//							- outputstream - used for writing data
	//							- fileinputstream - used to read from file - image
	//							- fileoutputstream

	
	// character stream - handle textual data - classes - reader, writer, filereader, filewriter
	
	//file i/o 
	//- read from and write to files using streams
	
	
	
	//serialization and deserialization:
	
	//- serialization :
	//- process of converting an object into a byte stream
	//					- employee -> some object
	//-> send it over a netwrok - data is send using bytes
	//-> save object state in some db or file
	
	//- deserialization :
	//- reverse process 
	//- we have a byte stream -> amployee byteStream -> convert back to an object
	//- process of reconstructing the object from the  byte stream
	
	
	//- over a network - send employee using byte stream
	//- recieved - back to object
	
	//- implement - > interface -> java.io -> serializable interface 
	
	
	//JDBC arcitecture
	// JDBC API -
	//JDBC driver manager - acts as a bridge b/w app and drivers
	//sql server, oracle, data source
}
