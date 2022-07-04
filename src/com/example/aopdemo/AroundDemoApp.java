package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Main Program Calling: getFortune()");
		System.out.println("The Fortune is: " + trafficFortuneService.getFortune());
		System.out.println("Main Program is done");
		context.close();
	}

}
