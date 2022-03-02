package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PollResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  private PollSession pollSession;

  @Column(name = "fl_approved")
  private boolean approved;

  @Column(name = "total_percent_win")
  private int totalPercentWin;

  public int getId() {
    return this.id;
  }

  public PollSession getPollSession() {
    return pollSession;
  }

  public void setPollSessionId(PollSession pollSession) {
    this.pollSession = pollSession;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isApproved() {
    return this.approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public int getTotalPercentWin() {
    return this.totalPercentWin;
  }

  public void setTotalPercentWin(int totalPercentWin) {
    this.totalPercentWin = totalPercentWin;
  }

}
