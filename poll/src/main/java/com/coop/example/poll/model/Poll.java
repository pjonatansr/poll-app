package com.coop.example.poll.model;

import java.util.List;

public class Poll {
  private long id;
  private String description;
  private int durationMinutes;
  private List<Vote> vows;

  public Poll(String description, int durationMinutes) {
    this.description = description;
    this.durationMinutes = durationMinutes;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDurationMinutes() {
    return durationMinutes;
  }

  public void setDurationMinutes(int durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

  public List<Vote> getVows() {
    return vows;
  }

  public void setVows(List<Vote> vows) {
    this.vows = vows;
  }
}
