package com.javatechie.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AntecedentsGynecoObstetricaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int menarche;
    private int gestite;
    private int parite;
    private boolean grossessesGemellaires;
    private boolean tocolyseProlongee;
    private boolean antecedentDecompensation;
    private int nbDecompensations;

    @OneToOne
    @JoinColumn(name = "antecedentsPersonnel_id")
    private AntecedentsPersonnel antecedentsPersonnel;


}
