package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.ReviewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewMongoRepository extends MongoRepository<ReviewDocument, Integer> {
}
