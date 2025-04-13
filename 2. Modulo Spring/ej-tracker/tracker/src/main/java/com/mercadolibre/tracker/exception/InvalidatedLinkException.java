package com.mercadolibre.tracker.exception;

public class InvalidatedLinkException extends RuntimeException {
    public InvalidatedLinkException(String message) {
        super(message);
    }
}
