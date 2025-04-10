package com.mercadolibre.maolaya.ejercicio_links.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String message) {
        super(message);
    }
}
