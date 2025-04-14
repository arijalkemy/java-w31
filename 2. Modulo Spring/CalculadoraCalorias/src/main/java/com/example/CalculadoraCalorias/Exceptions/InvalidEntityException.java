package com.example.CalculadoraCalorias.Exceptions;

public class InvalidEntityException extends RuntimeException {
    public InvalidEntityException() {
    }

    public InvalidEntityException(String message) {
        super(message);
    }
}