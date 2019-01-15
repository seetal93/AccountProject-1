package com.qa.AccountProject;

import java.util.HashMap;

public final class Service {
	
	private Service() {
		
	}
	
	public static void add(Data data, Account account) {
		data.getUserAccounts().put(account.getLastName(), account.getAccountNumber());
		
	}
	
	public static HashMap<String, Integer> retrieve(Data data) {
		return data.getUserAccounts();
	}

}
