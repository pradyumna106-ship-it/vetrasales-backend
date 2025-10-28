package service;
import java.util.List;
import java.util.Optional;

import dto.OrderDTO;
import entity.Orders;
public interface OrdersService {
	void createOrder(OrderDTO order);

	List<OrderDTO> listOfOrders(Long id);

	List<Orders> getDeliveredOrders(Long cusId);

	Optional<Orders> getOrderById(Long orderId);


}
