package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.sales.savvy.entity.CartItem;

import jakarta.transaction.Transactional;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
	@Modifying
    @Transactional
	void deleteByProduct_Id(Long productId);

}