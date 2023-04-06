package com.resolveit.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.resolveit.dao.ResolveItDAO;
import com.resolveit.resource.Login;
import com.resolveit.service.ResolveItMain;

public class ResolveItMainImpl implements ResolveItMain{
	
	@Autowired
	ResolveItDAO dao;
	
	public ResolveItMainImpl() {}

	/**
	 * 
	 */
	@Override
	public String accountCreation(Login loginInfo) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.createLoginAccount(loginInfo);
			return "Account: " + loginInfo.getName() + ", Successfully Created";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 */
	@Override
	public Login checkLoginCredentials(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			return dao.retrieveLoginAccount(name, password);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
