package com.qa.AccountProject;

public class Account {
	
	private String firstName;
	private String lastName;
	private static int accountNumber;
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public static int getAccountNumber() {
		return accountNumber;
	}

}
