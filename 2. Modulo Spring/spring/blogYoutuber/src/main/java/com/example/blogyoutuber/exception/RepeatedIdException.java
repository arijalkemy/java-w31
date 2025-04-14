package com.example.blogyoutuber.exception;

public class RepeatedIdException extends RuntimeException {
    public RepeatedIdException(int id) {
        super("Id " + id + " repeated");

    }
}
