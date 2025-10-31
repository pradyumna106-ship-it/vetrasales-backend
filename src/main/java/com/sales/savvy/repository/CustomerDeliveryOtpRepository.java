package com.sales.savvy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.CustomerDeliveryOtp;

public interface CustomerDeliveryOtpRepository extends JpaRepository<CustomerDeliveryOtp, Long> {
	Optional<CustomerDeliveryOtp> findByOrderId(Long orderId);
}
