package dev.api.application.exceptions;

import jakarta.ws.rs.core.Response.Status;

public abstract class RestException extends RuntimeException {

    protected Status statusCode;

    public RestException(Status statusCode) {
        super(statusCode.getReasonPhrase());
        this.statusCode = statusCode;
    }

    public RestException(Status statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public Status getStatus() {
        return this.statusCode;
    }
}
