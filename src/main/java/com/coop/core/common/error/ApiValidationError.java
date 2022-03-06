package com.coop.core.common.error;

public class ApiValidationError extends ApiSubError {
  private String object;
  private String field;
  private Object rejectedValue;
  private String message;

  
  /** 
   * @return String
   */
  public String getObject() {
    return this.object;
  }

  
  /** 
   * @param object
   */
  public void setObject(String object) {
    this.object = object;
  }

  
  /** 
   * @return String
   */
  public String getField() {
    return this.field;
  }

  
  /** 
   * @param field
   */
  public void setField(String field) {
    this.field = field;
  }

  
  /** 
   * @return Object
   */
  public Object getRejectedValue() {
    return this.rejectedValue;
  }

  
  /** 
   * @param rejectedValue
   */
  public void setRejectedValue(Object rejectedValue) {
    this.rejectedValue = rejectedValue;
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

  public ApiValidationError(String object, String message) {
    this.object = object;
    this.message = message;
  }
}