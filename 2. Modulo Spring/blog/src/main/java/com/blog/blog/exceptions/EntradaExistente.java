package com.blog.blog.exceptions;

public class EntradaExistente extends RuntimeException{

    public EntradaExistente(){}
    public EntradaExistente(String message){
        super(message);
    }
}
