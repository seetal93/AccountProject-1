package com.qa.business.service;

import java.util.HashMap;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.Data;

public final class ServiceImplementation implements Service {
	
	@Inject
	private Data data;
	
	private ServiceImplementation() {
		
	}
	
	@Override
	public void add(Data data, Account account) {
		data.getUserAccounts().put(account.getAccountNumber(), account);
		
	}
	
	@Override
	public HashMap<Integer, Account> retrieve(Data data) {
		return data.getUserAccounts();
	}
	
	@Override
	public int countAccounts(Data data, String name) {
		
		return (int) data.getUserAccounts().values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(name)).count();
	}
}
