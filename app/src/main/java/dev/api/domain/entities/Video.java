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
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "url", nullable = false, updatable = false)
    private String url;

    @Column(name = "views", nullable = false)
    private Long views;

    @Column(name = "timestamp", nullable = false)
    private Long timestamp;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "creator_id", table = "creator")
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "category_id", table = "category")
    private Category category;
}
