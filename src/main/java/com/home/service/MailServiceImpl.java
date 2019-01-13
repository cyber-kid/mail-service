package com.home.service;

import com.home.dto.RawEmailMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Value("${app.mail.from}")
    private String from;
    private final JavaMailSender emailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(RawEmailMessageDto messageDto) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(messageDto.getTo());
            messageHelper.setSubject(messageDto.getSubject());
            messageHelper.setText(messageDto.getMessage(), true);
            messageHelper.setFrom(from);
        };
        try {
            emailSender.send(messagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
