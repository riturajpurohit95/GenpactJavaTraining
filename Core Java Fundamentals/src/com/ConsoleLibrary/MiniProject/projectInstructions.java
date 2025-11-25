package com.ConsoleLibrary.MiniProject;

public class projectInstructions {
	
//	Mini Project: Library Book Management
//
//	Create a simple console-based Java program to manage library books and members using:
//
//	· OOP concepts (Encapsulation, Inheritance, Polymorphism, Abstraction)
//
//	· Relationships (Association, Aggregation, Composition)
//
//	· Collections (List, Map, Set)
//
//	· Streams & Lambda expressions
//
//	· Custom Exceptions
//
//	· Functional Interfaces
//
//	Classes and Interfaces to Create
//
//	Book
//
//	Purpose: Represents a book in the library.
//
//	Fields:
//
//	· String isbn
//
//	· String title
//
//	· String author
//
//	· String category
//
//	· int totalCopies
//
//	· int availableCopies
//
//	Member (abstract class)
//
//	Purpose: Base class for all types of library members.
//
//	Fields:
//
//	· String memberId
//
//	· String name
//
//	· List<String> borrowedBooks → stores ISBNs of borrowed books
//
//	Methods:
//
//	· Abstract: int getMaxBooksAllowed()
//
//	· Concrete: void borrowBook(String isbn) and void returnBook(String isbn)
//
//	StudentMember (extends Member)
//
//	Purpose: Represents a student user. Overrides: getMaxBooksAllowed() → return 3
//
//
//	StaffMember (extends Member)
//
//	Purpose: Represents a staff user. Overrides: getMaxBooksAllowed() → return 5
//
//	FineCalculator (Functional Interface)
//
//	Purpose: Used to calculate fine dynamically using a lambda expression. Use:
//
//	FineCalculator fine = days -> days * 2.0; // ₹2 per day fine
//
//	BorrowRule (Functional Interface)
//
//	Purpose: Checks if a member can borrow a book.
//
//	Library
//
//	Purpose: Main class holding books and members, and handling all actions.
//
//	Fields:
//
//	· List<Book> books
//
//	· List<Member> members
//
//	Methods:
//
//	· void addBook(Book b)
//
//	· void addMember(Member m)
//
//	· void showAllBooks()
//
//	· void borrowBook(String isbn, String memberId)
//
//	· void returnBook(String isbn, String memberId)
//
//	· void searchBooks(String keyword) → use Streams with filter() and map()
//
//	· void showTopBorrowedBooks() → use Streams and sorted()
//
//
//	Custom Exceptions
//
//	Purpose: Handle invalid operations gracefully.
//
//	Create:
//
//	1. BookNotAvailableException
//
//	2. MaxLimitExceededException
//
//	3. InvalidReturnException
//
//	Concept: Demonstrates Exception Handling with throw and try-catch.
//
//
//	MainApp (main class)
//
//	Purpose: Entry point — creates sample books and members, and calls Library methods.
//
//	Example tasks:
//
//	· Create 3 books, 3 members
//
//	· Borrow books (some success, some fail)
//
//	· Return a book (test exceptions)
//
//	· Search books by title (Streams + filter)
//
//	· Print results
//
//	Example Work Plan for Trainees
//
//	1. Create all 9 classes/interfaces listed.
//
//	2. In MainApp, create:
//
//	o 3–4 sample books
//
//	o 2–3 sample members (student/staff)
//
//	3. Borrow some books, handle exceptions.
//
//	4. Search books by title using Stream filter.
//
//	5. Display top borrowed book using Stream sorted + limit(1).
//
//	6. Display fines using lambda.

}
