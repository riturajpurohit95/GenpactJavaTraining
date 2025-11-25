package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)

public class CalculatorAspect {
	
	//code - hoe logging along side business logic
	
	//define a pointcut
	@Pointcut("execution(public * com.aop.CalculatorService.*(..))")
	public void calculatorMethods() {}
	
	//advises - for all matching methods- add(), divide()
	
	@Before("calculatorMethods()")
	public void before(JoinPoint jp) {
		System.out.println("[AOP-BEFORE] Calling: "+jp.getSignature().toShortString());
	}
	
	//run before the target method executes
	//joinpoint represents the current method
	//print the method name - jp.signature...
	
	
	@Around("calculatorMethods()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			System.out.println("[AOP-AROUND] Starting: "+pjp.getSignature().toShortString());
			Object result = pjp.proceed();
			long time = System.currentTimeMillis() - start;
			System.out.println("[AOP_AROUND] Completed: "+time+" ms "+pjp.getSignature().toShortString());
			return result;
		}catch(Throwable e) {
			long time = System.currentTimeMillis() - start;
			System.out.println("[AOP_AROUND] Threw after: "+time+" ms "+e.getClass().getSimpleName());
			throw e;
		}
		
	}
	
	@AfterReturning(pointcut="calculatorMethods()",returning="ret")
	public void afterReturning(JoinPoint jp, Object ret) {
		System.out.println("[AOP-AFTER_RETURNING] "+jp.getSignature().toShortString()+" returned: "+ret);
	}
	
	@AfterThrowing(pointcut="calculatorMethods()",throwing="ex")
	public void afterThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("[AOP-AFTER-THROWING "+jp.getSignature().toShortString() +" threw: "+ex.getClass().getSimpleName()+" - "+ex.getMessage() );
	}
	
	@After("calculatorMethods()")
	public void afterFina(JoinPoint jp) {
		System.out.println("[AOP-AFTER]: "+jp.getSignature().toShortString());
	}

}
