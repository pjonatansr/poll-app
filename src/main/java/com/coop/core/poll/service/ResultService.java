package com.coop.core.poll.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.coop.core.common.exception.NoSuchElementFoundException;
import com.coop.core.common.exception.ValidationException;
import com.coop.core.poll.model.Result;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.repository.IResultRepository;
import com.coop.core.poll.repository.ISessionRepository;
import com.coop.core.poll.repository.IVoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements IResultService {

  @Autowired
  private IResultRepository resultRepository;

  @Autowired
  private IVoteRepository voteRepository;

  @Autowired
  private ISessionRepository sessionRepository;

  @Override
  public void calculateResult(Session session) {
    List<Vote> votes = voteRepository.getRegularVotesBySessionId(session.getId());
    Result result;
    if (!votes.isEmpty()) {

      int numVotes = votes.size();
      int numApprovations = (int) votes
          .stream()
          .filter(Vote::isValue)
          .count();

      boolean isApproved = numApprovations > numVotes / 2;

      float totalPercentWin = (float) ((100f * numApprovations) / numVotes);
      result = new Result(session, isApproved, totalPercentWin, numVotes);
    } else {
      result = new Result(session, false, 0, 0);
    }

    resultRepository.save(result);
  }

  @Override
  public Result getBySessionId(Long sessionId) throws RuntimeException {
    Result result = resultRepository.getResultBySessionId(sessionId);

    if (result == null) {
      Session session = sessionRepository.findById(sessionId).get();

      if (session.getStartDate().isBefore(LocalDateTime.now())) {
        throw new NoSuchElementFoundException("Poll is not started.");
      }

      int pollDuration = session.getPoll().getDurationMinutes();
      LocalDateTime endDate = session.getStartDate().plus(pollDuration, ChronoUnit.MINUTES);
      if (endDate.isAfter(LocalDateTime.now())) {
        throw new NoSuchElementFoundException("Poll is not finished.");
      }

      if (endDate.isBefore(LocalDateTime.now())) {
        calculateResult(session);
        return resultRepository.getResultBySessionId(sessionId);
      }

      if (result == null) {
        throw new ValidationException("That poll has no votes.");
      }
    }

    return result;
  }

}
