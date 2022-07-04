package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import com.example.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("Main Program output....");
		System.out.println(accounts);

		context.close();
	}

}
