package com.review.repository;

import com.review.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource
public interface ReviewRepository extends CrudRepository <Review, UUID> {
    Optional<Review> findById(UUID id);

    @RestResource(path = "/driver")
    Iterable<Review> findAllByDriverId(@Param("id") long driver_id);}
