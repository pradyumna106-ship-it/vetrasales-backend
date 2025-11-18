package com.sales.savvy.service;

import java.util.Optional;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;

public interface UserService {
    String addUser(UserDTO userDto);
    Optional<User> getUser(String username);
    String validateUser(LoginData data);
}
