package dev.api.application.inbound.controllers;


import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.application.inbound.swagger.UserSwagger;
import dev.api.application.ports.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class UserController implements UserSwagger {

    @Inject
    UserService userService;

    @Override
    public Response createUser(CreateUserRequest body) {
        userService.create(body);

        return Response.status(Response.Status.CREATED).entity("User created!").build();
    }
}
