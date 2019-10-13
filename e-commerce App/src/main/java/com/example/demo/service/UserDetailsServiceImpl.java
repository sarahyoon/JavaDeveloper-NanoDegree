package com.example.demo.service;

import com.example.demo.model.persistence.EcommerceUser;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        EcommerceUser ecommerceUser = userRepository.findByUsername(username);
        if(ecommerceUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(ecommerceUser.getUsername(),
                ecommerceUser.getPassword(), Collections.emptyList());
    }
}
