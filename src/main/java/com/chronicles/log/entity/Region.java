package com.chronicles.log.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private  String description;



}
