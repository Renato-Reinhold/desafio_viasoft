package com.renato.desafio_viasoft.dto;

import lombok.Data;

@Data
public class EmailRequestDTO {
    private String emailDestinatario;
    private String nomeDestinatario;
    private String emailRemetente;
    private String assunto;
    private String conteudo;
}
