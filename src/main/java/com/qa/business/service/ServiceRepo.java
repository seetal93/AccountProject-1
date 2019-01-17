package com.qa.business.service;

import java.util.HashMap;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepo;

public interface ServiceRepo {
	
	public void add(AccountMapRepo data, Account account);
	
	public HashMap<Integer, Account> retrieve(AccountMapRepo data);
	
	public int countAccounts(AccountMapRepo data, String name);

}
