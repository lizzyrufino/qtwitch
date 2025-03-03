package dev.api.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDateTime lastWatched;

    private Long progressInSeconds;
    @ManyToOne

    private User user;
    @ManyToOne
    private Video video;

}
