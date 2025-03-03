package dev.api.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String plan;
    private Double price;
    private LocalDateTime starterDate;
    private LocalDateTime endDate;
    @ManyToOne
    private User user;
}
