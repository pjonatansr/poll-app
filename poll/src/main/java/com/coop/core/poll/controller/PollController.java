package com.coop.core.poll.controller;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.service.IPollService;

import org.quartz.SchedulerException;
import org.quartz.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/polls")
public class PollController {

  @Autowired
  private IPollService pollService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Poll> save(@RequestBody PollDto pollInput) throws ValidationException, SchedulerException {
    Poll pollInstance = pollService.save(pollInput);

    return ResponseEntity.ok(pollInstance);
  }
}
