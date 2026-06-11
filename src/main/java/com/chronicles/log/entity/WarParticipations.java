package com.chronicles.log.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "warparticapations")
public class WarParticipations{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="war_id")
    private War war;

    @ManyToOne
    @JoinColumn(name="civilization_id")
    private Civilization civilization;

    @Enumerated(EnumType.STRING)
    private Side side;

}
