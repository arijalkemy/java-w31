package com.mercadolibre.consigna.exception;

public class DuplicateBlogIdException extends RuntimeException {
    public DuplicateBlogIdException(String message) {
        super(message);
    }
}
