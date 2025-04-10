package com.linktracker.linktracker.exception;

public class ExistElement extends RuntimeException{
    private String message;

    public ExistElement(){}
    public ExistElement(String message){
        super(message);
    }
}
