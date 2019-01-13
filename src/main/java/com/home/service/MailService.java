package com.home.service;

import com.home.dto.RawEmailMessageDto;

public interface MailService {
    void sendEmail(RawEmailMessageDto messageDto);
}
