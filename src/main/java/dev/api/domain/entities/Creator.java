package dev.api.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String bio;
    @OneToMany(mappedBy = "creator")
    private List<Video> videos;
}
