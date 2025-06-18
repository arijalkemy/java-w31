package com.mercadolibre.melifrescosg9w31.exceptions;

/**
 * Record containing relevant information from an API call error.
 *
 * @param error   error short description.
 * @param message full error message.
 * @param status HTTP Status.
 * */
public record ApiError(String error, String message, Integer status) {

  /**
   * Creates a new instance, with empty fields.
   * This constructor is provided for compatibility with frameworks that require a no-args constructor.
   */
  public ApiError() {
    this(null, null, null);
  }
}
