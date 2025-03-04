package dev.api.application.handlers;

import dev.api.application.inbound.dto.response.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        var errorResponse = new ErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, e.getMessage());

        return Response.status(errorResponse.statusCode()).entity(errorResponse).build();
    }
}
