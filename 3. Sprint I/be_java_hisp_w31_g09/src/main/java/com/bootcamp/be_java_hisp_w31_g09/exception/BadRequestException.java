package com.bootcamp.be_java_hisp_w31_g09.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
