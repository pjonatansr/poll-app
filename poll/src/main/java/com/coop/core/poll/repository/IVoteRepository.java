package com.coop.core.poll.repository;

import com.coop.core.poll.model.Vote;

import org.springframework.data.repository.CrudRepository;

public interface IVoteRepository extends CrudRepository<Vote, Long> {
}
