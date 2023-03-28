package com.resolveit.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.resolveit.resource.Login;
import com.resolveit.service.ResolveItMain;

public class ResolveItMainImpl implements ResolveItMain{

	@Autowired
	private DataSource datasource;
	
	public ResolveItMainImpl() {}

	/**
	 * 
	 */
	@Override
	public String accountCreation(Login loginInfo) throws Exception {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Login checkLoginCredentials(String name, String password, String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
