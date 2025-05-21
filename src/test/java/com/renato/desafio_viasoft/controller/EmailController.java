package com.renato.desafio_viasoft.controller;

import com.renato.desafio_viasoft.dto.EmailRequestDTO;
import com.renato.desafio_viasoft.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmailController.class)
class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testEnviarEmailReturns204() throws Exception {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setEmailDestinatario("dest@example.com");
        dto.setNomeDestinatario("Destinatário");
        dto.setEmailRemetente("remetente@example.com");
        dto.setAssunto("Assunto");
        dto.setConteudo("Corpo do email");

        mockMvc.perform(post("/emails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isNoContent());
    }
}
