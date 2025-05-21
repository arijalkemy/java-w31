package com.mercadolibre.showroom.exception;

public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
