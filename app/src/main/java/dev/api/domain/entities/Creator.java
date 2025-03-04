package dev.api.domain.entities;

import dev.api.application.inbound.dto.response.CreatorResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Optional;

@Entity
@Table(name = "creator")
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "bio", nullable = false, length = 5000)
    private String bio;

    public CreatorResponse toResponse() {
        return new CreatorResponse(id, name, bio);
    }

    public static Creator create(String name, String bio) {
        var creator = new Creator();
        creator.name = name;
        creator.bio = Optional.of(bio).orElse("Hi. I'm " + name);

        return creator;
    }
}
