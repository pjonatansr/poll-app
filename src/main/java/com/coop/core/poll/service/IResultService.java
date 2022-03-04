package com.coop.core.poll.service;

import com.coop.core.poll.model.Result;
import com.coop.core.poll.model.Session;

public interface IResultService {
    public void calculateResult(Session session);

    public Result getBySessionId(Long sessionId);
}
