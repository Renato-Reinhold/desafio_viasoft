package com.renato.desafio_viasoft.service;

import com.renato.desafio_viasoft.dto.EmailRequestDTO;
import com.renato.desafio_viasoft.strategy.EmailAdapter;
import com.renato.desafio_viasoft.strategy.EmailAdapterFactory;
import org.springframework.stereotype.Service;


@Service
public class EmailService {


    private final EmailAdapterFactory factory;


    public EmailService(EmailAdapterFactory factory) {
        this.factory = factory;
    }

    public void processEmail(EmailRequestDTO request) {
        EmailAdapter adapter = factory.getAdapter();
        String json = adapter.adapt(request);
        System.out.println(json);
    }

}
