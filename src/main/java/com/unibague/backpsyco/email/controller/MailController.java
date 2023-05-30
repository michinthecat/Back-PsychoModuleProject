package com.unibague.backpsyco.email.controller;

import com.unibague.backpsyco.email.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class MailController {


    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public void sendHello(){
        mailService.sendHello();
    }

}
