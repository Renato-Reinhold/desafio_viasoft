package com.renato.desafio_viasoft.controller;

import com.renato.desafio_viasoft.dto.EmailRequestDTO;
import com.renato.desafio_viasoft.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody @Valid EmailRequestDTO request) {
        service.processEmail(request);
        return ResponseEntity.noContent().build();
    }
}
