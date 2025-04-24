package com.blog.blogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundBlogException.class)
    public ResponseEntity<?> notFound(NotFoundBlogException e){
        return new ResponseEntity<>(e.getMessage()  , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){
        return new ResponseEntity<>(e.getMessage()  , HttpStatus.BAD_REQUEST);
    }

}
