package com.bootcamp.ej_blog.exception;

public class BlogAlreadyExistsException extends RuntimeException {
    public BlogAlreadyExistsException(int id) {
        super("Ya existe el blog con id: " + id);
    }
}
