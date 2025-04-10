package com.linktracker.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalException {

    @ExceptionHandler(ExistElement.class)
    public ResponseEntity<?> existElement(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(NotExistElement.class)
    public ResponseEntity<?> notExistElement(Exception e){
        return ResponseEntity.status(404).body("El elemento no se encontro");
    }

    @ExceptionHandler(LinkNoValido.class)
    public ResponseEntity<?> linkNoValido(Exception e){
        return ResponseEntity.status(404).body("El Link no es valido");
    }

    public ResponseEntity<?> passwordIncorrecto(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
    }
}
