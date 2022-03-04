package com.coop.core.poll.service;

import com.coop.core.common.service.IBaseService;
import com.coop.core.poll.dto.VoteDto;
import com.coop.core.poll.model.Vote;

public interface IVoteService
    extends IBaseService<Vote, VoteDto> {
}
