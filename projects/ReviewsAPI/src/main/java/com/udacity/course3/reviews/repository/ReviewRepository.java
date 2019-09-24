package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByProductID(Integer productID);
}

