package com.mercadolibreexample.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BlogAlreadyExistException extends RuntimeException {
    public BlogAlreadyExistException(String message) {
        super(message);
    }
}
