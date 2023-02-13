package com.back.portal.exception;

public class VoteLimitException extends RuntimeException {
    public VoteLimitException(String message) {
        super(message);
    }

    public VoteLimitException(String message, Throwable err) {
        super(message, err);
    }
}
