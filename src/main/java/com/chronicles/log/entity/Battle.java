package com.chronicles.log.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "battles")
public class Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer year;
    private String location;
    private Double latitude;
    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "war_id")
    private War war;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
