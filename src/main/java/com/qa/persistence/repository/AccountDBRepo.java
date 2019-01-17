package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
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
	public EntityManager manager;

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
	public String getAnAccount(String accountToRetrieve) {
		Account account = util.getObjectForJSON(accountToRetrieve, Account.class);
		account = findAccount(account.getAccountNumber());
		
		return account.toString();
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String accountToCreate) {
		Account account = util.getObjectForJSON(accountToCreate, Account.class);
		manager.persist(account);
		return account.getAccountNumber() + " created!";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account account = findAccount(id);
		if (account != null) {
			manager.remove(account);
		}
		return "Account deleted";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String accountToUpdate) {
		Account account = util.getObjectForJSON(accountToUpdate, Account.class);
		if (account != null) {
			manager.remove(account.getAccountNumber());
			manager.persist(account);
		}
		return account.getAccountNumber() + " updated!";
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
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

