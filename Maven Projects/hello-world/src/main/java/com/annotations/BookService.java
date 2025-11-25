package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//tell spring this is a service bean (emailService, smsService-just like that)
@Service
public class BookService {
	
	
	//spring - automatically inject dependency byType
	@Autowired
	private BookRepository bookRepository;
	
	public void displayBook() {
		System.out.println("Book Title: "+bookRepository.getBookTitle());
	}

}
