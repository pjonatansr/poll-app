package com.coop.core.poll.service;

import java.time.LocalDateTime;

import com.coop.core.common.exception.ValidationException;
import com.coop.core.poll.dto.VoteDto;
import com.coop.core.poll.model.Member;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.repository.IVoteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService implements IVoteService {

  @Autowired
  private IVoteRepository voteRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private IMemberConsumerService memberConsumerService;

  @Autowired
  private IMemberService memberService;

  @Override
  public Vote save(VoteDto voteDto) {
    Session requestedSession = voteDto.getSession();

    if (requestedSession.getId() > 0) {
      LocalDateTime startDate = requestedSession.getStartDate();
      Member member = memberService.getOrSaveMember(voteDto.getMember());
      int duration = requestedSession.getPoll().getDurationMinutes();
      validate(startDate, member, duration);

      Vote voteInstance = modelMapper.map(voteDto, Vote.class);
      return voteRepository.save(voteInstance);
    }

    throw new ValidationException("Session is not valid.");
  }

  private void validate(LocalDateTime startDate, Member member, int duration) {
    LocalDateTime endDate = startDate.plusMinutes(duration);
    boolean isStartDateBeforeNow = startDate.isBefore(LocalDateTime.now());
    boolean isEndDateAfterNow = endDate.isAfter(LocalDateTime.now());
    boolean isMemberAbleToVote = memberConsumerService.isMemberAbleToVote(member.getCpf());

    if (!isStartDateBeforeNow) {
      throw new ValidationException("The poll is not started");
    }

    if (!isEndDateAfterNow) {
      throw new ValidationException("The poll is closed");
    }

    if (!isMemberAbleToVote) {
      throw new ValidationException("You are not able to vote in this poll");
    }
  }
}
