package com.renato.desafio_viasoft.service;

import com.renato.desafio_viasoft.dto.*;
import com.renato.desafio_viasoft.strategy.EmailAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

public class OciEmailAdapter implements EmailAdapter {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Validator validator;

    public OciEmailAdapter(Validator validator) {
        this.validator = validator;
    }

    @Override
    public String adapt(EmailRequestDTO request) {
        EmailOciDTO dto = new EmailOciDTO();
        dto.setRecipientEmail(request.getEmailDestinatario());
        dto.setRecipientName(request.getNomeDestinatario());
        dto.setSenderEmail(request.getEmailRemetente());
        dto.setSubject(request.getAssunto());
        dto.setBody(request.getConteudo());

        this.validar(dto);
        try {
            return mapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar para OCI", e);
        }
    }

    private void validar(Object obj) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Object> violation : violations) {
                sb.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("; ");
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
        }
    }

}
