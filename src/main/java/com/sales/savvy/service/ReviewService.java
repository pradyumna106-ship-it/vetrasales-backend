package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.entity.Review;

public interface ReviewService {
	List<Review> listOfReview(Long productId);
	String deleteReview(Long reviewId, String username, boolean isAdmin);
	String deleteAllReviews();
	String deleteReviewsByProduct(Long productId);
	List<Review> allReviews();
}
