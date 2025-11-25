package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			CalculatorService calc = context.getBean(CalculatorService.class);
			
			// cal add method
			System.out.println(calc.add(20,34));
			
			// cal divide 10,2
			System.out.println(calc.divide(10,2));
			
			System.out.println("--divide(10,0)--");
			try {
				calc.divide(10, 0);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
//			finally {
//			((AbstractApplicationContext) context).close();
//		}    --- context auto closes here so no need to write this 
	}

}
