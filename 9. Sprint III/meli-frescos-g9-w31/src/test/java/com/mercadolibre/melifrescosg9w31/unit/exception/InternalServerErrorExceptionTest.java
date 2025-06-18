package com.mercadolibre.melifrescosg9w31.unit.exception;

import com.mercadolibre.melifrescosg9w31.exceptions.InternalServerErrorException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternalServerErrorExceptionTest {

    @Test
    void testConstructorWithThrowable() {
        Throwable cause = new RuntimeException("Original cause");
        InternalServerErrorException exception = new InternalServerErrorException(cause);

        assertEquals("internal_error", exception.getCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndThrowable() {
        String customMessage = "Something went wrong internally";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        InternalServerErrorException exception = new InternalServerErrorException(customMessage, cause);

        assertEquals("internal_error", exception.getCode());
        assertEquals(customMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}