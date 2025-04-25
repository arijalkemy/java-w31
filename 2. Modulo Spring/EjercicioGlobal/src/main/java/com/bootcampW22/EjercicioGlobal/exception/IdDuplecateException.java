package com.bootcampW22.EjercicioGlobal.exception;

public class IdDuplecateException extends RuntimeException{
    private String message;

    public IdDuplecateException(String message){
        super(message);
    }
}
