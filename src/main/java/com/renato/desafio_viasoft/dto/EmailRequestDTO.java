package com.renato.desafio_viasoft.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailRequestDTO {
    @NotBlank @Email
    private String emailDestinatario;

    @NotBlank @Size(max = 60)
    private String nomeDestinatario;

    @NotBlank @Email
    private String emailRemetente;

    @NotBlank @Size(max = 120)
    private String assunto;

    @NotBlank @Size(max = 256)
    private String conteudo;

}
