package com.sales.savvy.repository;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	List<Orders> findByCustomerId(Long id);

	List<Orders> findByDeliveryPersonId(Long id);
}
