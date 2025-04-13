package org.example.manejoexcepcionesp1.exception;

public class RepetidoException extends RuntimeException{
    public RepetidoException(){};

    public RepetidoException(String message){
        super(message);
    };
}
