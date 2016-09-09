package com.brainyway.mrs.tpms.reports;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;

public class TPMSJobsScheduler {
	

	public void init() throws SchedulerException, ParseException{
		
		JobDetail dailyDataCheckMailerJob = JobBuilder.newJob(DailyBusDataMailJob.class).withIdentity("DailyBusCheckMailer", "group1").build();
		
		
		CronTriggerImpl dailyDataCheckMailerTrigger = new CronTriggerImpl();
		dailyDataCheckMailerTrigger.setName("DailyBusCheckMailerTrigger");
		dailyDataCheckMailerTrigger.setCronExpression("0/120 * * * * ?");
	 		
			// schedule it
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(dailyDataCheckMailerJob, dailyDataCheckMailerTrigger);
	}
	
}
