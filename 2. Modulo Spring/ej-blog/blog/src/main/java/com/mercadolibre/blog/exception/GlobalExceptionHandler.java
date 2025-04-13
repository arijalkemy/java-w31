package com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogNotFound.class)
    public ResponseEntity<String> handleBlogNotFound(BlogNotFound exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogConflict.class)
    public ResponseEntity<String> handleBlogConflict(BlogConflict exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
