package com.sales.savvy.controller;

import java.util.List;
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


@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired 
    private UserService service;

    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDto) {
        String result = service.addUser(userDto);
        
        return ResponseEntity.ok("User registered successfully");
    }
    
    @PostMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDto) {
        String result = service.updateUser(userDto);
        if ("fail".equals(result))
            return ResponseEntity.status(409).body("Username not found");
        return ResponseEntity.ok("User updated successfully");
    }

    @PostMapping(value = "/signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signIn(@RequestBody LoginData data) {
        return service.validateUser(data);
    }

    @GetMapping("/userData")
    public UserDTO userData(@RequestParam String username) {
        
        return service.getUser(username);
    }

    @GetMapping("/deleteAll")
    public void deleteAllUser() {
        service.deleteAllUser();
    }

    @GetMapping("/delete")
    public void deleteUser(Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/searchUser")
    public List<UserDTO> searchUser(String name) {
        return service.searchUser(name);
    }

    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUser() {
        return service.getAllUser();
    }
    
    @GetMapping("/emails")
    public List<String> getAllUserEmails() {
        return service.getAllUserEmails();
    }
    
    @GetMapping("/phones")
    public List<String> getAllUserPhones() {
        return service.getAllUserPhone();
    }
}

