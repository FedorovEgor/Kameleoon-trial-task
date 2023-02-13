package com.back.portal.exception;

public class SelfVoteException extends RuntimeException {

    public SelfVoteException(String message) {
        super(message);
    }

    public SelfVoteException(String message, Throwable err) {
        super(message, err);
    }
}
