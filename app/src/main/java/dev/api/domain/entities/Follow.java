package dev.api.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_following_id", table = "users")
    private User userFollowing;

    @ManyToOne
    @JoinColumn(name = "user_followed_id", table = "users")
    private User userFollowed;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
