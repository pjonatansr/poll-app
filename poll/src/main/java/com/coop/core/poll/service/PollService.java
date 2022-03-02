package com.coop.core.poll.service;

import java.util.List;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.repository.IPollRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PollService implements IPollService {

  @Autowired
  private IPollRepository pollRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Value("${poll.default.duration}")
  private Integer defaultDuration;

  @Override
  public Poll savePoll(PollDto poll) {
    if (poll.getDurationMinutes() == null) {
      poll.setDurationMinutes(defaultDuration);
    }

    Poll pollInstance = modelMapper.map(poll, Poll.class);

    return pollRepository.save(pollInstance);
  }

  @Override
  public List<Poll> fetchPollList() {
    return (List<Poll>) pollRepository.findAll();
  }

  @Override
  public Poll updatePoll(PollDto poll) {
    // TO-DO: update poll
    return null;
  }

  @Override
  public void deletePollById(Long PollId) {

    pollRepository.deleteById(PollId);
  }
}
