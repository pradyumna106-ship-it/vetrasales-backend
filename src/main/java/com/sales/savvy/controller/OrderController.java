package com.sales.savvy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.CustomerSummaryDTO;
import com.sales.savvy.dto.OrderDTO;
import com.sales.savvy.entity.Order;
import com.sales.savvy.service.OrderService;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO order) {
        service.createOrder(order);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/delivered")
    public List<OrderDTO> getDeliveredOrders(@RequestParam String username) {
        return service.getDeliveredOrders(username);
    }

    @GetMapping("/byId")
    public Optional<OrderDTO> getOrderById(@RequestParam Long orderId) {
        return service.getOrderById(orderId);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        String st = service.updateOrderStatus(id, status);
        return ResponseEntity.ok(st);
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
    
    @GetMapping("/getSummary")
    public CustomerSummaryDTO getSummary(@RequestParam String username) {
        return service.getSummary(username);
    }
}
