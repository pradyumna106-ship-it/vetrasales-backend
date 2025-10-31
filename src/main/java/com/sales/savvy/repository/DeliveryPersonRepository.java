package com.sales.savvy.repository;

import java.util.List;
import java.util.Optional;
import com.sales.savvy.entity.DeliveryPerson;
import com.sales.savvy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
	Optional<DeliveryPerson> findByEmail(String email);

	List<Orders> findByDeliveryPersonId(Long id);

	Optional<DeliveryPerson> getByEmail(String deliveryEmail);
}
