package com.ConsoleLibrary.MiniProject;

public class book {
	
	 private String isbn;
	 private String title;
	 private String author;
	 private String category;
	 private int totalCopies;
	 private int availableCopies;
	 
	 private int timesBorrowed = 0;//to get topBorrowedBooks
	 
	 //constructor
	 public book(String isbn, String title, String author, String category, int totalCopies) {
		 this.isbn = isbn;
		 this.title = title;
		 this.author = author;
		 this.category = category;
		 this.totalCopies = totalCopies;
		 this.availableCopies = totalCopies;
	 }
	 
	//getters
		public String getIsbn() {
			return isbn;
		}
		
		public String getTitle() {
			return title;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getCategory() {
			return category;
		}
		
		public int getTotalCopies() {
			return totalCopies;
		}
		
		public int getAvailableCopies() {
			return availableCopies;
		}
		
		public int getTimesBorrowed() {
			return timesBorrowed;
		}
		
		//borrow
		public void borrow() {
			availableCopies--;
			timesBorrowed++;
		}
		//returned
		public void returned() {
			availableCopies++;
		}
	 
	//toString
	@Override
	public String toString() {
		return "book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + "]";
	}
	


	//setters
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public void setTotalCopies(int totalCopies) {
//		this.totalCopies = totalCopies;
//	}
//	public void setAvailableCopies(int availableCopies) {
//		this.availableCopies = availableCopies;
//	}
	 

}
