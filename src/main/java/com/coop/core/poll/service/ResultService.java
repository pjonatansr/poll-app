package com.coop.core.poll.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
  public Result getBySessionId(Long sessionId) throws ValidationException {
    Result result = resultRepository.getResultBySessionId(sessionId);

    if (result == null) {
      Session session = sessionRepository.findById(sessionId).get();
      int pollDuration = session.getPoll().getDurationMinutes();
      LocalDateTime endDate = session.getStartDate().plus(pollDuration + 5, ChronoUnit.MINUTES);

      if (endDate.isBefore(LocalDateTime.now())) {
        calculateResult(session);
        result = resultRepository.getResultBySessionId(sessionId);

        if (result == null) {
          throw new ValidationException("That poll ended with no votes.");
        }
      }
    }

    return result;
  }

}
