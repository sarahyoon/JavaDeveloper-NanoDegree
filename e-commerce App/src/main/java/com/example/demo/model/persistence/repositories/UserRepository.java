package com.example.demo.model.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.persistence.EcommerceUser;

public interface UserRepository extends JpaRepository<EcommerceUser, Long> {
	EcommerceUser findByUsername(String username);
}
