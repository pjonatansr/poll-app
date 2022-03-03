package com.coop.core.poll.dto;

import com.coop.core.poll.model.Member;
import com.coop.core.poll.model.Session;

import lombok.Data;

@Data
public class VoteDto {
  private Boolean value;
  private Member member;
  private Session session;

  public Boolean getValue() {
    return this.value;
  }

  public void setValue(Boolean value) {
    this.value = value;
  }

  public Member getMember() {
    return this.member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Session getSession() {
    return this.session;
  }

  public void setSession(Session session) {
    this.session = session;
  }

}
