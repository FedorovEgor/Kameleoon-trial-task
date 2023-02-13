package com.back.portal.exception;

public class RegistrationException extends RuntimeException {

    public RegistrationException(String errorMessage) {
        super(errorMessage);
    }

    public RegistrationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
