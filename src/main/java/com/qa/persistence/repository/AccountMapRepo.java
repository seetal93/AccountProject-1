package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepo implements ICRUD {
	
	private HashMap<Integer, Account> userAccounts = new HashMap<Integer, Account>();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Inject
	private Account account;
	
	public HashMap<Integer, Account> getUserAccounts() {
		return userAccounts;
	}
	
	@Override
	public String getAllAccounts() {
		return getUserAccounts().values().toString();
	}
	
	@Override
	public String getAnAccount(Account account) {
		return getUserAccounts().get(account).toString();
	}

	@Override
	public String createAccount(String s1, String s2) {
		Account account = new Account(s1, s2);
		userAccounts.put(account.getAccountNumber(), account);
		return account.getFirstName() + " Created!";
	}
	
	@Override
	public String deleteAccount(Account account) {
		getUserAccounts().remove(account);
		return account + " deleted";
	}
	
	@Override
	public String updateAccount(Account account, String name) {
		account.setFirstName(name);
		
		return account.getFirstName() + "updated!";
	}
	
	// below are getters/setters and utility.

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
		}
}
