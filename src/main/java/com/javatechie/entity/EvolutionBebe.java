package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EvolutionBebe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double poids;
    private String modeAlimentation;

    @OneToOne
    @JoinColumn(name = "evolutionApresSortie_id")
    private EvolutionApresSortie evolutionApresSortie;

}