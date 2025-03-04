package dev.api.application.handlers;

import dev.api.application.config.MessageConfig;
import dev.api.application.exceptions.RestException;
import dev.api.application.inbound.dto.response.ErrorResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RestExceptionHandler implements ExceptionMapper<RestException> {

    @Inject
    private MessageConfig messageConfig;

    @Override
    public Response toResponse(RestException e) {
        var errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());

        return Response.status(e.getStatus()).entity(errorResponse).build();
    }

    private String localMessage(String key) {
        return messageConfig.getMessage(key);
    }
}
