package com.example.egcontrolleradvice.exception;


// aca creamos nuestra clase que representa la excepcion personalizada que queremos devolver
public class NotFoundException extends RuntimeException{

    public NotFoundException(){}

    // Con esto ahora podemos crear nuestra excepcion y lanzarla, haciendo
    // throw new NotfoundException("mensaje personalizado");
    // esto lo hacemos donde queramos lanzar la excepxion en nuestro codigo
    public NotFoundException(String message){
        super(message);
    }
}
