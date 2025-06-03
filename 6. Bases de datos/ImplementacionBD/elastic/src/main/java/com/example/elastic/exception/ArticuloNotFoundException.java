package com.example.elastic.exception;

public class ArticuloNotFoundException extends RuntimeException {
    public ArticuloNotFoundException(String id) {
        super("Artículo no encontrado con ID: " + id);
    }
} 