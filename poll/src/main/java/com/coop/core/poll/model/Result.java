package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.coop.core.common.model.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Result extends BaseEntity {
  @OneToOne
  private Session pollSession;

  @Column(name = "fl_approved", nullable = false)
  private boolean approved;

  @Column(name = "total_percent_win")
  private int totalPercentWin;

  public Session getPollSession() {
    return pollSession;
  }

  public void setPollSessionId(Session pollSession) {
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
