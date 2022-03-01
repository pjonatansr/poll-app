package com.coop.example.poll.model;

import java.util.Date;

public class PollSession {
  private Poll poll;
  private Date startDate;

  public PollSession(Poll poll) {
    this.poll = poll;
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

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void startSession() {
    this.setStartDate(new Date());
  }
}
