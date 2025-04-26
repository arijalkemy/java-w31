package com.bootcamp.blog.exeptions;

public class NotFoundEntryException extends RuntimeException {
    public NotFoundEntryException(String message) {
        super(message);
    }
}
