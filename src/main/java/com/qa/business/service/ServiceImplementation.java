package com.qa.business.service;

import java.util.HashMap;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.ICRUD;
import com.qa.persistence.repository.AccountMapRepo;

public final class ServiceImplementation implements ServiceRepo {
	
	@Inject
	private ICRUD data;
	
	private ServiceImplementation() {
		
	}
	
	@Override
	public void add(AccountMapRepo data, Account account) {
		data.getUserAccounts().put(account.getAccountNumber(), account);
		
	}
	
	@Override
	public HashMap<Integer, Account> retrieve(AccountMapRepo data) {
		return data.getUserAccounts();
	}
	
	@Override
	public int countAccounts(AccountMapRepo data, String name) {
		
		return (int) data.getUserAccounts().values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(name)).count();
	}
}
