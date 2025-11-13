package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.entity.User;
import com.sales.savvy.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired private UserService service;
	
	@PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUp(@RequestBody User user) {
        String result = service.addUser(user);

        if ("fail".equals(result)) {
            return ResponseEntity.status(409).body("Username already exists");
        } else {
            return ResponseEntity.ok("User registered successfully");
        }
    }
	
	
	@PostMapping(value = "/signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody LoginData data) {
		return service.validateUser(data);
	}
}
