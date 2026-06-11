package com.chronicles.log.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "civilization")
public class Civilization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;
    private Integer foundedYear;
    private Integer collapsedYear;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
