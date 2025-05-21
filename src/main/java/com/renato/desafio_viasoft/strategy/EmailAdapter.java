package com.renato.desafio_viasoft.strategy;

import com.renato.desafio_viasoft.dto.EmailRequestDTO;

public interface EmailAdapter {
    String adapt(EmailRequestDTO request);
}
