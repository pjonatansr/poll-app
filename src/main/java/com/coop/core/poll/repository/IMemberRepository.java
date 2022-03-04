package com.coop.core.poll.repository;

import com.coop.core.poll.model.Member;

import org.springframework.data.repository.CrudRepository;

public interface IMemberRepository extends CrudRepository<Member, Long> {
}
