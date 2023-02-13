package com.back.portal.exception;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(String message) {
        super(message);
    }

    public QuoteNotFoundException(String message, Throwable err) {
        super(message, err);
    }
}
