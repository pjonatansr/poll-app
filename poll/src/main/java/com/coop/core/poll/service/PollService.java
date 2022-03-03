package com.coop.core.poll.service;

import java.util.Date;
import java.util.List;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.repository.IPollRepository;
import com.coop.core.poll.repository.ISessionRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PollService implements IPollService {

  @Autowired
  private IPollRepository pollRepository;

  @Autowired
  private ISessionRepository sessionRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Value("${poll.default.duration}")
  private Integer defaultDuration;

  @Override
  public Poll save(PollDto poll) {
    if (poll.getDurationMinutes() == null) {
      poll.setDurationMinutes(defaultDuration);
    }

    Poll pollInstance = modelMapper.map(poll, Poll.class);
    pollInstance = pollRepository.save(pollInstance);

    Date startDate = poll.getStartDate();
    
    Session session = new Session(pollInstance, startDate);

    sessionRepository.save(session);

    return pollInstance;
  }

  @Override
  public List<Poll> fetchList() {
    return (List<Poll>) pollRepository.findAll();
  }

}
