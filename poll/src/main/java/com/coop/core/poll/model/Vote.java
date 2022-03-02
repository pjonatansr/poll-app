package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.coop.core.common.model.BaseEntity;

@Entity
public class Vote extends BaseEntity {
  @Column(name = "fl_value", nullable = false)
  private boolean value;

  @OneToOne()
  private Member member;

  public Vote(boolean value, Member member) {
    this.value = value;
    this.member = member;
  }

  public boolean isValue() {
    return value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

}
