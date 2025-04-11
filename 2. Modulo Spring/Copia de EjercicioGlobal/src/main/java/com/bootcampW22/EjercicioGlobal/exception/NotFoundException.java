package com.bootcampW22.EjercicioGlobal.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message){
        super(message);
    }

}
