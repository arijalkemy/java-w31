package com.mercadolibre.be_java_hisp_w31_g02.exception;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String message) {
        super(message);
    }

}
