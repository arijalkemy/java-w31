package com.bootcamp.ejercicio_qatesters.configuration;

import com.bootcamp.ejercicio_qatesters.dto.ErrorDto;
import com.bootcamp.ejercicio_qatesters.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorDto> notFoundException(NotFoundException e) {
    return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
  }
}
