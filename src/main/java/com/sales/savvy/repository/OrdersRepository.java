package com.sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	List<Orders> findByCustomerId(Long id);

	List<Orders> findByDeliveryPersonId(Long id);
}
