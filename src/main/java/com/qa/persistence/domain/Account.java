package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Account {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private static int ID;
	@Column (length = 100)
	private String firstName;
	@Column (length = 100)
	private String lastName;
	@Column
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
