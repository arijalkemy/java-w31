package com.bootcampW22.EjercicioGlobal.exception;

import javax.management.InstanceAlreadyExistsException;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
