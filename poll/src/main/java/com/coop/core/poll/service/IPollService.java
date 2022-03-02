package com.coop.core.poll.service;

import java.util.List;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;

public interface IPollService {
  // save operation
  Poll savePoll(PollDto pollInput);

  // read operation
  List<Poll> fetchPollList();

  // update operation
  Poll updatePoll(PollDto poll);

  // delete operation
  void deletePollById(Long pollId);
}
