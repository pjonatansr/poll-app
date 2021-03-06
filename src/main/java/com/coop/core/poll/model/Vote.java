package com.coop.core.poll.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.coop.core.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vote extends BaseEntity {
  @Column(name = "fl_value", nullable = false)
  private boolean value;

  @OneToOne()
  private Member member;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "session_id")
  private Session session;

  
  /** 
   * @return Session
   */
  public Session getSession() {
    return this.session;
  }

  
  /** 
   * @param session
   */
  public void setSession(Session session) {
    this.session = session;
  }

  public Vote(boolean value, Member member) {
    this.value = value;
    this.member = member;
  }

  public Vote() {
  }

  
  /** 
   * @return boolean
   */
  public boolean isValue() {
    return value;
  }

  
  /** 
   * @param value
   */
  public void setValue(boolean value) {
    this.value = value;
  }

  
  /** 
   * @return Member
   */
  public Member getMember() {
    return member;
  }

  
  /** 
   * @param member
   */
  public void setMember(Member member) {
    this.member = member;
  }

}
