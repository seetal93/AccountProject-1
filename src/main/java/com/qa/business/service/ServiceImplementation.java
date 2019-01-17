package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ICRUD;
import com.qa.persistence.repository.AccountMapRepo;

public final class ServiceImplementation implements ServiceRepo {
	
	@Inject
	public ICRUD data;
	
	private ServiceImplementation() {
		
	}
	
	public String updateAccount(String accountToUpdate) {
		return data.updateAccount(accountToUpdate);
	}
	
	@Override
	public String getAllAccounts() {
		return data.getAllAccounts();
	}
	
	public String getAnAccount(String getAccount) {
		return data.getAnAccount(getAccount);
	}
	
	public String createAccount(String accountToCreate) {
			return data.createAccount(accountToCreate);
	}
	
	public String deleteAccount(Long id) { //??
		return data.deleteAccount(id);
	}
	
	public int countAccounts(AccountMapRepo data) {
		return (int) data.getUserAccounts().values().stream().count();
	}
	
	/*@Override
	public Map<Integer, Account> retrieve(AccountMapRepo data) {
		return data.getUserAccounts();
	}*/
	
	@Override
	public int countAccountsByName(AccountMapRepo data, String name) {
		
		return (int) data.getUserAccounts().values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(name)).count();
	}
}
