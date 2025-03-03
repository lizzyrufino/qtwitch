package dev.api.application.inbound.dto;

import dev.api.commom.annotations.Email;
import dev.api.domain.enums.RoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
        @NotBlank(message = "The name cannot be empty")
        @Length(max = 200,message = "The name is too large" )
        String name,
        @NotBlank(message = "The nickname cannot be empty")
        @Length(max = 32, min =6, message = "The nickname is invalid.")
        String nickname,
        @NotBlank(message = "The password cannot be empty")
        @Length(max = 32, min =8, message = "Invalid password")
        String password,
        @NotEmpty(message = "The email cannot be empty")
        @Email(message = "Invalid Email")
        String email,
        RoleType role

) {
}
