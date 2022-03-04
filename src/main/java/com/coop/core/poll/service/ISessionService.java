package com.coop.core.poll.service;

import com.coop.core.poll.model.Session;

import org.quartz.SchedulerException;

public interface ISessionService {
    public void startSession(Session session) throws SchedulerException;

    public void endSession(long sessionId);
}
