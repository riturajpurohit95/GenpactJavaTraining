package com.ConsoleLibrary.MiniProject;


import java.util.ArrayList;
import java.util.List;

public class libraryApp{
	
	private List<book> books = new ArrayList<>();
	private List<member> members = new ArrayList<>();
	
	public void addBook(book b) {
		books.add(b);
	}
	
	public void addMember(member m) {
		members.add(m);
	}
	
	public void showAllBooks() {
		books.forEach(System.out::println);
	}
	
	private member findMember(String memberId) {
		return members.stream()
				.filter(m -> m.getMemberId().equals(memberId))
				.findFirst()
				.orElse(null);
		}
	
	private book findBook(String isbn) {
		return books.stream()
				.filter(b -> b.getIsbn().equals(isbn))
				.findFirst()
				.orElse(null);
	}
	
	public void borrowBook(String isbn, String memberId) 
			throws booksNotAvailableException, maxLimitExceedException{
			member m = findMember(memberId);
			book b = findBook(isbn);
			
			if(b==null) throw new booksNotAvailableException("Book not found");
			
			borrowRule rule = (mem, bk)-> bk.getAvailableCopies() >0 && mem.getBorrowedBooks().size() < mem.getMaxBooksAllowed();
			
			if(!rule.canBorrow(m, b)) {
				if(b.getAvailableCopies() <= 0) throw new booksNotAvailableException("book not available for borrowing");
			
				else throw new maxLimitExceedException("borrowing limit exceeded");
			}
			
			m.borrowBook(isbn);
			b.borrow();
			System.out.println(m.name+" borrowed "+b.getTitle());
		
	}
	
//	public void borrowBook(String isbn, String memberId) {
//		member m = findMember(memberId);
//		book b = findBook(isbn);
//		
//		m.borrowBook(isbn);
//		System.out.println(m.name+" borrowed "+b.getTitle());
//		
//	}
	
	public void returnBook(String isbn, String memberId) throws invalidReturnException{
		member m = findMember(memberId);
		book b = findBook(isbn);
		
		if(! m.getBorrowedBooks().contains(isbn)) throw new invalidReturnException("this book was not borrowed by "+m.getName());
		
		m.returnBook(isbn);
		b.returned();
		System.out.println(m.getName()+" returned "+b.getTitle());
		
	}
	
	public void searchBooks(String keyword) {
		System.out.println("Search result: ");
		books.stream()
			.filter(b-> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
			.limit(1)
			.forEach(System.out::println);
		
	}
	
	public void showTopBorrowedBooks() {
		System.out.println("Top borrowed books: ");
		books.stream()
			.sorted((b1,b2)-> Integer.compare(b2.getTimesBorrowed(), b1.getTimesBorrowed()))
			.limit(1)
			.forEach(System.out::println);
		
	}

}
