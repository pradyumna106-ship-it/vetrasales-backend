package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.LoginResponseDTO;
import com.sales.savvy.service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {
	@Autowired private LoginService service;

	@PostMapping("/signin")
	public LoginResponseDTO signin(@RequestBody LoginData loginData) {
		return service.signin(loginData);
	}
}
