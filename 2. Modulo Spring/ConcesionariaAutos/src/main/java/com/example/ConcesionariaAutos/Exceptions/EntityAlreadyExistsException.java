package com.example.ConcesionariaAutos.Exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
