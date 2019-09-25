package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

     List<Product> findById(int id);

}
