package dev.api.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Boolean rating;
    private String comment;
    private LocalDateTime reviewDate;

    @OneToOne
    private User user;

    @ManyToOne
    private Video video;

}
