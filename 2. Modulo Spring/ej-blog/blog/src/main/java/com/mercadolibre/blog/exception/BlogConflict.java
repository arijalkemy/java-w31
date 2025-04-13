package com.mercadolibre.blog.exception;

public class BlogConflict extends RuntimeException {

    public BlogConflict() {
    }

    public BlogConflict(String message) {
        super(message);
    }
}
