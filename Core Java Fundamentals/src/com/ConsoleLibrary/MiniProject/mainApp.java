package com.ConsoleLibrary.MiniProject;

import java.util.ArrayList;
//import java.util.Arrays;

public class mainApp {

	public static void main(String[] args) {
		
		libraryApp l = new libraryApp();
		
		member m1 = new studentMember("m01", "Ritu", new ArrayList<>());
		member m2 = new staffMember("m02", "Anchal", new ArrayList<>());
		member m3 = new studentMember("m03", "Garima", new ArrayList<>());
		//member m2 = new staffMember("m02", "Anchal", Arrays.asList("b02"));
		
		l.addMember(m1);
		l.addMember(m2);
		l.addMember(m3);
		
		book b1 = new book("b01", "To Kill Mockingbird", "Harper Lee", "Classic Fiction", 1);
		book b2 = new book("b02", "1984", "George Orwell", "Dystopian Fiction", 150);
		book b3 = new book("b03", "To Kite Runner", "Khaled Husseini", "Historical Fiction", 200);
		
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		
		
		try {
			l.borrowBook("b01", "m01");
			l.borrowBook("b02", "m02");
			l.borrowBook("b03", "m03");
			l.borrowBook("b01", "m03");//fails
		}catch (Exception e){
				System.out.println(e.getMessage());
		}
		
		try {
			l.returnBook("b03", "m01");
			l.returnBook("b03", "m03");
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		//search books
		l.searchBooks("1984");
		
		//top borrow books
		l.showTopBorrowedBooks();
		
		//fine - lambda
		fineCalculator fine = days -> days * 2.0;
		int lateDays = 5;
		System.out.println("fine for "+lateDays+" days late : Rs "+fine.calculateFine(lateDays));
		
		//all books
		System.out.println("All books: ");
		l.showAllBooks();
		
		
		
		

	}

}
