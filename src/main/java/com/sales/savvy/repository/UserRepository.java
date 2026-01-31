package com.sales.savvy.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;
import com.sales.savvy.enums.Role;

public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByUsername(String username);
	@Query("SELECT u FROM User u WHERE u.username LIKE :keyword%")
	List<User> searchUser(String keyword);
	Optional<User> findByEmail(String email);
	List<User> findByRole(Role role);

}
