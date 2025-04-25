package com.bootcampW22.EjercicioGlobal.exception;

public class IdDuplicateException extends RuntimeException{
    private String message;

    public IdDuplicateException(String message){
        super(message);
    }
}
