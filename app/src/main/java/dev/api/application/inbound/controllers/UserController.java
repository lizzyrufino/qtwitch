package dev.api.application.inbound.controllers;


import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.application.inbound.swagger.UserSwagger;
import dev.api.domain.ports.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class UserController implements UserSwagger {

    @Inject
    UserService userService;

    @Override
    public Response createUser(CreateUserRequest body) {
        var response = userService.create(body);

        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @Override
    public Response listUser() {
        var response = userService.list();
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
