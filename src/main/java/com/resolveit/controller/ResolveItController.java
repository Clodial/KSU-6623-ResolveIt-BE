package com.resolveit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resolveit.impl.ResolveItDAOImpl;
import com.resolveit.resource.Login;

@RestController
@RequestMapping("resolveit")
public class ResolveItController {

	private final ResolveItDAOImpl resolveItImpl;
	
	ResolveItController(ResolveItDAOImpl resolveItImpl){
		this.resolveItImpl = resolveItImpl;
	}
	
	
	@PostMapping(value = "/createaccount", produces ="application/json")
	public ResponseEntity<String> createAccount(@RequestBody Login loginInfo) throws Exception {
		
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<Login> loginUser(@RequestParam String name, @RequestParam String password, @RequestParam String email) throws Exception {
		
	}
	
}
