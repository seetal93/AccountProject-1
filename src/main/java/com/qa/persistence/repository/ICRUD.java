package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface ICRUD {
		
		String updateAccount(Account account, String s1);
		
		String getAnAccount(Account account);
		
		String getAllAccounts();

		String createAccount(String s1, String s2);

		String deleteAccount(Account account);
		

	}

