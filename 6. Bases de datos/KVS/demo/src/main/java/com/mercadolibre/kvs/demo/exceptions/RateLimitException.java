package com.mercadolibre.kvs.demo.exceptions;

public class RateLimitException extends RuntimeException {
    public RateLimitException(String message) {
        super(message);
    }
}