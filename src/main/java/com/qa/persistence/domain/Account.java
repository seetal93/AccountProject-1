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
	private static Long ID;
	@Column (length = 100)
	private String firstName;

	@Column (length = 100)
	private String lastName;
	@Column
	private Long accountNumber;
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accountNumber = ID;
		ID++;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


}
