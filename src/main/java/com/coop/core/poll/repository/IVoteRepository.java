package com.coop.core.poll.repository;

import java.util.List;

import com.coop.core.poll.model.Vote;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IVoteRepository extends CrudRepository<Vote, Long> {

  @Query(value = "select v.id, v.fl_value, v.member_id, v.session_id "
      + "from vote v where v.session_id=?1 and v.id=(select v2.id from vote v2 "
      + "where v2.member_id = v.member_id and v2.session_id = v.session_id order "
      + "by id desc limit 1)", nativeQuery = true)
  List<Vote> getRegularVotesBySessionId(Long sessionId);
}
