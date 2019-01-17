package com.qa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ServiceImplementation;

@Path("/account") // going to the path activates the class
public class AccountEndpoint {
	
	private ServiceImplementation service;
	
	@Path("/json") // activates method
	@GET // HTTP request
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) { // must only take in one param
		return service.createAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}

}
