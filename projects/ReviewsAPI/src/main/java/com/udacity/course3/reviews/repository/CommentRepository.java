package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Integer> {

    List<Comments> findByReviewID(Integer reviewID);
}
