package com.brainyway.mrs.tpms.reports;

import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class TPMSMailer {

	private Properties props = new Properties();

	//TODO these need to fetch from properties file
	final String username = "forhirebusesproject@gmail.com";
	final String password = "mars24/7";
	
	@PostConstruct
	public void init(){	
 
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
	}
	
	public boolean sendDailyDataCheckEmail(String message) throws AddressException, MessagingException{
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		
		MimeMessage mailMessage = new MimeMessage(session);
		mailMessage.setFrom(new InternetAddress("forhirebusesproject@gmail.com"));
		mailMessage.setRecipients(RecipientType.TO, InternetAddress.parse("alladivasu@gmail.com"));
		 DateTime currentDate = DateTime.now();
		mailMessage.setSubject("Daily Data Entry Check  " +currentDate.getDayOfMonth()+"-"+currentDate.getDayOfMonth()+"-"+currentDate.getYear());
		mailMessage.setText(message);
		Transport.send(mailMessage);
		
		return true;
	}
}
