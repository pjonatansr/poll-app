package com.coop.example.poll.model;

import java.util.List;

public class Poll {

  private long id;
  private String description;
  private List<Vote> vows;

  public Poll(String description) {
    this.description = description;
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

  public List<Vote> getVows() {
    return vows;
  }

  public void setVows(List<Vote> vows) {
    this.vows = vows;
  }
}
