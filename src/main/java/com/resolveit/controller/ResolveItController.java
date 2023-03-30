package com.resolveit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resolveit.impl.ResolveItMainImpl;
import com.resolveit.resource.Login;

@RestController
@RequestMapping("/resolveit")
public class ResolveItController {

	@Autowired
	ResolveItMainImpl resolveItImpl;
	
	public ResolveItController(){}
	
	
	@PostMapping(value = "/createaccount", produces ="application/json")
	public ResponseEntity<String> createAccount(@RequestBody Login loginInfo) throws Exception {
		return ResponseEntity.ok(resolveItImpl.accountCreation(loginInfo));
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<Login> loginUser(@RequestParam String name, @RequestParam String password) throws Exception {
		return ResponseEntity.ok(resolveItImpl.checkLoginCredentials(name, password));
	}
	
}
