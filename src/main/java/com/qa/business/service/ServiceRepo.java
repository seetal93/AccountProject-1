package com.qa.business.service;

import com.qa.persistence.repository.AccountMapRepo;

public interface ServiceRepo {
	
	String updateAccount(String jsonData);
	
	String getAnAccount(String jsonData);
	
	String getAllAccounts();

	String createAccount(String jsonData);

	String deleteAccount(Long id);
	
	//public Map<Integer, Account> retrieve(AccountMapRepo data);
	public int countAccounts(AccountMapRepo data);
	
	public int countAccountsByName(AccountMapRepo data, String name);

}
