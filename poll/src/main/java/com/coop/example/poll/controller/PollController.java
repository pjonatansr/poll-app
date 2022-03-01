package com.coop.example.poll.controller;

import com.coop.example.poll.model.Poll;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

  @RequestMapping(value = "api/polls/{id}", method = RequestMethod.GET)
  public Poll getPoll(@PathVariable("id") String id) {
    return new Poll("First Poll!");
  }
}
