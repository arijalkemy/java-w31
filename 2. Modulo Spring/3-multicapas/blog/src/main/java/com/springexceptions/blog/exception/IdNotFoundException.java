package com.springexceptions.blog.exception;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException() {
    }

    public IdNotFoundException(String message) {
        super(message);
    }

}
