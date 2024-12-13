package com.dnzocoud.mantix_api.domain.exceptions;

import java.security.InvalidParameterException;

public class InvalidRequestException extends InvalidParameterException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
