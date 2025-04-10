package com.linktracker.linktracker.exception;

public class LinkNoValido extends RuntimeException{
    private String message;

    public LinkNoValido(){}
    public LinkNoValido(String message){
        super(message);
    }
}
