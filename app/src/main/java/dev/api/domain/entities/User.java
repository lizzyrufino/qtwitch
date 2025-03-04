package dev.api.domain.entities;

import dev.api.application.inbound.dto.response.UserResponse;
import dev.api.domain.enums.RoleType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 450)
    private String name;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false, length = 16, unique = true)
    private String nickname;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "salt_key", nullable = false, length = 32)
    private String saltKey;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleType role;

    @Column(name = "followers", nullable = false)
    private Long followers;

    @Column(name = "following", nullable = false)
    private Long following;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "subscription_id", table = "subscription")
    private Subscription subscription;

    @OneToOne
    @JoinColumn(name = "creator_id", table = "creator")
    private Creator creator;

    public UserResponse toResponse() {
        var responseSubscription = Objects.nonNull(subscription) ? subscription.toResponse() : null;
        var responseCreator = Objects.nonNull(creator) ? creator.toResponse() : null;

        return new UserResponse(id, name, email, nickname, role.name(), followers, following, createdAt, updatedAt,
                responseSubscription, responseCreator);
    }

    public static User create(String name, String email, String nickname, String password, String saltKey, RoleType role) {
        var user = new User();

        user.name = name;
        user.email = email;
        user.nickname = nickname;
        user.password = password;
        user.saltKey = saltKey;
        user.role = role;
        user.followers = 0L;
        user.following = 0L;
        user.createdAt = LocalDateTime.now();

        return user;
    }
}
