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
@Table(name = "watch_history")
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "current_timestamp", nullable = false)
    private Long currentTimestamp;

    @Column(name = "last_watch", nullable = false)
    private LocalDateTime lastWatch;

    @Column(name = "is_complete", nullable = false)
    private Boolean isComplete;

    @ManyToOne
    @JoinColumn(name = "user_id", table = "users")
    private User user;

    @ManyToOne
    @JoinColumn(name = "video_id", table = "video")
    private Video video;
}
