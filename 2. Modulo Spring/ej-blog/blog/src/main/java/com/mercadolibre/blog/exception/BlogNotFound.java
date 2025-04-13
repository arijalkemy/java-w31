package com.mercadolibre.blog.exception;

public class BlogNotFound extends RuntimeException {
    public BlogNotFound() {
    }

    public BlogNotFound(String message) {
        super(message);
    }
}
