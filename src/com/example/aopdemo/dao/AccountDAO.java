package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.example.aopdemo.Account;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;
    
	public void addAccount() {
		System.out.println(getClass() + ": Adding an acount...");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Adding an acount...");
	}
	
	public void addAccount(Account account, boolean isVip) {
		System.out.println(getClass() + ": Adding an acount...");
	}

    public List<Account> findAccounts(boolean tripWire) {

	if (tripWire) {
	    throw new RuntimeException("Test exception");
	}


	List<Account> accounts = new ArrayList<>();

	Account account1 = new Account("Akkas Ali", "akkasali@gmail.com");
	Account account2 = new Account("Abdul Kuddus", "abdulkuddus@gmail.com");
	Account account3 = new Account("Motin Ali", "motinali@gmail.com");

	accounts.add(account1);
	accounts.add(account2);
	accounts.add(account3);

	return accounts;
    }

	public String getName() {
	    System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
	    System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
	    System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
	    System.out.println(getClass() + ": in setServicecode()");
		this.serviceCode = serviceCode;
	}

	
}
