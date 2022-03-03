package com.coop.core.poll.controller;

import com.coop.core.poll.dto.VoteDto;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.service.IVoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sessions/{sessionId}/votes")
public class VoteController {

  @Autowired
  private IVoteService voteService;

  @RequestMapping(method = RequestMethod.POST)
  public Vote save(@RequestBody VoteDto voteDto, @PathVariable("sessionId") Session session) {
    voteDto.setSession(session);

    Vote voteInstance = voteService.save(voteDto);

    return voteInstance;
  }
}
