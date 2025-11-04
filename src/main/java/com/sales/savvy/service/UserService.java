package com.sales.savvy.service;

import java.util.Optional;

import com.sales.savvy.dto.LoginData;
import com.sales.savvy.entity.User;

public interface UserService {
    String addUser(User user);
    Optional<User> getUser(String username);
    String validateUser(LoginData data);
}
