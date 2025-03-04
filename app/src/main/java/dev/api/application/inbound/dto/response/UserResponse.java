package dev.api.application.inbound.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(name = "User", description = "User response.", implementation = UserResponse.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponse(
        @Schema(name = "id", description = "User id.", examples = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(name = "name", description = "User name.", examples = "John Doe")
        String name,

        @Schema(name = "email", description = "User email.", examples = "john.doe@gmail.com")
        String email,

        @Schema(name = "nickname", description = "User nickname.", examples = "_john_doe23")
        String nickname,

        @Schema(name = "role", description = "User role.", examples = "ADMIN")
        String role,

        @Schema(name = "followers", description = "User followers.", examples = "890")
        Long followers,

        @Schema(name = "followings", description = "Users that the user follow.", examples = "1054")
        Long following,

        @Schema(name = "createdAt", description = "User creation date.", examples = "05/13/2025")
        LocalDateTime createdAt,

        @Schema(name = "createdAt", description = "User last update date.", examples = "05/13/2025")
        LocalDateTime updatedAt,

        @Schema(name = "createdAt", description = "User subscription profile.",
                implementation = SubscriptionResponse.class)
        SubscriptionResponse subscription,

        @Schema(name = "createdAt", description = "User creator profile.", implementation = CreatorResponse.class)
        CreatorResponse creator
) {
}
