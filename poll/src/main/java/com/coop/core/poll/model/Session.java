package com.coop.core.poll.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.coop.core.common.model.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Session extends BaseEntity {
  @ManyToOne
  private Poll poll;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  public LocalDateTime getStartDate() {
    return this.startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  @OneToMany(targetEntity = Vote.class)
  private List<Vote> vows;

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

  public Poll getPoll() {
    return poll;
  }

  public void setPoll(Poll poll) {
    this.poll = poll;
  }

  public List<Vote> getVows() {
    return vows;
  }
}
