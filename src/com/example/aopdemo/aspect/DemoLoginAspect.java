package com.example.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoginAspect {

    private Logger logger = Logger.getLogger(DemoLoginAspect.class.getName());

    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    // The ProceedingJoinPoint contains a handle to the target method
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
	String methodName = proceedingJoinPoint.getSignature().toShortString();
	logger.info("\n ===> Calling @Around on: " + methodName);
	
	// Start the timestamp
	long start = System.currentTimeMillis();

	// Execute the target method
	Object result = null;

	// Re-throwing the exception
	try{
	    result = proceedingJoinPoint.proceed();
	} catch (Exception e) {
	    logger.warning(e.getMessage());

	    throw e;
	}

	// Swallowing the exception. The main program will not know about it.
	// try{
	//     result = proceedingJoinPoint.proceed();
	// } catch (Exception e) {
	//     logger.warning(e.getMessage());

	//     result = "Highway is closed but finding alternative route...";
	// }

	// End the timestamp
	long end = System.currentTimeMillis();

	// Display the duraton
	long duration = end - start;
	logger.info("\n ===> Duration: " + (duration / 1000.0) + " seconds");

	return result;
    }

}

