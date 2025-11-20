package com.sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUsername(String name);
}
