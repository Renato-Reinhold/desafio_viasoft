package com.renato.desafio_viasoft.strategy;

import com.renato.desafio_viasoft.service.AwsEmailAdapter;
import com.renato.desafio_viasoft.service.OciEmailAdapter;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Component
public class EmailAdapterFactory {

    private final Validator validator;
    @Value("${mail.integracao}")
    private String integracao;

    public EmailAdapterFactory(Validator validator) {
        this.validator = validator;
    }

    public EmailAdapter getAdapter() {
        if ("AWS".equals(integracao)) {
            return new AwsEmailAdapter(validator);
        }else if ("OCI".equals(integracao)) {
            return new OciEmailAdapter(validator);
        }
        throw new IllegalArgumentException("Integração desconhecida" + integracao);
    }


}
