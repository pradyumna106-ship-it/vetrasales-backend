package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.DeliveryPerPassChangeOtp;

public interface DeliveryPerPassChangeOtpRepository extends JpaRepository<DeliveryPerPassChangeOtp, Long> {
	DeliveryPerPassChangeOtp findByEmail(String deliveryEmail);
}
