package com.sales.savvy.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sales.savvy.entity.Review;
import com.sales.savvy.entity.User;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct_Id(Long productId);
    @Transactional
    @Modifying
    @Query("DELETE FROM Review r WHERE r.product.id = :productId")
    void deleteByProduct_Id(@Param("productId") Long productId);
    List<Review> findByUser_Id(UUID uuid);
}
