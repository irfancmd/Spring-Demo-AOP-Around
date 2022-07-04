package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

import com.example.aopdemo.service.TrafficFortuneService;


public class AroundWithLoggerDemoApp {
    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName()); 
 
    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
	TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
	logger.info("Main Program Calling: getFortune()");
	logger.info("The Fortune is: " + trafficFortuneService.getFortune());
	logger.info("Main Program is done");
	context.close();
    }
    
}
