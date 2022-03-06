package com.coop.core.poll.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.coop.core.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Session extends BaseEntity {
  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "poll_id")
  private Poll poll;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  
  /** 
   * @return LocalDateTime
   */
  public LocalDateTime getStartDate() {
    return this.startDate;
  }

  
  /** 
   * @param startDate
   */
  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public Session() {
  }

  public Session(Poll poll) {
    this.poll = poll;
    this.startDate = LocalDateTime.now();
  }

  public Session(Poll poll, LocalDateTime startDate) {
    this.poll = poll;
    this.startDate = startDate;
  }

  
  /** 
   * @return Poll
   */
  public Poll getPoll() {
    return poll;
  }

  
  /** 
   * @param poll
   */
  public void setPoll(Poll poll) {
    this.poll = poll;
  }
}
