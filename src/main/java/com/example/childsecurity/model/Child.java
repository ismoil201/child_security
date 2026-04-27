package com.example.childsecurity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "children")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String deviceId; // Android device ID

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parent;
}
