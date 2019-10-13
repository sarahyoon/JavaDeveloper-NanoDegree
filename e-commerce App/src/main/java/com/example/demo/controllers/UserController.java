package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.EcommerceUser;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@GetMapping("/id/{id}")
	public ResponseEntity<EcommerceUser> findById(@PathVariable Long id) {
		return ResponseEntity.of(userRepository.findById(id));
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<EcommerceUser> findByUserName(@PathVariable String username) {
		EcommerceUser user = userRepository.findByUsername(username);
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
	
	@PostMapping("/create")
	public ResponseEntity<EcommerceUser> createUser(@RequestBody CreateUserRequest createUserRequest) {
		EcommerceUser user = new EcommerceUser();
		user.setUsername(createUserRequest.getUsername());
		log.info("User name set with value: " + createUserRequest.getUsername());
		Cart cart = new Cart();
		cartRepository.save(cart);
		user.setCart(cart);

		if (createUserRequest.getPassword().length() < 7 || createUserRequest.getPassword() == null
				|| !createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())) {
			log.error("Error with user password. Can not create {}", createUserRequest.getUsername());
			return ResponseEntity.badRequest().build();
		}
		user.setPassword(bcryptEncoder.encode(createUserRequest.getPassword()));
		userRepository.save(user);
		log.info("Create {} Success!", createUserRequest.getUsername());
		return ResponseEntity.ok(user);
	}

}
