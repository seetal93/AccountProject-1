package com.qa.persistence.repository;

public interface ICRUD {
		
		String updateAccount(String jsonData);
		
		String getAnAccount(String jsonData);
		
		String getAllAccounts();

		String createAccount(String jsonData);

		String deleteAccount(Long id);
		

	}

