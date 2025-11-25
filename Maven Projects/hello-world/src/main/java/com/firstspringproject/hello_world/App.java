package com.firstspringproject.hello_world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        // Load spring Ioc Container
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	
    	// Retrieve the bean  from container
    	//HelloWorld obj = (HelloWorld) context.getBean("helloWorld"); // setter injection
    	
    	// use the bean
    	//obj.displayMessage();
    	
    	// Retrieve the bean  from container
    	//HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld2"); // constructor injection
    	
    	// use the bean
    	//obj2.displayMessage();
    	
    	//HelloWorld objAddr = (HelloWorld) context.getBean("helloWorldAddress");
    	//objAddr.displayMessage();
    	
    	HelloCollections objList = (HelloCollections) context.getBean("listBean");        //.getBean("listBean");
    	HelloCollections objSet = (HelloCollections) context.getBean("setBean");
    	HelloCollections objMap = (HelloCollections) context.getBean("mapBean");
    	
    	objList.displayAll();
    	System.out.println();
    	objSet.displayAll();
    	System.out.println();
    	objMap.displayAll();
    }
}

