package com.coop.example.poll.model;

public class Vote {
  private long id;

  public Vote(boolean value, long voterId) {
    this.value = value;
    this.voterId = voterId;
  }

  private boolean value;
  private long voterId;

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
    return voterId;
  }

  public void setVoterId(long voterId) {
    this.voterId = voterId;
  }

}
