package com.coop.core.poll.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.coop.core.common.model.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Poll extends BaseEntity {
  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "duration_minutes", columnDefinition = "integer default 1", nullable = false)
  private Integer durationMinutes;

  @OneToMany(mappedBy = "poll", cascade = {
      CascadeType.ALL
  })
  private List<Session> sessions;

  public List<Session> getSessions() {
    return this.sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  public Poll(String description, Integer durationMinutes) {
    this.description = description;
    this.durationMinutes = durationMinutes;
  }

  public Poll(String description) {
    this.description = description;
  }

  public Poll() {
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
