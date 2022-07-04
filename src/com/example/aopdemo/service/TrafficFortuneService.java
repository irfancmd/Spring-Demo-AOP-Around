package com.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		// Simulate a delay
		try {
			// Sleep for 5 seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Moderate traffic";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
		    throw new RuntimeException("Highway is closed");
		}

		return getFortune();
	}
}
