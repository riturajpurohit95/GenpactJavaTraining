package com.day12.javafileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializedApp {

	public static void main(String[] args) {
		
		
		try(ObjectInputStream ois = new ObjectInputStream
									(new FileInputStream("C:\\JavaTraining\\employee.ser.txt"))
									){
			Employee emp = (Employee) ois.readObject();
			
			System.out.println("Deserialization done");
			System.out.println(emp.empid);
			System.out.println(emp.name);
			System.out.println(emp.salary);
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
