package com.annotations;

import org.springframework.stereotype.Repository;

//spring understands that this is a repository class
//bean resonsible for data access logic

@Repository
public class BookRepository {
	
	public String getBookTitle() {
		return "Spring Framework Concepts";
	}

}
