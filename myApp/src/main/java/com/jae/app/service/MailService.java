package com.jae.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jae.app.domain.NotificationEmail;
import com.jae.app.exception.SpringTaskappException;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
class MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(NotificationEmail notificationEmail) {
		
		  MimeMessagePreparator messagePreparator = mimeMessage -> { MimeMessageHelper
		  messageHelper = new MimeMessageHelper(mimeMessage);
		  messageHelper.setFrom("91jaeminjo@email.com");
		  messageHelper.setTo(notificationEmail.getRecipient());
		  messageHelper.setSubject(notificationEmail.getSubject());
		  messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
		  };
		 
		
        try {
            mailSender.send(messagePreparator);
            //log.info("Activation email sent!!");
        } catch (MailException e) {
            throw new SpringTaskappException("Exception occurred when sending mail to " + notificationEmail.getRecipient());
        }
    }
    
    @Autowired
    public MailService(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
    	this.mailSender = mailSender;
    	this.mailContentBuilder = mailContentBuilder; 
    	
    }

}