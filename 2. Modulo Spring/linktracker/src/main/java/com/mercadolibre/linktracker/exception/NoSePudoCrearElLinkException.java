package com.mercadolibre.linktracker.exception;


public class NoSePudoCrearElLinkException extends RuntimeException{
    public NoSePudoCrearElLinkException(){
    }
    public NoSePudoCrearElLinkException(String message){
        super(message);
    }
}
