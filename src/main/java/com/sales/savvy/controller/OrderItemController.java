package com.sales.savvy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.OrderDTO;
import com.sales.savvy.entity.Orders;
import com.sales.savvy.service.OrdersService;

@CrossOrigin("*")
@RestController
public class OrderItemController {
	@Autowired private OrdersService service;
	
	@PostMapping("/createOrder")
	public void createOrder(@RequestBody OrderDTO order) {
		System.out.println("Received order: " + order);
		service.createOrder(order);
	}
	
	@GetMapping("/listOfOrders")
	public List<OrderDTO> listOfOrders (Long id) {
		return service.listOfOrders(id);
	}
	
	@GetMapping("/getDeliveredOrders")
	public List<Orders> getDeliveredOrders (Long cusId){
		return service.getDeliveredOrders(cusId);
	}
	
	@GetMapping("/getOrderById")
	public Optional<Orders> getOrderById(Long orderId) {
		return service.getOrderById(orderId);
	}
}
