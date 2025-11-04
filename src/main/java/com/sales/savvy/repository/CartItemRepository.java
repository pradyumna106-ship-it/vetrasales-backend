package com.sales.savvy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByCartIdAndProdId(Long cartId, Long prodId);
}
