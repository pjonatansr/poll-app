package com.coop.example.poll.controller;

import com.coop.example.poll.model.Poll;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/polls")
public class PollController {

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Poll getPoll(@PathVariable("id") String id) {
    // TO-DO: get persited poll
    return new Poll("First Poll!");
  }

  @RequestMapping(method = RequestMethod.POST)
  public Poll createPoll(Poll pollInstance) {
    // TO-DO: persist poll
    return pollInstance;
  }
}
