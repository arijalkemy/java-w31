package com.example.ejlinkertracker.exception;

public class InstanceAlreadyExistsException extends RuntimeException {
    public InstanceAlreadyExistsException(String message) {
        super(message);
    }
}
