package com.bootcamp.ejercicio_excepciones.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {}
    public AlreadyExistException(String message) {
        super(message);
    }
}
