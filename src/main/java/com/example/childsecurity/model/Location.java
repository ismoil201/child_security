package com.example.childsecurity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Location {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;
    private Double longitude;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
