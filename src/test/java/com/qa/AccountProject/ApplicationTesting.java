package com.qa.AccountProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class ApplicationTesting {
	
	Data data;
	Account bigBro;
	Account smallBro;
	
	@Before
	public void initialiseClasses() {
		data = new Data();
		bigBro = new Account("Yo", "Yo");
		smallBro = new Account("Mr.", "Johnson");
		
		Service.add(data, bigBro);
	}

	@Test
	@Ignore
	public void initialFail() {
		fail();
	}
	
	@Test
	public void createAccount() {
		assertEquals(2, bigBro.getAccountNumber());
	}
	
	@Test
	public void cycleAccounts() {
		assertEquals(1, Service.countAccounts(data, bigBro));
	}
	
	@Test
	public void sizeOfData() {
		assertEquals(1, Service.countAccounts(data, bigBro));
	}
	
	@Test
	@Ignore
	public void returnCorrectName() {
		assertEquals("Yo", Service.countAccounts(data, bigBro));
	}
	
}
