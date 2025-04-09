package com.mercadolibre.maolaya.ejercicio_blog.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdDuplicatedException extends RuntimeException {
    public IdDuplicatedException(String message) {
        super(message);
    }
}
