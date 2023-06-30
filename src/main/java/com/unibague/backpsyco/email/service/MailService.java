package com.unibague.backpsyco.email.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.unibague.backpsyco.email.model.EmailAppointment;
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


    public void emailChangeAppointment(EmailAppointment emailAppointment){

        Context context = new Context();
        context.setVariable("name", emailAppointment.getName());
        context.setVariable("appointmentId", emailAppointment.getAppointmentId());
        context.setVariable("date", emailAppointment.getDate());
        context.setVariable("time", emailAppointment.getTime());
        context.setVariable("psychologist", emailAppointment.getPsychologist());

        Destination destination = new Destination().withToAddresses(emailAppointment.getEmail());

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

    public void emailCancelationAppointment(EmailAppointment emailCancelationAppointment){

        Context context = new Context();
        context.setVariable("name", emailCancelationAppointment.getName());
        context.setVariable("appointmentId", emailCancelationAppointment.getAppointmentId());
        context.setVariable("date", emailCancelationAppointment.getDate());
        context.setVariable("time", emailCancelationAppointment.getTime());
        context.setVariable("psychologist", emailCancelationAppointment.getPsychologist());

        Destination destination = new Destination().withToAddresses(emailCancelationAppointment.getEmail());

        String htmlBody = this.templateEnginePre.process("CancelAppointment", context);

        Message message = new Message()
                .withSubject(new Content("IMPORTANTE! Cita Cancelada en la Unidad Psicologica"))
                .withBody(new Body().withHtml(new Content(htmlBody)));

        SendEmailRequest request = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(request);
    }


}
