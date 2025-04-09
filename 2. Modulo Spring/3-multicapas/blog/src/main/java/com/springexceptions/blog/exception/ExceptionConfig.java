package com.springexceptions.blog.exception;

import com.springexceptions.blog.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(IdAlreadyInUseException.class)
    public ResponseEntity<?> idAlreadyInUseException(Exception e) {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> idNotFoundException(Exception e) {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
