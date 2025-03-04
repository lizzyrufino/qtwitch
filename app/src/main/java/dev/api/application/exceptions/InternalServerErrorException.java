package dev.api.application.exceptions;

import jakarta.ws.rs.core.Response;

public class InternalServerErrorException extends RestException {

    public InternalServerErrorException(String message) {
        super(Response.Status.INTERNAL_SERVER_ERROR, message);
    }
}
