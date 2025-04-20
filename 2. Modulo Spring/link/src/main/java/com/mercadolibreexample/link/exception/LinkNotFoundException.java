package com.mercadolibreexample.link.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(int id) {
        super("No se encontró el link con ID: " + id);
    }
}

