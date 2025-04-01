package dev.api.domain.ports.services;

import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.application.inbound.dto.response.UserResponse;
import dev.api.common.extensions.Loggable;

import java.util.List;

public interface UserService extends Loggable {

    UserResponse create(CreateUserRequest request);
    List<UserResponse> list();
}
