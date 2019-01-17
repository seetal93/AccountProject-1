package com.qa.AccountProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepo;

import junit.framework.TestCase;

public class ApplicationTesting {
	
	AccountMapRepo data;
	Account bigBro;
	Account smallBro;
	
	@Before
	public void initialiseClasses() {
		data = new AccountMapRepo();
		bigBro = new Account("Yo", "Yo");
		smallBro = new Account("Mr.", "Johnson");
		
		ServiceRepo.add(data, bigBro);
		ServiceRepo.add(data, bigBro);
	}

	@Test
	@Ignore
	public void initialFail() {
		fail();
	}
	
	@Test
	public void cycleAccounts() {
		assertEquals(1, ServiceRepo.countAccounts(data, bigBro.getFirstName()));
	}
	
	@Test
	public void sizeOfData() {
		assertEquals(1, ServiceRepo.countAccounts(data, bigBro.getFirstName()));
	}
	
	@Test
	@Ignore
	public void returnCorrectName() {
		assertEquals("Yo", ServiceRepo.countAccounts(data, bigBro.getFirstName()));
	}
	
	@Test
	public void countNames() {
		assertEquals(1, ServiceRepo.countAccounts(data, "Yo"));
	}
}
