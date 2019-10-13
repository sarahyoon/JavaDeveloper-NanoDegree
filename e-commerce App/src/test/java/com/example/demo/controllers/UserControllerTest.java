package com.example.demo.controllers;

import com.example.demo.model.persistence.EcommerceUser;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import org.junit.Before;
import org.junit.Test;
import com.example.demo.TestUnits;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserController userController;

    private UserRepository userRepository = mock(UserRepository.class);

    private CartRepository cartRepository = mock(CartRepository.class);

    private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);


    @Before
    public void setUp(){

        userController = new UserController();
        TestUnits.injectObjects(userController, "userRepository", userRepository);
        TestUnits.injectObjects(userController, "cartRepository", cartRepository);
        TestUnits.injectObjects(userController, "bcryptEncoder", encoder);
    }

    @Test
    public void create_user_happy_path() throws Exception{
        when(encoder.encode("testpassword")).thenReturn("thisIsHashed");

        CreateUserRequest r = new CreateUserRequest();
        r.setUsername("sarah");
        r.setPassword("testpassword");
        r.setConfirmPassword("testpassword");

        final ResponseEntity<EcommerceUser> response = userController.createUser(r);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        EcommerceUser u = response.getBody();
        assertNotNull(u);
        assertEquals(0, u.getId());
        assertEquals("sarah", u.getUsername());
        assertEquals("thisIsHashed", u.getPassword());
    }
}
