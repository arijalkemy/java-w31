package com.example.egcontrolleradvice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(annotations = RestController.class) // la anotacion de spring para excepciones
public class GlobalExceptionHandler {

    // esta clase es nuestro manejador de excepciones aca creamos nuestros metodos que vana  devolver nuestra
    // excepcion personalizada, esto para un mejor manejo de errores.
    // MOstramos el mensaje de errror y ademas el codigo de salida
    @ExceptionHandler(NotFoundException.class) // le decimos que excepcion es
    public ResponseEntity<?> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    public ResponseEntity<?> BadRequestException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
