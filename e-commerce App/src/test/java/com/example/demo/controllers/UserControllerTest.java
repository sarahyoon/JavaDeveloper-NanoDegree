package com.example.demo.controllers;

import com.example.demo.model.persistence.EcommerceUser;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import com.example.demo.TestUnits;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserController userController;

    private UserRepository userRepository = mock(UserRepository.class);

    private CartRepository cartRepository = mock(CartRepository.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);

    @Before
    public void setup() {
        userController = new UserController();
        TestUnits.injectObjects(userController, "userRepository", userRepository);
        TestUnits.injectObjects(userController, "cartRepository", cartRepository);
        TestUnits.injectObjects(userController, "bcryptEncoder", bCryptPasswordEncoder);
    }

    @Test
    public void create_user_happy_path() throws Exception {
        when(bCryptPasswordEncoder.encode("testpassword")).thenReturn("hashedPassword");

        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("test");
        userRequest.setPassword("testpassword");
        userRequest.setConfirmPassword("testpassword");

        ResponseEntity<EcommerceUser> response = userController.createUser(userRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        EcommerceUser user = response.getBody();
        assertNotNull(user);
        assertEquals(0, user.getId());
        assertEquals("test", user.getUsername());
        assertEquals("hashedPassword", user.getPassword());
    }

    @Test
    public void create_user_error_path() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("test");
        userRequest.setPassword("testpassword");
        userRequest.setConfirmPassword("testpassword!!");

        ResponseEntity<EcommerceUser> response = userController.createUser(userRequest);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void find_user_happy_path() {
        EcommerceUser user = new EcommerceUser();
        user.setId((long)1);
        user.setUsername("test");
        user.setPassword("password");

        when(userRepository.findByUsername("test")).thenReturn(user);

        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("test");
        userRequest.setPassword("testpassword");
        userRequest.setConfirmPassword("testpassword");

        userController.createUser(userRequest);

        ResponseEntity<EcommerceUser> response = userController.findByUserName("test");

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test", user.getUsername());
    }

    @Test
    public void find_user_error_path() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("test");
        userRequest.setPassword("testpassword");
        userRequest.setConfirmPassword("testpassword");

        ResponseEntity<EcommerceUser> findUser = userController.findByUserName("test_user");

        assertNotNull(userController.findByUserName("test_user"));
        assertEquals(HttpStatus.NOT_FOUND, findUser.getStatusCode());
    }

    @Test
    public void find_by_id_happy_path() {
        EcommerceUser user = new EcommerceUser();
        user.setId(1);
        user.setUsername("test");
        user.setPassword("testpassword");
        when(userRepository.findById((long)1)).thenReturn(java.util.Optional.of(user));

        ResponseEntity<EcommerceUser> response = userController.findById((long)1);

        assertNotNull(response);
        assertEquals("test", response.getBody().getUsername());
    }

}
