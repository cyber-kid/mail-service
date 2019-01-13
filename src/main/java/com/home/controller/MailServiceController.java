package com.home.controller;

import com.home.dto.EmailMessageDto;
import com.home.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailServiceController {
    private MailService mailService;

    @Autowired
    public MailServiceController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/handleMessage")
    public void handleMessage(@RequestBody EmailMessageDto dto) {
        mailService.sendEmail(dto.getData());
    }
}
