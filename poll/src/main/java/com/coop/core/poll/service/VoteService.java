package com.coop.core.poll.service;

import java.time.LocalDateTime;
import java.util.List;

import com.coop.core.common.exception.ValidationException;
import com.coop.core.poll.dto.VoteDto;
import com.coop.core.poll.model.Member;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.model.Vote;
import com.coop.core.poll.repository.IMemberRepository;
import com.coop.core.poll.repository.ISessionRepository;
import com.coop.core.poll.repository.IVoteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

  @Autowired
  private IVoteRepository voteRepository;

  @Autowired
  private IMemberRepository memberRepository;

  @Autowired
  private ISessionRepository sessionRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public Vote save(VoteDto voteDto) {
    Member member = voteDto.getMember();
    boolean isExistentMember = memberRepository.existsById(member.getId());
    if (!isExistentMember) {
      memberRepository.save(member);
    }

    Session requestedSession = voteDto.getSession();
    if (requestedSession.getId() > 0) {
      LocalDateTime startDate = requestedSession.getStartDate();

      if (startDate.isAfter(LocalDateTime.now())) {
        Vote voteInstance = modelMapper.map(voteDto, Vote.class);

        return voteRepository.save(voteInstance);
      }

      throw new ValidationException("Oops, the poll is already closed.");
    }

    throw new ValidationException("Session is not valid.");
  }

  @Override
  public List<Vote> fetchList() {
    return (List<Vote>) voteRepository.findAll();
  }
}
