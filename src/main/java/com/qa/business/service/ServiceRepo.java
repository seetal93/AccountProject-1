package com.qa.business.service;

import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepo;

public interface ServiceRepo {
	
	String updateAccount(Account account, String s1);
	
	String getAnAccount(Account account);
	
	String getAllAccounts();

	String createAccount(String s1, String s2);

	String deleteAccount(Account account);
	
	//public Map<Integer, Account> retrieve(AccountMapRepo data);
	public int countAccounts(AccountMapRepo data);
	
	public int countAccountsByName(AccountMapRepo data, String name);

}
