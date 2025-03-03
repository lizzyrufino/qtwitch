package dev.api.domain.entities;

import dev.api.domain.enums.RoleType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String nickname;
    private String password;
    private String saltKey;
    @Enumerated(value = EnumType.STRING)
    private RoleType role;
    private List<Subscription> subscriptions;

}
