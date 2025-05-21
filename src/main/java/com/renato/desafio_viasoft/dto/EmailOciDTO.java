package com.renato.desafio_viasoft.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailOciDTO extends EmailRequestDTO{

    @NotBlank
    @Email
    @Size(max = 40)
    private String recipientEmail;

    @NotBlank
    @Size(max = 50)
    private String recipientName;

    @NotBlank
    @Email
    @Size(max = 40)
    private String senderEmail;

    @NotBlank
    @Size(max = 100)
    private String subject;

    @NotBlank
    @Size(max = 250)
    private String body;
}
