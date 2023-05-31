package com.unibague.backpsyco.email.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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


    public void sendEmail(String to, String subject, String body) {
        Destination destination = new Destination().withToAddresses(to);

        Message message = new Message()
                .withSubject(new Content(subject))
                .withBody(new Body(new Content(body)));

        SendEmailRequest request = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(request);
    }

    public void sendHtml(String name , String email, String confirmationLink){
        Destination destination = new Destination().withToAddresses(email);

        Context context = new Context();
        context.setVariable("name", name );
        context.setVariable("domain", "UNIBAGUE");
        context.setVariable("confirmationLink", confirmationLink);

        String htmlBody = this.templateEngine.process("Pre-Confirmation", context);

        Message message = new Message()
                .withSubject(new Content("Confirmación de la reserva - Unidad Psicologica"))

                .withBody(new Body().withHtml(new Content(htmlBody)));
        System.out.println(htmlBody);

        SendEmailRequest request = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(request);
    }

}
