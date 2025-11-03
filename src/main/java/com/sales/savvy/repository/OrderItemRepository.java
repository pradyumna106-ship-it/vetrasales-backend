package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
