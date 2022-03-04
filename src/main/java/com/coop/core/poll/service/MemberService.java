package com.coop.core.poll.service;

import com.coop.core.poll.model.Member;
import com.coop.core.poll.repository.IMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService {
  @Autowired
  private IMemberRepository memberRepository;

  public Member getOrSaveMember(Member member) {
    boolean isExistentMember = memberRepository.existsById(member.getId());
    if (!isExistentMember) {
      return memberRepository.save(member);
    }

    return memberRepository.findById(member.getId()).get();
  }
}
