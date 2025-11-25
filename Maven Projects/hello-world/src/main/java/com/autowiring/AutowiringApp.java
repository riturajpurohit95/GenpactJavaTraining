package com.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config2.xml");
		
//		System.out.println("consumerByName");
		
//		ConsumerBySetter c1 = (ConsumerBySetter) context.getBean("consumerByName");
//		c1.run();
		
		
//		System.out.println("consumerByType");
//		
//		ConsumerBySetter c2 = (ConsumerBySetter) context.getBean("consumerByType");
//		c2.run();
		
		
		System.out.println("consumerByConstructor");
		
		ConsumerByConstructor c3 = (ConsumerByConstructor) context.getBean("consumerByConstructor");
		c3.run();
	}

}
