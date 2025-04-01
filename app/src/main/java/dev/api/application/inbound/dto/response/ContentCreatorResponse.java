package dev.api.application.inbound.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Creator", description = "Creator profile.", implementation = ContentCreatorResponse.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ContentCreatorResponse(

        @Schema(name = "id", description = "Creator profile id.", examples = "550e8400-e29b-41d4-a716-446655440000")
        String id,

        @Schema(name = "name", description = "Creator profile name.", examples = "JohnzinDoed")
        String name,

        @Schema(name = "bio", description = "Creator profile bio.", examples = """
                # Title
                
                > quotes
                
                - list 1
                - list 2
                """)
        String bio
) {
}
