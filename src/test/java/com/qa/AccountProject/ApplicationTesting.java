package com.qa.AccountProject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class ApplicationTesting extends TestCase {
	
	Data data;
	
	@Before
	public void initialiseClasses() {
		data = new Data();
	}

	@Test
	@Ignore
	public void initialFail() {
		fail();
	}
	
	@Test
	public void createAccount() {
		Account bigBro = new Account("Yo", "Yo");
		
		assertEquals(0, bigBro.getAccountNumber());
	}
	
	@Test
	public void getMapData() {
		assertEquals(null, Service.retrieve(data));
		
	}
	
}
