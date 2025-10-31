package com.sales.savvy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.User;

public interface UserRepository 
				extends JpaRepository<User, Long>	{

	Optional<User> findByUsername(String username);
}
