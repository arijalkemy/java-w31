package com.mercadolibre.bootcamp.blog.exceptions;

public class ConflictExcetion extends RuntimeException {
    public ConflictExcetion(String message) {
        super(message);
    }
}
