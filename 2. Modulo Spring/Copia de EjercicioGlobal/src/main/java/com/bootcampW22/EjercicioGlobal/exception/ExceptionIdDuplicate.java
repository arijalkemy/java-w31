package com.bootcampW22.EjercicioGlobal.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ExceptionIdDuplicate extends RuntimeException{
    private String message;

    public ExceptionIdDuplicate(String message){
        super(message);
    }
}
