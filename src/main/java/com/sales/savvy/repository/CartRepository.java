package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
