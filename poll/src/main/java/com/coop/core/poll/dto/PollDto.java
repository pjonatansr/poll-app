package com.coop.core.poll.dto;

import lombok.Data;

@Data
public class PollDto {
  private Long id;
  private String description;
  private Integer durationMinutes;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getDurationMinutes() {
    return this.durationMinutes;
  }

  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

}
