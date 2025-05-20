package com.mercadolibre.empresa_seguros.exception;

public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
