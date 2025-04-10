package com.linktracker.linktracker.exception;

public class PasswordIncorrecto extends RuntimeException{
    private String message;

    public PasswordIncorrecto(){}
    public PasswordIncorrecto(String message){ super(message);}

}
