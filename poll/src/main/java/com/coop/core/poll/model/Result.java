package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.coop.core.common.model.BaseEntity;

@Entity
public class Result extends BaseEntity {
  @OneToOne()
  private Session session;

  @Column(name = "fl_approved", nullable = false)
  private boolean approved;

  @Column(name = "total_percent_win")
  private float totalPercentWin;

  @Column(name = "vote_count")
  private int voteCount;

  public Result(Session session, boolean approved, float totalPercentWin, int voteCount) {
    this.session = session;
    this.approved = approved;
    this.totalPercentWin = totalPercentWin;
    this.voteCount = voteCount;
  }

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public boolean isApproved() {
    return this.approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public float getTotalPercentWin() {
    return this.totalPercentWin;
  }

  public void setTotalPercentWin(float totalPercentWin) {
    this.totalPercentWin = totalPercentWin;
  }

  public int getVoteCount() {
    return this.voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

}
