package com.unibague.backpsyco.email.controller;

import com.unibague.backpsyco.email.model.EmailRequest;
import com.unibague.backpsyco.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class MailController {


    @Autowired
    private MailService mailService;


    @GetMapping("/send")
    public void sendHello(){
        mailService.sendHello();
    }

    @PostMapping("/sendPreConfirmation")
    public String sendHtmlEmail(@RequestBody EmailRequest emailRequest) {

        Long appointmentId = emailRequest.getAppointmentId();
        String name = emailRequest.getName();
        String domain = emailRequest.getEmail();
        String confirmationLink = emailRequest.getConfirmationLink();

        mailService.sendHtml(name, domain, confirmationLink);

        return "Html email sent successfully";
    }

    @PostMapping("/sendConfirmation")
    public String sendConfirmationEmail(@RequestBody EmailRequest emailRequest) {
        String email = emailRequest.getEmail();

        mailService.sendConfirmationEmail(email);

        return "Confirmation email sent successfully";
    }





}
