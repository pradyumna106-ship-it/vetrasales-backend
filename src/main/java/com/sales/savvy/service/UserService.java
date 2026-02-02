package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sales.savvy.dto.FetchContactDTO;
import com.sales.savvy.dto.JwtResponse;
import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;



public interface UserService extends UserDetailsService{
    String addUser(UserDTO userDto);
    UserDTO getUser(String username);

    // void validateUser(LoginData data); // Removed to break circular dependency
    void deleteUser(UUID id);

    void deleteAllUser();
    List<UserDTO> searchUser(String name);
    List<UserDTO> getAllUser();
    List<UserDTO> getAllAdmin();
    List<UserDTO> getAllCustomer();
    String updateUser(UserDTO userDto);
	List<String> getAllUserEmails();
	List<String> getAllUserPhone();
	String userStatus(UUID id);
	FetchContactDTO getEmailAndPhoneByUser(String username);
}
