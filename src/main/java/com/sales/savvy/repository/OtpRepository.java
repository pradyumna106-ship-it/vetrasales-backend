package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {
	Otp findByEmail(String email);
}
