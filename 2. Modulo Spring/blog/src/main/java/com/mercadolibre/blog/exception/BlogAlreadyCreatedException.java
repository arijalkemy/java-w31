package com.mercadolibre.blog.exception;

public class BlogAlreadyCreatedException extends RuntimeException{
    public BlogAlreadyCreatedException(){

    }
    public BlogAlreadyCreatedException(String message){
        super(message);
    }
}
