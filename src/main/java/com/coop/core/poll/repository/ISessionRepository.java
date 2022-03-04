package com.coop.core.poll.repository;

import com.coop.core.poll.model.Session;

import org.springframework.data.repository.CrudRepository;

public interface ISessionRepository extends CrudRepository<Session, Long> {
}
