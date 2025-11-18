package com.sales.savvy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;
import com.sales.savvy.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.ALL_VALUE)
public class UserController {
	
	@Autowired private UserService service;
	
	@PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDto) {
        String result = service.addUser(userDto);

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
	@GetMapping("/userData")
	public UserDTO userData(@RequestParam String username) {
		Optional<User> profile = service.getUser(username);
		User user = profile.orElseThrow(() -> new RuntimeException("User not found"));  // or real data;
		UserDTO userdto = new UserDTO();
		userdto.setId(user.getId());
		userdto.setUsername(user.getUsername());
		userdto.setPassword(user.getPassword());
		userdto.setRole(user.getRole());
		userdto.setGender(user.getGender());
		userdto.setEmail(user.getEmail());
		userdto.setDob(user.getDob());
	    return userdto;
	}

	
}
