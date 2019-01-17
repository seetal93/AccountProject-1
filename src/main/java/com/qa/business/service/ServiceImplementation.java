package com.qa.business.service;

import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.ICRUD;
import com.qa.persistence.repository.AccountMapRepo;

public final class ServiceImplementation implements ServiceRepo {
	
	@Inject
	private ICRUD data;
	
	private ServiceImplementation() {
		
	}
	
	public String updateAccount(Account account, String name) {
		return data.updateAccount(account, name);
	}
	
	@Override
	public String getAllAccounts() {
		return data.getAllAccounts();
	}
	
	public String getAnAccount(Account account) {
		return data.getAnAccount(account);
	}
	
	public String createAccount(String FName, String LName) {
		if (countAccounts(data) == 9998) {
			return "Unable to create account 9999";
		}
		else {
			return data.createAccount(FName, LName);
		}
	}
	
	public String deleteAccount(Account account) {
		return data.deleteAccount(account);
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
