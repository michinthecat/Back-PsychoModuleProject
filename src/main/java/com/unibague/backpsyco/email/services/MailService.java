package com.unibague.backpsyco.email.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class MailService {

    private final static String MY_EMAIL = "jhon.bravo@ias.com.co";

    @Autowired
    private AmazonSimpleEmailService client;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendHello(){
        Destination destination = new Destination().withToAddresses(MY_EMAIL);

        Message message = new Message()
                .withSubject(new Content("Hello from AWS SES"))
                .withBody(new Body(new Content("This is a test email sent from AWS SES")));

        SendEmailRequest request = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(request);
    }




}
