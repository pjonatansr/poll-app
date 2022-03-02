package com.coop.core.poll.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PollSession {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  private Poll poll;

  @Column(name = "start_date")
  private Date startDate;

  @OneToMany(targetEntity = Vote.class)
  private List<Vote> vows;

  public PollSession(Poll poll) {
    this.poll = poll;
    this.startDate = new Date();
  }

  public PollSession(Poll poll, Date startDate) {
    this.poll = poll;
    this.startDate = startDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Poll getPoll() {
    return poll;
  }

  public void setPoll(Poll poll) {
    this.poll = poll;
  }

  public Date getStartDate() {
    return startDate;
  }

  public List<Vote> getVows() {
    return vows;
  }

  public void setVows(List<Vote> vows) {
    this.vows = vows;
  }
}
