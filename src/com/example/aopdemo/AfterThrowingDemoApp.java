package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import com.example.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try{
		    // A boolean for triggering an exception for testing purpose
		    boolean tripWire = true;
		    accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
		    System.out.println("Main Program Caught exception: " + e);
		}

		System.out.println("Main Program output....");
		System.out.println(accounts);

		context.close();
	}

}
