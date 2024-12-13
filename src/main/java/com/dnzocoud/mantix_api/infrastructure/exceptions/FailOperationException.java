package com.dnzocoud.mantix_api.infrastructure.exceptions;

public class FailOperationException extends RuntimeException {
    public FailOperationException() {
        super("Credenciales inválidas");
    }

    public FailOperationException(String message) {
        super(message);
    }
}
