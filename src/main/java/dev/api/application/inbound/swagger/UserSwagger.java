package dev.api.application.inbound.swagger;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/user")
@Tag(name = "User", description = "User operations")
public interface UserSwagger {
    @POST
    @Operation(summary = "Create new user", description = "Operation to create new user")
    void createUser();
}
