package dev.api.domain.core.business;

import dev.api.application.config.ApplicationProperties;
import dev.api.application.config.MessageConfig;
import dev.api.application.exceptions.ConflictException;
import dev.api.application.exceptions.InternalServerErrorException;
import dev.api.application.inbound.dto.request.CreateUserRequest;
import dev.api.application.inbound.dto.response.UserResponse;
import dev.api.domain.entities.User;
import dev.api.domain.ports.services.UserService;
import dev.api.common.constants.MessageCodes;
import dev.api.common.tools.CipherTool;
import dev.api.common.tools.RandomStringGenerator;
import dev.api.domain.core.builder.UserBuilder;
import dev.api.infrastructure.database.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserDomainService implements UserService {


    @Inject
    UserRepository userRepository;

    @Inject
    MessageConfig messageConfig;

    @Inject
    ApplicationProperties applicationProperties;


    @Override
    public UserResponse create(CreateUserRequest request) {
        try {
            validateUserAlreadyExists(request);

            var saltKey = generateSaltKey();
            var cryptPassword = cryptPassword(request.password(), saltKey);

            var user = UserBuilder.requestToDomain(request, saltKey, cryptPassword);

            userRepository.persist(user);
            return user.toResponse();
        } catch (Exception e) {
            log().error(e.getMessage());
            throw e;
        }

    }

    @Override
    public List<UserResponse> list() {
        try{
           info(MessageCodes.LOG_TO_LIST_USERS);
           var users =  userRepository.listAll();
           return users.stream().map(User::toResponse).toList();

        }catch(Exception e){
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
