package com.coop.core.poll.dto;

import javax.validation.constraints.NotNull;

import com.coop.core.poll.model.Member;
import com.coop.core.poll.model.Session;

public class VoteDto {
  @NotNull
  private Boolean value;
  @NotNull
  private Member member;
  @NotNull
  private Session session;

  
  /** 
   * @return Boolean
   */
  public Boolean getValue() {
    return this.value;
  }

  
  /** 
   * @param value
   */
  public void setValue(Boolean value) {
    this.value = value;
  }

  
  /** 
   * @return Member
   */
  public Member getMember() {
    return this.member;
  }

  
  /** 
   * @param member
   */
  public void setMember(Member member) {
    this.member = member;
  }

  
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

}
