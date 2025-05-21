package com.renato.desafio_viasoft.exception;

public class EmailProcessingException extends RuntimeException {
    public EmailProcessingException(String message) {
        super(message);
    }
}
