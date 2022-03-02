package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.coop.core.common.model.BaseEntity;

@Entity
public class Poll extends BaseEntity {
  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "duration_minutes", columnDefinition = "integer default 1", nullable = false)
  private Integer durationMinutes;

  public Poll(String description, Integer durationMinutes) {
    this.description = description;
    this.durationMinutes = durationMinutes;
  }

  public Poll(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getDurationMinutes() {
    return durationMinutes;
  }

  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }
}
