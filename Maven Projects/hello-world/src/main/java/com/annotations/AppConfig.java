package com.annotations;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.annotations")
//public class AppConfig {
//	
//	
//
//}

public class AppConfig{
	
	//define beans manually
	//called as java based configuration
	
	@Bean
	public BookRepository bookRepository() {
		return new BookRepository();
	}
	
	@Bean
	public BookService bookService() {
		return new BookService();
	}
	
	//defined beans manually instead of component scan
	//replaced config.xml file 
	
}


