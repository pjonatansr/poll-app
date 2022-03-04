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
