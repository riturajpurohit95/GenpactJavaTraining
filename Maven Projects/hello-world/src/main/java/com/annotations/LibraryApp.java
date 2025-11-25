package com.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService bs = context.getBean(BookService.class);
		bs.displayBook();
	}

}
