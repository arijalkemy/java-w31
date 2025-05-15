package com.mercadolibre.kvs.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(NoSuchElementException.class)
        public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(RateLimitException.class)
        public ResponseEntity<String> handleRateLimit(RateLimitException ex) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(ex.getMessage());
        }
    }
