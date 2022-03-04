package com.coop.core.poll.controller;

import com.coop.core.poll.model.Result;
import com.coop.core.poll.service.IResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sessions/{sessionId}/results")
public class ResultController {

  @Autowired
  private IResultService resultService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Result> getResult(@PathVariable("sessionId") Long sessionId) {
    Result resultInstance = resultService.getBySessionId(sessionId);

    return ResponseEntity.ok(resultInstance);
  }
}
