package com.bootcamp.obrasliterarias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObraNotFoundException extends RuntimeException {
    public ObraNotFoundException(String message) {
        super(message);
    }
}
