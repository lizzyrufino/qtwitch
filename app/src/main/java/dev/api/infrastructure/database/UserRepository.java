package dev.api.infrastructure.database;

import dev.api.domain.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public Optional<User> findByEmailAndNickname(String name, String nickname) {
        return find("email = ?1 and name = ?2", name, nickname).firstResultOptional();
    }

    public Optional<User> findById(UUID id) {
        return find("id= ?1", id).firstResultOptional();
    }
}
