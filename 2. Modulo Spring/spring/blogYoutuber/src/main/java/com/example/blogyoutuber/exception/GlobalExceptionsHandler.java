package com.example.blogyoutuber.exception;

import com.example.blogyoutuber.dto.ExceptionDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(RepeatedIdException.class)
    public ExceptionDTO handleReapeatedIdException(RepeatedIdException ex) {
        return new ExceptionDTO(ex.getMessage());
    }
}
