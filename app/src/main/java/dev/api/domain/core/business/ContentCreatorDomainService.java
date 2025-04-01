package dev.api.domain.core.business;

import dev.api.application.config.ApplicationProperties;
import dev.api.application.config.MessageConfig;
import dev.api.application.inbound.dto.request.CreateContentCreatorRequest;
import dev.api.application.inbound.dto.response.ContentCreatorResponse;
import dev.api.domain.core.builder.ContentCreatorBuilder;
import dev.api.domain.entities.User;
import dev.api.domain.ports.services.ContentCreatorService;
import dev.api.infrastructure.database.ContentCreatorRepository;
import dev.api.infrastructure.database.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped //@Component do Quarkus
public class ContentCreatorDomainService implements ContentCreatorService {
    @Inject
    ContentCreatorRepository contentCreatorRepository;

    @Inject
    UserRepository userRepository;
    @Inject
    MessageConfig messageConfig;

    @Inject
    ApplicationProperties applicationProperties;

    @Override
    public ContentCreatorResponse create(CreateContentCreatorRequest request, UUID userId) {
        try {
            var user = userRepository.findById(userId).orElseThrow();
            validateUser(user);

            var contentCreator = ContentCreatorBuilder.requestToDomain(request);
            contentCreatorRepository.persist(contentCreator);

            user.defineContentCreator(contentCreator);
            userRepository.persist(user);

            return contentCreator.toResponse();
        } catch (Exception e) {
            log().error(e.getMessage());
            throw e;
        }

    }

    private void validateUser(User user){
        if(user.isContentCreator()){
            //throw exception
            //TODO criar exception para isso
        }
    }
}
