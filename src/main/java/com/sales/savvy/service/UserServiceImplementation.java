package com.sales.savvy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.entity.User;
import com.sales.savvy.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService {
	@Autowired private UserRepository repo;
	
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> existing = repo.findByUsername(user.getUsername());
        if (existing.isPresent()) {
            return "fail";   // already taken
        }
        // New username — save
        repo.save(user);
        return "success";
	}

	@Override
	public Optional<User> getUser(String username) {
		// TODO Auto-generated method stub
		 return repo.findByUsername(username);
	}

	@Override
	public String validateUser(LoginData data) {
		// TODO Auto-generated method stub
		 Optional<User> optUser = repo.findByUsername(data.getUsername());
	        if (!optUser.isPresent()) {
	            return "invalid";  // no such user
	        }
	        User u = optUser.get();
	        // Check password
	        if (!u.getPassword().equals(data.getPassword())) {
	            return "invalid";  // wrong password
	        }
	        // Return role
	        return u.getRole().equalsIgnoreCase("ADMIN") ? "admin" : "customer";
	}

}
