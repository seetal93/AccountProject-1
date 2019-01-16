package com.qa.AccountProject;

import java.util.HashMap;

public final class Service {
	
	private Service() {
		
	}
	
	public static void add(Data data, Account account) {
		data.getUserAccounts().put(account.getAccountNumber(), account);
		
	}
	
	public static HashMap<Integer, Account> retrieve(Data data) {
		return data.getUserAccounts();
	}
	
	public static int countAccounts(Data data, String name) {
		
		int counter = 0;
		for(int i = 0; i < data.getUserAccounts().size(); i++) {
			if (data.getUserAccounts().get(i).equals(name)){
				counter++;
			}
		}
		return counter;
	}

}
