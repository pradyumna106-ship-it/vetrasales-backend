package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.OrderDTO;
import dto.OrderItemDTO;
import entity.Customer;
import entity.OrderItem;
import entity.Orders;
import entity.Product;
import repository.CustomerRepository;
import repository.OrdersRepository;
import repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrdresServiceImplementation implements OrdersService {
	@Autowired private OrdersRepository orderRepo;

	@Autowired private ProductRepository productRepo;

	@Autowired private CustomerRepository cusRepo;

	@Override
	@Transactional
	public void createOrder(OrderDTO orderDTO) {
		Customer customer = cusRepo.findById(orderDTO.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + orderDTO.getCustomerId()));

		Orders orders = new Orders();
		orders.setCustomer(customer);
		orders.setAddress(orderDTO.getAddress());
		orders.setOrdertime(orderDTO.getOrdertime());
		orders.setPaymentId(orderDTO.getPaymentId());
		orders.setTotAmount(orderDTO.getTotAmount());

		if (orderDTO.getStatus() == null || orderDTO.getStatus().trim().isEmpty()) {
			orders.setStatus("PENDING");
		} else {
			orders.setStatus(orderDTO.getStatus().trim());
		}

		List<OrderItem> orderItems = new ArrayList<>();
		for (OrderItemDTO itemDto : orderDTO.getItems()) {
			Product product = productRepo.findById(itemDto.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found: " + itemDto.getProductId()));

			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemDto.getQuantity());
			orderItem.setOrders(orders);
			orderItems.add(orderItem);
		}

		orders.setItems(orderItems);
		orderRepo.save(orders);

		System.out.println("Final saved status: " + orders.getStatus());
	}

	@Override
	public List<OrderDTO> listOfOrders(Long customerId) {
		List<Orders> orders = orderRepo.findByCustomerId(customerId);

		List<OrderDTO> orderDTOs = new ArrayList<>();

		for (Orders order : orders) {
			List<OrderItemDTO> itemDTOs = new ArrayList<>();

			for (OrderItem item : order.getItems()) {
				Product product = item.getProduct();
				OrderItemDTO itemDTO = new OrderItemDTO();
				itemDTO.setQuantity(item.getQuantity());
				itemDTO.setProductId(product.getId());
				System.out.println(product.getId());
				itemDTOs.add(itemDTO);
			}

			OrderDTO dto = new OrderDTO();
			dto.setPaymentId(order.getPaymentId());
			dto.setOrdertime(order.getOrdertime());
			dto.setTotAmount(order.getTotAmount());
			dto.setItems(itemDTOs);
			dto.setStatus(order.getStatus());
			dto.setAddress(order.getAddress());

			orderDTOs.add(dto);
		}

		return orderDTOs;
	}

	@Override
	public List<Orders> getDeliveredOrders(Long cusId) {
	    Optional<Customer> cus = cusRepo.findById(cusId);
	    List<Orders> orders = cus.get().getOrders();
	    List<Orders> delOrders = new ArrayList<>();

	    for (Orders order : orders) {
	        if ((order.getStatus()).equals("DELIVERED")){
	            delOrders.add(order); 
	        }
	    }

	    return delOrders;
	}

	@Override
	public Optional<Orders> getOrderById(Long orderId) {
		return orderRepo.findById(orderId);
	}
}
