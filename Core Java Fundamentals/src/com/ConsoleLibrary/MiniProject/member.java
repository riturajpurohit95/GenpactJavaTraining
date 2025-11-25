package com.ConsoleLibrary.MiniProject;

import java.util.ArrayList;
import java.util.List;

public abstract class member {

		//constructor
		public member(String memberId, String name, List<String> borrowedBooks) {
			this.memberId = memberId;
			this.name = name;
			this.borrowedBooks = borrowedBooks;
		}
		
		protected String memberId;
		protected String name;
		protected List<String> borrowedBooks = new ArrayList<>();//List<String> borrowedBooks → stores ISBNs of borrowed books;
		
		//getters and setters
		public String getMemberId() {
			return memberId;
		}

		public String getName() {
			return name;
		}

		public List<String> getBorrowedBooks() {
			return borrowedBooks;
		}

//		public void setMemberId(String memberId) {
//			this.memberId = memberId;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public void setBorrowedBooks(List<String> borrowedBooks) {
//			this.borrowedBooks = borrowedBooks;
//		}
		
		
		//abstract
		public abstract int getMaxBooksAllowed();
		
		//concrete 
		public void borrowBook(String isbn) {
			borrowedBooks.add(isbn);			
		}
		
		public void returnBook(String isbn) {
			borrowedBooks.remove(isbn);
			
		}

		@Override
		public String toString() {
			return "member [memberId=" + memberId + ", name=" + name + ", borrowedBooks=" + borrowedBooks + "]";
		}

		

}
