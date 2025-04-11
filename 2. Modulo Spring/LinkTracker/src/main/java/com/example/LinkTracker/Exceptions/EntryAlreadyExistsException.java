package com.example.LinkTracker.Exceptions;

public class EntryAlreadyExistsException extends RuntimeException {
    
    public EntryAlreadyExistsException() {
    }

    public EntryAlreadyExistsException(String message) {
        super(message);
    }
}
