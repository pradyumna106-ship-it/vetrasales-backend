package service;

import java.util.Optional;

import dto.LoginData;
import entity.User;

public interface UserService {
    String addUser(User user);
    Optional<User> getUser(String username);
    String validateUser(LoginData data);
}
