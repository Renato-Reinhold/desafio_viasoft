package com.renato.desafio_viasoft.service;

import com.renato.desafio_viasoft.dto.EmailRequestDTO;
import com.renato.desafio_viasoft.strategy.EmailAdapter;
import com.renato.desafio_viasoft.strategy.EmailAdapterFactory;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmailServiceTest {

    @Test
    void testProcessEmailPrintsJson() {
        // Arrange
        EmailAdapterFactory factory = Mockito.mock(EmailAdapterFactory.class);
        EmailAdapter adapter = Mockito.mock(EmailAdapter.class);
        Validator validator = Mockito.mock(Validator.class);
        EmailRequestDTO request = new EmailRequestDTO();

        request.setEmailDestinatario("dest@example.com");
        request.setNomeDestinatario("Destinatário");
        request.setEmailRemetente("remetente@example.com");
        request.setAssunto("Assunto");
        request.setConteudo("Corpo do email");

        Mockito.when(factory.getAdapter()).thenReturn(adapter);
        Mockito.when(adapter.adapt(request)).thenReturn("{\"fake\": \"json\"}");

        EmailService service = new EmailService(factory);

        service.processEmail(request);

        Mockito.verify(adapter).adapt(request);
    }
}
