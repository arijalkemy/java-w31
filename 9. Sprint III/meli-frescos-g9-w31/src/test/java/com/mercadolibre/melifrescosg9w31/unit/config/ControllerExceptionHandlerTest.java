package com.mercadolibre.melifrescosg9w31.unit.config;

import com.mercadolibre.melifrescosg9w31.config.ControllerExceptionHandler;
import com.mercadolibre.melifrescosg9w31.dtos.ExceptionDTO;
import com.mercadolibre.melifrescosg9w31.exceptions.ApiError;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.newrelic.api.agent.NewRelic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

    private ControllerExceptionHandler controllerExceptionHandler;
    private MockedStatic<NewRelic> mockedNewRelic;
    private MockedStatic<LoggerFactory> mockedLoggerFactory;
    private Logger mockLogger;

    @BeforeEach
    void setUp() {
        controllerExceptionHandler = new ControllerExceptionHandler();
        mockedNewRelic = Mockito.mockStatic(NewRelic.class);
        mockedLoggerFactory = Mockito.mockStatic(LoggerFactory.class);
        mockLogger = mock(Logger.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
    }

    @AfterEach
    void tearDown() {
        mockedNewRelic.close();
        mockedLoggerFactory.close();
    }

    @Test
    void testBadRequest() {
        String errorMessage = "Invalid request data.";
        BadRequestException exception = new BadRequestException(errorMessage);

        ResponseEntity<?> responseEntity = controllerExceptionHandler.badRequest(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        ExceptionDTO exceptionDTO = (ExceptionDTO) responseEntity.getBody();
        assertEquals(errorMessage, exceptionDTO.getMessage());
    }

    @Test
    void testNotFound() {
        String errorMessage = "Resource not found.";
        NotFoundException exception = new NotFoundException(errorMessage);

        ResponseEntity<?> responseEntity = controllerExceptionHandler.notFound(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        ExceptionDTO exceptionDTO = (ExceptionDTO) responseEntity.getBody();
        assertEquals(errorMessage, exceptionDTO.getMessage());
    }

    @Test
    void testManejarValidacion() {
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError1 = new FieldError("objectName", "field1", "Error message 1");
        FieldError fieldError2 = new FieldError("objectName", "field2", "Error message 2");
        List<FieldError> fieldErrors = Arrays.asList(fieldError1, fieldError2);

        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

        ResponseEntity<Map<String, String>> responseEntity = controllerExceptionHandler.manejarValidacion(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        Map<String, String> errors = responseEntity.getBody();
        assertEquals(2, errors.size());
        assertEquals("Error message 1", errors.get("field1"));
        assertEquals("Error message 2", errors.get("field2"));
    }

    @Test
    void testHandleValidationExceptions() {
        String errorMessage = "Failed to convert http message.";
        HttpMessageConversionException exception = new HttpMessageConversionException(errorMessage);

        ResponseEntity<HttpMessageConversionException> responseEntity = controllerExceptionHandler.handleValidationExceptions(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(errorMessage, responseEntity.getBody().getMessage());
    }

    @Test
    void testNoHandlerFoundException() {
        String requestURL = "/nonexistent/path";
        NoHandlerFoundException exception = new NoHandlerFoundException("GET", requestURL, null);

        ResponseEntity<ApiError> responseEntity = controllerExceptionHandler.noHandlerFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        ApiError apiError = responseEntity.getBody();
        assertEquals("route_not_found", apiError.error()); // Changed from .code() to .error()
        assertEquals("Route " + requestURL + " not found", apiError.message()); // Changed from .description() to .message()
        assertEquals(HttpStatus.NOT_FOUND.value(), apiError.status());
    }

}
