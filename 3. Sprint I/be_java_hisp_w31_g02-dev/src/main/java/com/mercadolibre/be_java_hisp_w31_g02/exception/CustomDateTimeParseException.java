package com.mercadolibre.be_java_hisp_w31_g02.exception;


public class CustomDateTimeParseException extends RuntimeException {
    public CustomDateTimeParseException(String message) {
        super(message);
    }
}
