package com.resolveit.resource;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Login implements Serializable {

	private static final long serialVersionUID = -2870961836997172873L;
	private String userId;
	private String name;
	private String password;
	private AccountType accountType;	
	
}
