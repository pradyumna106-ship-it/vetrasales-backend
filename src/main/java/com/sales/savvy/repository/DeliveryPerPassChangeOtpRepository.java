package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.DeliveryPerPassChangeOtp;

public interface DeliveryPerPassChangeOtpRepository extends JpaRepository<DeliveryPerPassChangeOtp, Long> {
	DeliveryPerPassChangeOtp findByEmail(String deliveryEmail);
}
