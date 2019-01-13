package com.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RawEmailMessageDto {
    private String to;
    private String subject;
    private String message;
}
