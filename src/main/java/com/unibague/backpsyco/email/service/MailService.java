package com.unibague.backpsyco.email.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.unibague.backpsyco.email.model.EmailChangeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService {

    @Value("${aws.emailSender}")
    private String MY_EMAIL;

    @Autowired
    private AmazonSimpleEmailService client;

    @Autowired
    private TemplateEngine templateEnginePre;


    public void emailChangeAppointment(EmailChangeAppointment emailChangeAppointment){

        Context context = new Context();
        context.setVariable("name", emailChangeAppointment.getName());
        context.setVariable("appointmentId", emailChangeAppointment.getAppointmentId());
        context.setVariable("date", emailChangeAppointment.getDate());
        context.setVariable("time", emailChangeAppointment.getTime());
        context.setVariable("psychologist", emailChangeAppointment.getPsychologist());

        Destination destination = new Destination().withToAddresses(emailChangeAppointment.getEmail());

        String htmlBody = this.templateEnginePre.process("ChangeAppointment", context);

        Message message = new Message()
                .withSubject(new Content("IMPORTANTE! Cita Reprogramada en la Unidad Psicologica"))
                .withBody(new Body().withHtml(new Content(htmlBody)));

        SendEmailRequest request = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(request);
    }

}
