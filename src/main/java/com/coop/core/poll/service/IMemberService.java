package com.coop.core.poll.service;

import com.coop.core.poll.model.Member;

public interface IMemberService {
  public Member getOrSaveMember(Member member);
}
