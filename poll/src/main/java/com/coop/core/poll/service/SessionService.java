package com.coop.core.poll.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.coop.core.poll.job.SessionJob;
import com.coop.core.poll.model.Session;
import com.coop.core.poll.repository.ISessionRepository;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService implements ISessionService {

  @Autowired
  private ISessionRepository sessionRepository;

  @Autowired
  private IResultService resultService;

  @Override
  public void startSession(Session session) throws SchedulerException {
    SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
    Scheduler scheduler = schedFact.getScheduler();
    scheduler.start();
    scheduler.getContext().put("sessionId", session.getId().longValue());
    scheduler.getContext().put("sessionService", this);

    String groupName = "Group:" + session.getPoll().getId().toString();
    String triggerName = "Trigger:" + session.getId().toString();
    String jobName = "Job:" + session.getId().toString();

    JobDetail job = JobBuilder.newJob(SessionJob.class)
        .withIdentity(jobName, groupName)
        .build();

    int duration = session.getPoll().getDurationMinutes();
    LocalDateTime localStartDate = session.getStartDate();
    LocalDateTime finalDateTime = localStartDate.plus(Duration.of(duration, ChronoUnit.MINUTES));
    ZoneOffset serverOffset = OffsetDateTime.now().getOffset();
    Date finalDate = Date.from(finalDateTime
        .toInstant(serverOffset));

    Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity(triggerName, groupName)
        .startAt(finalDate)
        // .startNow()
        .withSchedule(SimpleScheduleBuilder
            .simpleSchedule())
        .build();

    scheduler.scheduleJob(job, trigger);

  }

  @Override
  public void endSession(long sessionId) {
    Session session = sessionRepository.findById(sessionId).get();
    resultService.calculateResult(session);
  }
}
