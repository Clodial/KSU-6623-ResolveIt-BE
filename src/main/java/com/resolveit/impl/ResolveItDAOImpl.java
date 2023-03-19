package com.resolveit.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class ResolveItDAOImpl {

	@Autowired
	private DataSource datasource;
	
	public ResolveItDAOImpl() {}
	
}
