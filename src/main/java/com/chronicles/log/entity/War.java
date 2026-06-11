package com.chronicles.log.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "wars")
public class War {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer startYear;
    private  Integer endYear;

    @Column(columnDefinition = "TEXT")
    private String description;



}
