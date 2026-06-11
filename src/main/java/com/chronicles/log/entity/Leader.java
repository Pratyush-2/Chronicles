package com.chronicles.log.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "leaders")
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    String name;
    private Integer birthYear;
    private Integer deathYear;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "civilization_id")
    private Civilization civilization;


}
