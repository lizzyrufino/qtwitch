package dev.api.application.inbound.controllers;


import dev.api.application.inbound.dto.request.CreateContentCreatorRequest;
import dev.api.application.inbound.swagger.ContentCreatorSwagger;
import dev.api.domain.ports.services.ContentCreatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

public class ContentCreatorController implements ContentCreatorSwagger {
    @Inject
    ContentCreatorService contentCreatorService;

    @Override
    public Response createContentCreator(UUID userId, CreateContentCreatorRequest request) {
        var response = contentCreatorService.create(request, userId);

        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
