package com.sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sales.savvy.entity.Review;
public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByProductId(Long productId);
}
