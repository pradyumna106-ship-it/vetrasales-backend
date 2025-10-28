package service;
import java.util.List;

import entity.Review;
public interface ReviewService {

	List<Review> listOfReview(Long productId);

	String avgReview(Long productId);
}
