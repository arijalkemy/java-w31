package com.mercadolibre.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSePudoCrearElLinkException.class)
    public ResponseEntity<?> noSePudoCrear(Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> notFound(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

