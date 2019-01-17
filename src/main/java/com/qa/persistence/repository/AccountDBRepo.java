package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepo implements ICRUD {

	@PersistenceContext(unitName = "primary") // tells manager to look into persistence xml and use persistence unit: primary.
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	// transactional -> TCP, if packets are lost, transfer will fail
	//not transactional -> UTP if packets are lost, transfer will continue
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a From Account a");
		Collection<Account> result = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	public String getAnAccount(Account account) {
		return util.getJSONForObject(account);
		
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String fN, String lN) {
		Account account = new Account(fN, lN);
		manager.persist(account);
		return account.getAccountNumber() + " created!";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Account account) {
		manager.remove(account);
		return account + " deleted";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Account account, String newName) {
		account.setFirstName(newName);
		
		return account + " updated!";
	}
	
	// below are getters/setters and utility.
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

