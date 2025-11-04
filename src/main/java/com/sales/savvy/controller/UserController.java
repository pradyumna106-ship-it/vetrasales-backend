package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.entity.User;
import com.sales.savvy.service.UserService;

public class UserController {
	@Autowired private UserService service;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody User user) {
		return service.addUser(user);		
	}
	
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody LoginData data) {
		return service.validateUser(data);
	}
}
