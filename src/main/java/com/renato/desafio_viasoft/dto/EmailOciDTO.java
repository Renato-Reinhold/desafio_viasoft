package com.renato.desafio_viasoft.dto;

import lombok.Data;

@Data
public class EmailOciDTO {
    private String recipientEmail;
    private String recipientName;
    private String senderEmail;
    private String subject;
    private String body;

}
