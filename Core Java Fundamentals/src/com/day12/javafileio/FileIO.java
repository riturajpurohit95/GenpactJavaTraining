package com.day12.javafileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
//		
//		//read a file using byte stream
////		try(FileInputStream fis = new FileInputStream("data.txt")){  //no path is provided so it assumes file to be in default workspace
//		
//		try(FileInputStream fis = new FileInputStream("C:\\Users\\703438507\\Desktop\\profile_pic_image1.webp")){ 
//			//fis -> read bytes from a file
//			//read() -> return one byte at a time
//			//-1 -> end of the file
//			
//			int i;
//			while((i = fis.read())!= -1) {
//				System.out.print((char) i);  //typcaste
//			}
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
//
	//write to a file
//	String data = "writing to a file.";
//	
//	try(FileOutputStream fos = new FileOutputStream("data.txt")){
//		fos.write(data.getBytes());
//		System.out.println("data written successfully");
//	}catch(IOException e) {
//		System.out.println(e.getMessage());
//	}
//
//	
	
	
	//read and write using character stream
	
	//write some content
	
//	try(FileWriter fw = new FileWriter("data.txt")){
//		fw.write("writting to a file using character stream");
//	}catch(IOException e) {
//		System.out.println(e.getMessage());
//	}
//	
//	//read and print in console
//	try (FileReader fr = new FileReader("data.txt")){
//		int ch;
//		while((ch = fr.read()) != -1) {
//			System.out.print((char) ch);
//		}
//	}catch(IOException e) {
//		System.out.println(e.getMessage());
//	}
//	
		
	//appending data to file, not overwriting
//	try(FileWriter fw = new FileWriter("data.txt",true)){
//		fw.write("appending to a file using character stream.");
//	}catch(IOException e) {
//		System.out.println(e.getMessage());
//	}
		
		
	
	}

}
