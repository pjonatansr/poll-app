package com.coop.core.poll.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class PollDto {
  @NotNull
  private String description;
  private Integer durationMinutes;
  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  public PollDto(@NotNull String description, Integer durationMinutes, @NotNull LocalDateTime startDate) {
    this.description = description;
    this.durationMinutes = durationMinutes;
    this.startDate = startDate;
  }

  
  /** 
   * @return String
   */
  public String getDescription() {
    return this.description;
  }

  
  /** 
   * @param description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  
  /** 
   * @return Integer
   */
  public Integer getDurationMinutes() {
    return this.durationMinutes;
  }

  
  /** 
   * @param durationMinutes
   */
  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

  
  /** 
   * @return LocalDateTime
   */
  public LocalDateTime getStartDate() {
    return startDate;
  }

  
  /** 
   * @param startDate
   */
  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

}
