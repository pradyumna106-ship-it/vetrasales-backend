package com.sales.savvy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.OrderDTO;
import com.sales.savvy.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    // ---------------------------------------------------------
    // CREATE ORDER
    // ---------------------------------------------------------
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO order) {
        service.createOrder(order);
        return ResponseEntity.ok("Order created successfully");
    }

    // ---------------------------------------------------------
    // GET ALL ORDERS OF A USER
    // ---------------------------------------------------------
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return service.getAllOrders();
    }


    // ---------------------------------------------------------
    // GET DELIVERED ORDERS OF USER
    // ---------------------------------------------------------
    @GetMapping("/delivered")
    public List<OrderDTO> getDeliveredOrders(@RequestParam String username) {
        return service.getDeliveredOrders(username);
    }

    // ---------------------------------------------------------
    // GET ORDER BY ID
    // ---------------------------------------------------------
    @GetMapping("/byId")
    public Optional<OrderDTO> getOrderById(@RequestParam Long orderId) {
        return service.getOrderById(orderId);
    }
}
