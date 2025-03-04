package dev.api.application.inbound.dto.request;

import dev.api.common.annotations.RequiredEnum;
import dev.api.domain.enums.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

@Schema(name = "User", description = "User creation request body.")
public record CreateUserRequest(
        @Schema(name = "name", description = "User name.", examples = "John Doe")
        @NotBlank(message = "{request.user.name.empty}")
        @Length(max = 200, message = "{request.user.name.length}")
        String name,

        @Schema(name = "email", description = "User email", examples = "example@domain.com")
        @NotBlank(message = "{request.user.email.empty}")
        @Email(message = "{request.user.email.validation}")
        String email,

        @Schema(name = "nickname", description = "User nickname.", examples = "_john_doe23")
        @NotBlank(message = "{request.user.nickname.empty}")
        @Length(max = 32, min = 6, message = "{request.user.nickname.length}")
        String nickname,

        @Schema(name = "password", description = "User name.", examples = "*********")
        @NotBlank(message = "{request.user.password.empty}")
        @Length(max = 16, min = 8, message = "{request.user.password.length}")
        String password,

        @Schema(name = "role", description = "User role (GUEST, ADMIN or UNKNOWN).", examples = "ADMIN")
        @NotBlank(message = "{request.user.role.empty}")
        @RequiredEnum(enumClass = RoleType.class, message = "{request.user.role.validation}")
        String role
) {
}
