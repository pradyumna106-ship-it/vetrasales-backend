package com.sales.savvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;
import com.sales.savvy.enums.Gender;
import com.sales.savvy.enums.Role;
import com.sales.savvy.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public String addUser(UserDTO userDto) {
    	// Check if username already exists
        Optional<User> existing = repo.findByUsername(userDto.getUsername());
        if (existing.isPresent()) {
            return "fail";   // already taken
        }
        User user = new User();
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setGender(Gender.valueOf(userDto.getGender().toUpperCase()));
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        user.setUsername(userDto.getUsername());
        user.setJoinedDate(userDto.getJoinedDate());
        user.setStatus(userDto.getStatus());
        // New username — save
        repo.save(user);
        return "success";
    }

    @Override
    public Optional<User> getUser(String username) {
        // Just wrap repo call
        return repo.findByUsername(username);
    }

    @Override
    public String validateUser(LoginData data) {
        // Look up by username
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
        return u.getRole().equals(Role.ADMIN.toString()) ? "admin" : "customer";
    }

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		repo.deleteAll();
	}

	@Override
	public List<UserDTO> searchUser(String name) {
		// TODO Auto-generated method stub
		List<User> users = repo.searchUser(name);
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String updateUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		Optional<User> existing = repo.findByUsername(userDto.getUsername());
        if (existing.isPresent()) {
            return "fail";   // already taken
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setGender(Gender.valueOf(userDto.getGender().toUpperCase()));
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        user.setUsername(userDto.getUsername());
        // New username — save
        repo.save(user);
        return "success";
	}

	@Override
	public List<String> getAllUserEmails() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<String> emails = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			emails.add(users.get(i).getEmail());
		}
		return emails;
	}
	
	@Override
	public List<String> getAllUserPhone() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<String> phones = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			phones.add(users.get(i).getEmail());
		}
		return phones;
	}
}
