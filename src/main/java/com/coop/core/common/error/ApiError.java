package com.coop.core.common.error;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

public class ApiError {

  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String debugMessage;
  private List<ApiSubError> subErrors;

  
  /** 
   * @return HttpStatus
   */
  public HttpStatus getStatus() {
    return this.status;
  }

  
  /** 
   * @param status
   */
  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  
  /** 
   * @return LocalDateTime
   */
  public LocalDateTime getTimestamp() {
    return this.timestamp;
  }

  
  /** 
   * @param timestamp
   */
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  
  /** 
   * @return String
   */
  public String getMessage() {
    return this.message;
  }

  
  /** 
   * @param message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  
  /** 
   * @return String
   */
  public String getDebugMessage() {
    return this.debugMessage;
  }

  
  /** 
   * @param debugMessage
   */
  public void setDebugMessage(String debugMessage) {
    this.debugMessage = debugMessage;
  }

  
  /** 
   * @return List<ApiSubError>
   */
  public List<ApiSubError> getSubErrors() {
    return this.subErrors;
  }

  
  /** 
   * @param subErrors
   */
  public void setSubErrors(List<ApiSubError> subErrors) {
    this.subErrors = subErrors;
  }

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  ApiError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }
}
