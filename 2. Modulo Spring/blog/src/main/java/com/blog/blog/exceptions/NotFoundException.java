package com.blog.blog.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){}
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
