package com.linktracker.linktracker.exception;

public class NotExistElement extends RuntimeException{

    private String message;

    public NotExistElement(){}
    public NotExistElement(String message){
        super(message);
    }
}
