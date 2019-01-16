package com.qa.business.service;

import java.util.HashMap;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.Data;

public interface Service {
	
	public void add(Data data, Account account);
	
	public HashMap<Integer, Account> retrieve(Data data);
	
	public int countAccounts(Data data, String name);

}
