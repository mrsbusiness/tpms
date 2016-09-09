package com.brainyway.mrs.tpms.reports;



import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.brainyway.mrs.tpms.tripdata.TripDataService;

public class DailyBusDataMailJob implements Job{

	@Resource
	private TripDataService tripDataService;
	
	@Resource
	private TPMSMailer tpmsMailer;

	//private ApplicationContext appContext;
	
	private static final Logger logger = LoggerFactory.getLogger(DailyBusDataMailJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	/*	tripDataService = appContext.getBean(TripDataService.class);
		tpmsMailer = appContext.getBean(TPMSMailer.class);
		*/
		//TODO read the day difference from properties file and
		int tripssize = tripDataService.getTodaysTripsCount(new Date());
		
		if(tripssize<10){
			
			int remainingTripsToEnterIn = 10-tripssize;
			
			//TODO This mesaage should come from properties files
			String message = "There are 10 records expected in the database system but there are only " + tripssize +". Please enter remaining " + remainingTripsToEnterIn +" trips data ASAP";
			try {
				
				tpmsMailer.sendDailyDataCheckEmail(message);
				
			} catch (AddressException e) {
				
				logger.error("Error occured while sending the Daily Data check email",e);
				
			} catch (MessagingException e) {
				
				logger.error("Error occured while sending the Daily Data check email",e);
				
			}
			
		}

	}

}
