package com.qa.AccountProject;

import java.util.HashMap;

public class Service {
	
	public Service() {
		
	}
	
	public void Add(Data data, Account account) {
		data.getUserAccounts().put(account.getLastName(), Account.getAccountNumber());
		
	}
	
	public HashMap<String, Integer> Retrieve(Data data) {
		return data.getUserAccounts();
	}

}
