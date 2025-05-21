package com.renato.desafio_viasoft.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailAwsDTO{

    @NotBlank
    @Email
    @Size(max = 45)
    private String recipient;

    @NotBlank
    @Size(max = 60)
    private String recipientName;

    @NotBlank
    @Email
    @Size(max = 45)
    private String sender;

    @NotBlank
    @Size(max = 120)
    private String subject;

    @NotBlank
    @Size(max = 256)
    private String content;
}
