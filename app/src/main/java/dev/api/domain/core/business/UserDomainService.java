package dev.api.domain.core.business;

import dev.api.application.config.ApplicationProperties;
import dev.api.application.config.MessageConfig;
import dev.api.application.exceptions.ConflictException;
import dev.api.application.exceptions.InternalServerErrorException;
import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.application.ports.services.UserService;
import dev.api.common.constants.MessageCodes;
import dev.api.common.tools.CipherTool;
import dev.api.common.tools.RandomStringGenerator;
import dev.api.domain.core.builder.UserBuilder;
import dev.api.infrastructure.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserDomainService implements UserService {


    @Inject
    UserRepository userRepository;

    @Inject
    MessageConfig messageConfig;

    @Inject
    ApplicationProperties applicationProperties;


    @Override
    public void create(CreateUserRequest request) {
        try {
            validateUserAlreadyExists(request);

            var saltKey = generateSaltKey();
            var cryptPassword = cryptPassword(request.password(), saltKey);

            var domain = UserBuilder.requestToDomain(request, saltKey, cryptPassword);

            userRepository.persist(domain);
        } catch (Exception e) {
            log().error(e.getMessage());
            throw e;
        }
    }

    private void validateUserAlreadyExists(CreateUserRequest request) {
        info(MessageCodes.LOG_USER_VALIDATION);
        if (userRepository.findByEmailAndNickname(request.name(), request.nickname()).isPresent()) {
            error(MessageCodes.LOG_USER_ALREADY_EXISTS);
            throw new ConflictException(MessageCodes.CONFLICT_EXCEPTION_USER_ALREADY_EXISTS);
        }
    }

    private String generateSaltKey() {
        return RandomStringGenerator.generateRandomString(32);
    }

    private String cryptPassword(String password, String saltKey) {
        try {
            return CipherTool.encode(password + saltKey, applicationProperties.cipherKey);
        } catch (Exception e) {
            throw new InternalServerErrorException(MessageCodes.INTERNAL_SERVER_ERROR_ENCODE_PASSWORD_ERROR);
        }
    }
}
