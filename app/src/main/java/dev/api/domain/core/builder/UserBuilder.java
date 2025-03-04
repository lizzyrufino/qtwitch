package dev.api.domain.core.builder;

import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.domain.entities.User;
import dev.api.domain.enums.RoleType;

public class UserBuilder {

    public static User requestToDomain(CreateUserRequest request, String saltKey, String cryptPassword) {
        var roleType = RoleType.valueOf(request.role());
        return User.create(request.name(), request.email(), request.nickname(), cryptPassword, saltKey, roleType);
    }
}
