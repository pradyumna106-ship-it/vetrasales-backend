package com.sales.savvy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Cart;
import com.sales.savvy.entity.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
	 Optional<Cart> findByUser(User user);
}
