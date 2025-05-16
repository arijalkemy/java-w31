package com.bootcamp.joyerialasperlas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class JoyaNotFoundException extends RuntimeException {
    public JoyaNotFoundException(String message) {
        super(message);
    }
}
