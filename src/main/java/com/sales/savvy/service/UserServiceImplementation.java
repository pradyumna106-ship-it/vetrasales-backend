package com.sales.savvy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;
import com.sales.savvy.enums.Gender;
import com.sales.savvy.enums.Role;
import com.sales.savvy.enums.userStatus;
import com.sales.savvy.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public String addUser(UserDTO userDto) {
    	// Check if username already exists
        Optional<User> existing = repo.findByUsername(userDto.getUsername());
        Optional<User> existing2 = repo.findByEmail(userDto.getEmail());
        if (existing.isPresent() || existing2.isPresent()) {
            return "fail";   // already taken
        }
        System.out.println("Email exists: " + repo.findByEmail(userDto.getEmail()));
        System.out.println("Username exists: " + repo.findByUsername(userDto.getUsername()));
        User user = new User();
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setGender(Gender.valueOf(userDto.getGender().toUpperCase()));
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        user.setUsername(userDto.getUsername());
        user.setJoinedDate(LocalDate.now());
        user.setStatus(userStatus.ACTIVE);
        // New username — save
        repo.save(user);
        return "success";
    }

    @Override
    public UserDTO getUser(String username) {
        // Just wrap repo call
    	Optional<User> userOP = repo.findByUsername(username);
    	User user = userOP.get();
		UserDTO dto = new UserDTO();
		dto.setDob(user.getDob());
		dto.setEmail(user.getEmail());
		dto.setGender(user.getGender().toString());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole().toString());
		dto.setUsername(user.getUsername());
		dto.setJoinedDate(user.getJoinedDate());
		dto.setLocation(user.getLocation());
		dto.setPhone(user.getPhone());
		dto.setStatus(user.getStatus().toString());
		dto.setId(user.getId());
        return dto;
    }

    @Override
    public String validateUser(LoginData data) {

        Optional<User> optUser = repo.findByUsername(data.getUsername());

        if (optUser.isEmpty()) {
            return "invalid"; // username not found
        }

        User u = optUser.get();

        // ✅ ONLY check password
        if (!u.getPassword().equals(data.getPassword())) {
            return "invalid"; // wrong password
        }

        // ✅ role check
        return u.getRole().name().toString().equals("ADMIN") ? "admin" : "customer";
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
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
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
        user.setJoinedDate(userDto.getJoinedDate());
        user.setStatus(userStatus.valueOf(userDto.getStatus()));
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

	@Override
	public List<UserDTO> getAllAdmin() {
		// TODO Auto-generated method stub
		List<User> users = repo.findByRole(Role.ADMIN);
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
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public List<UserDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		List<User> users = repo.findByRole(Role.CUSTOMER);
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
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}
}
