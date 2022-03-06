package com.coop.core.poll.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.coop.core.common.model.BaseEntity;

@Entity
public class Poll extends BaseEntity {
  @Column(name = "description", nullable = false, length = 100)
  private String description;

  @Column(name = "duration_minutes", columnDefinition = "integer default 1", nullable = false)
  private Integer durationMinutes;

  @OneToMany(mappedBy = "poll", cascade = {
      CascadeType.ALL
  })
  private List<Session> sessions;

  /**
   * @return List<Session>
   */
  public List<Session> getSessions() {
    return this.sessions;
  }

  /**
   * @param sessions
   */
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

  /**
   * @return String
   */
  public String getDescription() {
    return description;
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
    return durationMinutes;
  }

  /**
   * @param durationMinutes
   */
  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }
}
