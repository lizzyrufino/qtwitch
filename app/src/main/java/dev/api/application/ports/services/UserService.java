package dev.api.application.ports.services;

import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.common.extensions.Loggable;

public interface UserService extends Loggable {

    void create(CreateUserRequest request);
}
