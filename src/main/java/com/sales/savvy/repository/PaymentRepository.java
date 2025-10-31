package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sales.savvy.entity.Payment;
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
