package com.coop.core.poll.controller;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.service.IPollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/polls")
public class PollController {

  @Autowired
  private IPollService pollService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Poll getPoll(@PathVariable("id") Long id) {
    // TO-DO: get persited poll
    Poll pollInstance = new Poll("Poll " + id);
    pollInstance.setId(id);

    return pollInstance;
  }

  @RequestMapping(method = RequestMethod.POST)
  public Poll save(@RequestBody PollDto pollInput) {
    Poll pollInstance = pollService.savePoll(pollInput);

    return pollInstance;
  }
}
