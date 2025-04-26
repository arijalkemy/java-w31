package com.bootcamp.blog.exeptions;

public class DuplicatedEntryException extends RuntimeException {
    public DuplicatedEntryException(String message) {
        super(message);
    }
}
