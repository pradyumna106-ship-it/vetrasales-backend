package com.sales.savvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.OrderDTO;
import com.sales.savvy.dto.OrderItemDTO;
import com.sales.savvy.entity.Order;
import com.sales.savvy.entity.OrderItem;
import com.sales.savvy.enums.OrderStatus;
import com.sales.savvy.repository.OrderRepository;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired 
    private OrderRepository repo;

    @Override
    public void createOrder(OrderDTO orderDTO) {

        Order order = new Order();
        order.setAddress(orderDTO.getAddress());
        order.setStatus(OrderStatus.valueOf(orderDTO.getStatus().toUpperCase()));
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setUsername(orderDTO.getUsername());

        List<OrderItem> items = new ArrayList<>();

        for (OrderItemDTO dto : orderDTO.getItems()) {
            OrderItem item = new OrderItem();
            item.setProductId(dto.getProductId());
            item.setProductName(dto.getProductName());
            item.setPrice(dto.getPrice());
            item.setQuantity(dto.getQuantity());
            item.setSubtotal(dto.getSubtotal());
            item.setOrder(order);   // VERY IMPORTANT
            items.add(item);
        }

        order.setOrderItems(items);
        repo.save(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        List<Order> orders = repo.findAll();
        List<OrderDTO> dtos = new ArrayList<>();

        for (Order order : orders) {
            dtos.add(convertToDTO(order));
        }
        return dtos;
    }


    @Override
    public List<OrderDTO> getDeliveredOrders(String username) {

        List<Order> orders = repo.findByUsername(username);
        List<OrderDTO> delivered = new ArrayList<>();

        for (Order order : orders) {
            if (OrderStatus.DELIVERED.equals(order.getStatus())) {
                delivered.add(convertToDTO(order));
            }
        }
        return delivered;
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long orderId) {
        return repo.findById(orderId).map(this::convertToDTO);
    }

    // ---------------------------------------------------------
    // DTO Mapper
    // ---------------------------------------------------------
    private OrderDTO convertToDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setStatus(order.getStatus().toString());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setUsername(order.getUsername());

        List<OrderItemDTO> itemDtos = new ArrayList<>();

        for (OrderItem oi : order.getOrderItems()) {
            OrderItemDTO itemDto = new OrderItemDTO();
            itemDto.setProductId(oi.getProductId());
            itemDto.setProductName(oi.getProductName());
            itemDto.setPrice(oi.getPrice());
            itemDto.setQuantity(oi.getQuantity());
            itemDto.setSubtotal(oi.getSubtotal());
            itemDtos.add(itemDto);
        }

        dto.setItems(itemDtos);

        return dto;
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        return repo.save(order);
    }

}
