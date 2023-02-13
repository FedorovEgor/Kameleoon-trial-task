package com.back.portal.exception;

public class VoteNotFoundException extends RuntimeException {
    public VoteNotFoundException(String message) {
        super(message);
    }

    public VoteNotFoundException(String message, Throwable err) {
        super(message, err);
    }
}
