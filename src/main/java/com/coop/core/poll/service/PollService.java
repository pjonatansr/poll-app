package com.coop.core.poll.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.coop.core.common.exception.ValidationException;
import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.repository.IPollRepository;

import org.modelmapper.ModelMapper;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PollService implements IPollService {

  Logger logger = LoggerFactory.getLogger(PollService.class);

  @Autowired
  private IPollRepository pollRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private SessionService sessionService;

  @Value("${poll.default.duration}")
  private Integer defaultDuration;

  @Override
  public Poll save(PollDto poll) throws ValidationException {
    if (poll.getDurationMinutes() <= 0 || poll.getDurationMinutes() == null) {
      poll.setDurationMinutes(defaultDuration);
    }

    if (poll.getStartDate().isBefore(LocalDateTime.now())) {
      throw new ValidationException("Poll start date can't be before now.");
    }

    Poll pollInstance = modelMapper.map(poll, Poll.class);

    Session session = new Session(pollInstance, poll.getStartDate());

    List<Session> sessions = pollInstance.getSessions();
    if (sessions == null) {
      sessions = new ArrayList<Session>();
    }
    sessions.add(session);
    pollInstance.setSessions(sessions);

    pollInstance = pollRepository.save(pollInstance);

    try {
      sessionService.startSession(session);
    } catch (SchedulerException e) {
      logger.error("An error occurred while trying to start session.", e);
      e.printStackTrace();
    }

    return pollInstance;
  }

}
