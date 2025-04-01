package dev.api.application.inbound.swagger;

import dev.api.application.inbound.dto.request.CreateContentCreatorRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/creator")
@Tag(name = "Content creator", description = "Content creator operations.")
public interface ContentCreatorSwagger {

    //CREATOR
    @Path("{/userId}")
    @POST
    @Operation(summary = "Create new content creator", description = "Operation to create new content creator.")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "201",
                    name = "Created",
                    description = "New content creator created successfully."
            )
    })
    Response createContentCreator(@PathParam("userId") UUID userId,
                                  @Valid @RequestBody CreateContentCreatorRequest body);
}
