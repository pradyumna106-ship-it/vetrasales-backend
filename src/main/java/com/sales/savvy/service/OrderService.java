package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import com.sales.savvy.dto.CartData;
import com.sales.savvy.dto.OrderDTO;
import com.sales.savvy.entity.Order;

public interface OrderService {
	void createOrder(OrderDTO order);

	List<OrderDTO> getAllOrders();

	List<OrderDTO> getDeliveredOrders(String name);

	Optional<OrderDTO> getOrderById(Long orderId);
}
