package com.mercadolibre.be_java_hisp_w31_g02.exception;

import com.mercadolibre.be_java_hisp_w31_g02.dto.ExceptionDto;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflict(ConflictException exception){
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationException(ConstraintViolationException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

}
