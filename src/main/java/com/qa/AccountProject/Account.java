package com.qa.AccountProject;

public class Account {
	
	private static int ID;
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accountNumber = ID;
		ID++;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}


}
