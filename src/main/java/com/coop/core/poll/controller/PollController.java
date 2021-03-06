package com.coop.core.poll.controller;

import com.coop.core.common.exception.ValidationException;
import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.service.IPollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/polls")
public class PollController {

  @Autowired
  private IPollService pollService;

  /**
   * Add poll
   * 
   * @param pollDto
   * @return ResponseEntity<Poll>
   * @throws ValidationException
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Poll> save(@RequestBody PollDto pollDto) throws ValidationException {
    Poll pollInstance = pollService.save(pollDto);

    return ResponseEntity.ok(pollInstance);
  }
}
