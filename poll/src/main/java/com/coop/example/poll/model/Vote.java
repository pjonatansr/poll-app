package com.coop.example.poll.model;

public class Vote {
  private long id;
  private boolean value;
  private long memberId;

  public Vote(boolean value, long voterId) {
    this.value = value;
    this.memberId = voterId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isValue() {
    return value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }

  public long getVoterId() {
    return memberId;
  }

  public void setVoterId(long voterId) {
    this.memberId = voterId;
  }

}
