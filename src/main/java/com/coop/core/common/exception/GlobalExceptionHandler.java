package com.coop.core.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import com.coop.core.common.error.ApiError;
import com.coop.core.common.error.ApiSubError;
import com.coop.core.common.error.ApiValidationError;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Value("${reflectoring.trace:false}")
  private boolean printStackTrace;

  @Override
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    ApiError errorResponse = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY,
        "Validation error. Check 'errors' field for details.", ex);

    List<ApiSubError> validationErrors = ex.getBindingResult().getFieldErrors().stream()
        .map(f -> new ApiValidationError(f.getField(), f.getDefaultMessage()))
        .collect(Collectors.toList());

    errorResponse.setSubErrors(validationErrors);

    return ResponseEntity.unprocessableEntity().body(errorResponse);
  }

  @ExceptionHandler(NoSuchElementFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException itemNotFoundException,
      WebRequest request) {
    return buildErrorResponse(itemNotFoundException, HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> handleValidationException(
      ValidationException exception,
      WebRequest request) {
    return buildErrorResponse(exception, exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, request);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {

    return buildErrorResponse(exception, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  private ResponseEntity<Object> buildErrorResponse(Exception exception,
      HttpStatus httpStatus,
      WebRequest request) {

    return buildErrorResponse(exception, exception.getLocalizedMessage(), httpStatus, request);
  }

  private ResponseEntity<Object> buildErrorResponse(Exception exception,
      String message,
      HttpStatus httpStatus,
      WebRequest request) {
    ApiError errorResponse = new ApiError(httpStatus, message, exception);

    logger.error(errorResponse.getDebugMessage(), exception);

    return ResponseEntity.status(httpStatus).body(errorResponse);
  }

  @Override
  public ResponseEntity<Object> handleExceptionInternal(
      Exception exception,
      Object body,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    return buildErrorResponse(exception, status, request);
  }
}