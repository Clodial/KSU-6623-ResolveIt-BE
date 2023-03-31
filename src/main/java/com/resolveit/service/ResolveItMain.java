package com.resolveit.service;

import com.resolveit.resource.Login;

public interface ResolveItMain {

	public String accountCreation(Login loginInfo) throws Exception;
	
	public Login checkLoginCredentials(String name, String password) throws Exception;
	
}
