package com.qa.persistence.repository;

import java.util.HashMap;

import com.qa.persistence.domain.Account;

public class Data {
	
	private HashMap<Integer, Account> userAccounts = new HashMap<Integer, Account>();
	
	public Account get(Object arg0) {
		return getUserAccounts().get(arg0);
	}

	public Account put(Account arg0, Integer arg1) {
		return getUserAccounts().put(arg1, arg0);
	}

	public Data() {
		
	}

	public HashMap<Integer, Account> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(HashMap<Integer, Account> userAccounts) {
		this.userAccounts = userAccounts;
	}

}
