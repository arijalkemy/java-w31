package com.example.ConcesionariaAutos.Exceptions;

public class InvalidEntityException extends RuntimeException {
    public InvalidEntityException() {
    }

    public InvalidEntityException(String message) {
        super(message);
    }
}