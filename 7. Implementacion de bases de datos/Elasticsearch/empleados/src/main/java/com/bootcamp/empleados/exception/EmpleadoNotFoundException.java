package com.bootcamp.empleados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(String message) {
        super(message);
    }
}
