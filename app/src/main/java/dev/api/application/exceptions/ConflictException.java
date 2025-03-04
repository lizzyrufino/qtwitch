package dev.api.application.exceptions;

import jakarta.ws.rs.core.Response;

public class ConflictException extends RestException {

    public ConflictException(String message) {
        super(Response.Status.CONFLICT, message);
    }
}
