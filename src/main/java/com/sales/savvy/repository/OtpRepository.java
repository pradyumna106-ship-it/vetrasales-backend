package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {
	Otp findByEmail(String email);
}
