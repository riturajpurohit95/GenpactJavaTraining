package com.day12.javafileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializedApp {

	public static void main(String[] args) {
		
		Employee emp = new Employee(101, "Ritu", 40000.00);

		// objectOutputStream - convert object into a byte stream
		//store it in some file  - employee.ser
		//FileOutputStream
		
//		try(ObjectOutputStream oos = new ObjectOutputStream
//										(new FileOutputStream("C:\\JavaTraining\\employee.ser.txt"))
//										){
//			
//			oos.writeObject(emp);
//			System.out.println("Serialization successful.");
//			
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
		
		
		
	}

}
