package com.renato.desafio_viasoft.dto;

import lombok.Data;

@Data
public class EmailAwsDTO {
    private String recipient;
    private String recipientName;
    private String sender;
    private String subject;
    private String content;
    
}
