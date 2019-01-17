package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepo implements ICRUD {
	
	private HashMap<Long, Account> userAccounts = new HashMap<>();

	@Inject
	public JSONUtil util;
	
	public HashMap<Long, Account> getUserAccounts() {
		return userAccounts;
	}
	
	@Override
	public String getAllAccounts() {
		return getUserAccounts().values().toString();
	}
	
	@Override
	public String getAnAccount(String accountToGet) {
		Account account = util.getObjectForJSON(accountToGet, Account.class);
		return getUserAccounts().get(account.getAccountNumber()).toString();
	}

	@Override
	public String createAccount(String accountToCreate) {
		Account account = util.getObjectForJSON(accountToCreate, Account.class);
		userAccounts.put(account.getAccountNumber(), account);
		return account.getFirstName() + " Created!";
	}
	
	@Override
	public String deleteAccount(Long id) {
		getUserAccounts().remove(id);
		return "account deleted!";
	}
	
	@Override
	public String updateAccount(String accountToUpdate) {
		
		Account account = util.getObjectForJSON(accountToUpdate, Account.class);
		
		if (account != null) {
		userAccounts.remove(account.getAccountNumber());
		userAccounts.put(account.getAccountNumber(), account);
		}
		
		return account.getAccountNumber() + "account updated!";
		}
	
	// below are getters/setters and utility.

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
