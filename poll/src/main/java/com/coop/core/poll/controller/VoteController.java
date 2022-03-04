package com.coop.core.poll.controller;

import com.coop.core.poll.dto.VoteDto;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.service.IVoteService;

import org.quartz.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Vote> save(@RequestBody VoteDto voteDto, @PathVariable("sessionId") Session session)
      throws ValidationException {
    voteDto.setSession(session);

    Vote voteInstance = voteService.save(voteDto);

    return ResponseEntity.ok(voteInstance);
  }
}
