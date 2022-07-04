package com.example.aopdemo.aspect;

import java.util.List;

import com.example.aopdemo.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoginAspect {

    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvise(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @After (finally) on method: " + method);
    }


    @AfterThrowing(
		    pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
		    // This is the name of the variable where the exception will be stored. We can name this anything we want
		    throwing = "exc"
)
    public void afterThrowingFindAccountAdvise(JoinPoint joinPoint, Throwable exc) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterThrowing on method: " + method);

		// Logging the exception
		System.out.println("\n ====> The exception is: " + exc);
    }

    @AfterReturning(
		    pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
		    // This is the name of the variable where the return value will be stored. We can name this anything we want
		    returning = "result"
)
    public void afterReturningFindAccountAdvise(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterReturning on method: " + method);

		// Post-processing the data
		convertAccountNamesToUppercase(result);

		System.out.println("\n ====> The result is: " + result);
    }
    
    private void convertAccountNamesToUppercase(List<Account> result) {
	for(Account account : result) {
	    account.setName(account.getName().toUpperCase());
	}
    }

	// Reusing a pointcut expression that was declared before 
    // Works for all methods in a specific package located in any class with any parameter(s)
    @Before("com.example.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAnyMethodOfAPackage(JoinPoint joinpoint) {
    	System.out.println("\n ***** This executes before calling any method of com.example.aopdemo.dao package with any return type and parameters");

	// Getting method signature
    	MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
    	System.out.println("Method: " + methodSignature);

	// Getting method arguments
	Object[] arguments = joinpoint.getArgs();

	for (Object arg : arguments) {
		System.out.println(arg);

		if (arg instanceof Account) {
		    // Downcast and get specific information
		    Account account = (Account) arg;
		    System.out.println("Account name: " + account.getName());
		    System.out.println("Account email: " + account.getEmail());
		}
	}
    }

}

