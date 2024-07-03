package com.review.repository;

import com.review.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends CrudRepository <Review, UUID> {
    Optional<Review> findById(UUID id);
    Review save(Review review);
}
