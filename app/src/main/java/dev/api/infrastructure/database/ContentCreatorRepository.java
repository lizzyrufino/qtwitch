package dev.api.infrastructure.database;

import dev.api.domain.entities.ContentCreator;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContentCreatorRepository implements PanacheRepository<ContentCreator> {
}
