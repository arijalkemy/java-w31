package com.mercadolibreexample.link.exception;

public class LinkInvalidException extends RuntimeException {
    public LinkInvalidException(int id) {
        super("El link con ID: " + id + " está invalidado.");
    }
}

