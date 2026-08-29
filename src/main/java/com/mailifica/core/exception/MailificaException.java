package com.mailifica.core.exception;

public class MailificaException extends RuntimeException {
    private int statusCode;

    public MailificaException(String message) {
        super(message);
    }

    public MailificaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailificaException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
