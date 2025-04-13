package com.linktracker.link.exception;

import com.linktracker.link.dto.ErrorMsgDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> idNotFoundException(Exception e) {
        return new ResponseEntity<ErrorMsgDTO>(new ErrorMsgDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
