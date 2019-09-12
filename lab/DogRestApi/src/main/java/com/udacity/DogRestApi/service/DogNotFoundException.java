package com.udacity.DogRestApi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException() {
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
