package com.coop.acl.member.service;

import com.coop.acl.member.dto.MemberDto;
import com.coop.core.poll.service.IMemberConsumerService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberConsumerService implements IMemberConsumerService {

  @Value("${member.service.default.url}")
  private String defaultUrl;

  @Value("${member.default.authorized.status}")
  private String authorizedStatus;

  
  /** 
   * @param cpf
   * @return boolean
   */
  @Override
  public boolean isMemberAbleToVote(String cpf) {
    RestTemplate restTemplate = new RestTemplate();
    MemberDto memberDto = restTemplate.getForObject(defaultUrl + cpf, MemberDto.class);
    boolean isAuthorized = memberDto.getStatus().equals(authorizedStatus);

    return isAuthorized;
  }
}
