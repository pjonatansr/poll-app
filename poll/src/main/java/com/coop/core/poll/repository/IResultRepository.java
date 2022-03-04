package com.coop.core.poll.repository;

import com.coop.core.poll.model.Result;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IResultRepository extends CrudRepository<Result, Long> {
  @Query(value = "select id, fl_approved, total_percent_win, vote_count, "
      + "session_id from result where session_id = ?1 limit 1", nativeQuery = true)
  Result getResultBySessionId(Long sessionId);
}
