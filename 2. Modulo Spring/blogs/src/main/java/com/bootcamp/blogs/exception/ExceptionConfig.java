package com.bootcamp.blogs.exception;

import com.bootcamp.blogs.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(YaExisteException.class)
    public ResponseEntity<?> blogExistente(YaExisteException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.CONFLICT);
    }
}
