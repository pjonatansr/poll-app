package com.coop.core.poll.job;

import java.io.Serializable;

import com.coop.core.poll.service.ISessionService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SessionJob extends QuartzJobBean implements Serializable {

  
  /** 
   * @param context
   * @throws JobExecutionException
   */
  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    try {
      SchedulerContext schedulerContext = context.getScheduler().getContext();
      long sessionId = (long) schedulerContext.get("sessionId");
      ISessionService sessionService = (ISessionService) schedulerContext.get("sessionService");

      sessionService.endSession(sessionId);
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }

}