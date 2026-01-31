package com.sales.savvy.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sales.savvy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


	@Query("SELECT p FROM Product p WHERE " +
		       "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		List<Product> searchProduct(String keyword);
		List<Product> findByAdminId(UUID id);
		Optional<Product> findByName(String name);
}
