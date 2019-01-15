package com.qa.AccountProject;

import java.util.HashMap;

public class Data {
	
	private HashMap<String, Integer> userAccounts = new HashMap<String, Integer>();
	
	public Integer get(Object arg0) {
		return getUserAccounts().get(arg0);
	}

	public Integer put(String arg0, Integer arg1) {
		return getUserAccounts().put(arg0, arg1);
	}

	public Data() {
		
	}

	public HashMap<String, Integer> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(HashMap<String, Integer> userAccounts) {
		this.userAccounts = userAccounts;
	}

}
