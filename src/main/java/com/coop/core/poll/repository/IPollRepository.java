package com.coop.core.poll.repository;

import com.coop.core.poll.model.Poll;

import org.springframework.data.repository.CrudRepository;

public interface IPollRepository extends CrudRepository<Poll, Long> {
}
