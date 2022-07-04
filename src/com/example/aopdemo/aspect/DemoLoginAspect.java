package com.example.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoginAspect {
    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    // The ProceedingJoinPoint contains a handle to the target method
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
	String methodName = proceedingJoinPoint.getSignature().toShortString();
	System.out.println("\n ===> Calling @Around on: " + methodName);
	
	// Start the timestamp
	long start = System.currentTimeMillis();

	// Execute the target method
	Object result = proceedingJoinPoint.proceed();

	// End the timestamp
	long end = System.currentTimeMillis();

	// Display the duraton
	long duration = end - start;
	System.out.println("\n ===> Duration: " + (duration / 1000.0) + " seconds");

	return result;
    }

}

