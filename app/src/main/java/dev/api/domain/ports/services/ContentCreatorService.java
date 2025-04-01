package dev.api.domain.ports.services;

import dev.api.application.inbound.dto.request.CreateContentCreatorRequest;
import dev.api.application.inbound.dto.response.ContentCreatorResponse;
import dev.api.common.extensions.Loggable;

import java.util.UUID;

public interface ContentCreatorService extends Loggable {
    ContentCreatorResponse create(CreateContentCreatorRequest request, UUID userId);
}
