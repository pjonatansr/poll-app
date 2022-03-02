package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.coop.core.common.model.BaseEntity;

@Entity
public class PollResult extends BaseEntity {
  @OneToOne
  private PollSession pollSession;

  @Column(name = "fl_approved", nullable = false)
  private boolean approved;

  @Column(name = "total_percent_win")
  private int totalPercentWin;

  public PollSession getPollSession() {
    return pollSession;
  }

  public void setPollSessionId(PollSession pollSession) {
    this.pollSession = pollSession;
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
