package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sales.savvy.entity.Cart;
import com.sales.savvy.entity.User;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
