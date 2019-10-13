package com.example.demo.model.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.persistence.EcommerceUser;
import com.example.demo.model.persistence.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
	List<UserOrder> findByUser(EcommerceUser user);
}
