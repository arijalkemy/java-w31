package com.bootcamp.blogs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class YaExisteException extends RuntimeException{
    public YaExisteException(String message) {
        super(message);
    }
}
