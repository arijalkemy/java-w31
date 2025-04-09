package org.mercadolibre.ejercicio_calculadoradecalorias.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
