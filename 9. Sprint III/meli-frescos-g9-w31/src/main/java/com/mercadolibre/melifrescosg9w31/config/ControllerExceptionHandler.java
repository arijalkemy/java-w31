package com.mercadolibre.melifrescosg9w31.config;

import com.mercadolibre.melifrescosg9w31.dtos.ExceptionDTO;
import com.mercadolibre.melifrescosg9w31.exceptions.*;
import com.newrelic.api.agent.NewRelic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Global exception handler for the application. Handles various types of exceptions and converts
 * them to appropriate HTTP responses.
 * Basic handling for exceptions.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new ConcurrentHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<HttpMessageConversionException> handleValidationExceptions(HttpMessageConversionException ex) {
        HttpMessageConversionException customException = new HttpMessageConversionException(ex.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorized(UnauthorizedException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> alreadyExist(AlreadyExistsException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    /**
     * Handler for not found routes.
     *
     * @param ex the exception thrown when route is not found.
     * @return {@link ResponseEntity} with 404 status code and the route that was
     * not found in the body.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiError> noHandlerFoundException(NoHandlerFoundException ex) {
        ApiError apiError = new ApiError(
                "route_not_found",
                String.format("Route %s not found", ex.getRequestURL()),
                HttpStatus.NOT_FOUND.value());
        return ResponseEntity
                .status(apiError.status())
                .body(apiError);
    }

    /**
     * Handler for external API exceptions.
     *
     * @param e the exception thrown during a request to external API.
     * @return {@link ResponseEntity} with status code and description provided for the handled
     * exception.
     */
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ApiError> handleApiException(ApiException e) {
        Integer statusCode = e.getStatusCode();
        boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode;
        NewRelic.noticeError(e, expected);
        if (expected) {
            LOGGER.warn("Internal Api warn. Status Code: {}", statusCode, e);
        } else {
            LOGGER.error("Internal Api error. Status Code: {}", statusCode, e);
        }

        ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
        return ResponseEntity.status(statusCode).body(apiError);
    }

    /**
     * Handler for HttpClientErrorException.BadRequest.
     *
     * @param e the exception thrown for bad HTTP requests.
     * @return {@link ResponseEntity} with 400 status code.
     */
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<ApiError> handleBadRequestException(
            HttpClientErrorException.BadRequest e) {
        LOGGER.warn("HTTP Bad request: {}", e.getMessage());
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "http_bad_request", "Bad request to external service", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

  /**
   * Handler for internal exceptions.
   *
   * @param e the exception thrown during request processing.
   * @return {@link ResponseEntity} with 500 status code and description indicating an internal error.
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
    LOGGER.error("Internal error", e);
    NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "internal_error", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    // ==================== Helper Methods ====================

    /**
     * Formats a field error for better readability.
     *
     * @param fieldError the field error to format.
     * @return formatted error message.
     */
    private String formatFieldError(FieldError fieldError) {
        return String.format("Field '%s': %s", fieldError.getField(), fieldError.getDefaultMessage());
    }
}
