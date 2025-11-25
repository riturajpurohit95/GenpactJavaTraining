package com.day1.basics;


	
		import java.util.Scanner;
		 
		 
		public class Arrays {
		 
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				// array - collection of homogeneous values
				// store multiple values of same type 
				//declare an array
				// datatype[] = new  datatype[size];
				Scanner sc = new Scanner(System.in);
//				int marks[] = new int[5]; // declared array int type of size 5
//				
//				//index 
//				//starts from 0
//				
//				System.out.println(marks.length);
//				
//				int sum = 0;
//				for (int i=0; i<marks.length ; i++) {
//				System.out.println("enter marks in subject" + (i+1)+ ":");
//					marks[i] = sc.nextInt();
//				    sum += marks[i];
//				}
//				//average marks of student
//				double average = sum / marks.length;
//				System.out.println("total marks:" + sum);
//				System.out.println("average marks:" + average);
//				

				//3Darray 
//				| 20 30 40 44 | ->R1
//				| 23 45 78 79 | ->R2
//				| 23 78 90 98 | ->R3
//				int[][] sales_data = new int[3][4];
//				
//				//input sales value 
//				
//				for(int i=0; i<sales_data.length; i++) { //number of rows
//					for(int j=0 ; j<sales_data[i].length; j++) {
//						System.out.println("enter sales for store " + (i+1) + " for day" + (j+1) + ":");
//						sales_data[i][j] = sc.nextInt ();
//						}
//				}
//				for(int i=0; i<sales_data.length; i++) { //number of rows - handling stores
//					for(int j=0 ; j<sales_data[0].length; j++) 
//					{
//						System.out.print(sales_data[i][j] + "\t" ); // no of columns - handling days of each sales 
//						}
//					System.out.println();
//				}
//				//calculate total sales per store 
//				
//				
//				for(int i=0; i<sales_data.length; i++) {
//					int sum = 0;
//					for(int j = 0; j<sales_data[0].length; j++) {
//						sum = sum+ sales_data[i][j];
//						
//					}
//					System.out.println("store" + (i+1) + ":" + sum);
//					
//				}
				// jagged array - 2D array rows of different length
				int[][] jaggedarray = new int[3][];
				 // individual initialsation 
				jaggedarray[0] = new int[4];
				jaggedarray[1] = new int[2];
				jaggedarray[2] = new int[3];
				for(int i=0; i<jaggedarray.length; i++) { //number of rows
					for(int j=0 ; j<jaggedarray[i].length; j++) {
						System.out.println("enter sales for store " + (i+1) + " for day" + (j+1) + ":");
						jaggedarray[i][j] = sc.nextInt ();
						}
				}
				for(int i=0; i<jaggedarray.length; i++) { //number of rows - handling stores
					for(int j=0 ; j<jaggedarray[i].length; j++) 
					{
						System.out.print(jaggedarray[i][j] + "\t" ); // no of columns - handling days of each sales 
						}
					System.out.println();
				}


				sc.close();

				}
		 
			}


