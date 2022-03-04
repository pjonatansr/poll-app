package com.coop.core.poll.repository;

import com.coop.core.poll.model.Result;

import org.springframework.data.repository.CrudRepository;

public interface IResultRepository extends CrudRepository<Result, Long> {
}
