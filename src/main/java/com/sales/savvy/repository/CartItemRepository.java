package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sales.savvy.entity.CartItem;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartIdAndProdId(Long cartId, Long prodId);
    void deleteByCart_Customer_Id(Long customerId);
}