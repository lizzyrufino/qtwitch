package dev.api.domain.core.builder;

import dev.api.application.inbound.dto.request.CreateContentCreatorRequest;
import dev.api.domain.entities.ContentCreator;

public class ContentCreatorBuilder {
    public static ContentCreator requestToDomain(CreateContentCreatorRequest request) {
        return ContentCreator.create(request.name(), request.bio());
    }
}
