package com.resolveit.resource;

import lombok.ToString;

@ToString
public enum AccountType {

	CUSTOMER("customer"),
	SERVICE("service");
	
	private final String type;
	
	AccountType(String type){
		this.type = type;
	}
	
}
