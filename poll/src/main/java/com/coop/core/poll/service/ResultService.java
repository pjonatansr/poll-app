package com.coop.core.poll.service;

import java.util.List;

import com.coop.core.poll.model.Result;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.repository.IResultRepository;
import com.coop.core.poll.repository.IVoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements IResultService {

  @Autowired
  private IResultRepository resultRepository;

  @Autowired
  private IVoteRepository voteRepository;

  @Override
  public void calculateResult(Session session) {
    List<Vote> votes = voteRepository.getRegularVotesBySessionId(session.getId());

    if (votes.isEmpty()) {
      System.out.println("No Votes");
    }

    int numVotes = votes.size();
    int numApprovations = (int) votes
        .stream()
        .filter(Vote::isValue)
        .count();

    boolean isApproved = numApprovations > numVotes / 2;

    float totalPercentWin = (float) ((100f * numApprovations) / numVotes);
    Result result = new Result(session, isApproved, totalPercentWin, numVotes);

    resultRepository.save(result);

  }
}
