package dev.api.application.inbound.dto.response;

import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Error", description = "Default error payload.", implementation = ErrorResponse.class)
public record ErrorResponse(

        @Schema(name = "statusCode", description = "HTTP Status code error.", examples = "400")
        Status statusCode,

        @Schema(name = "message", description = "Error message.", examples = "Error...")
        String message
) {
}
