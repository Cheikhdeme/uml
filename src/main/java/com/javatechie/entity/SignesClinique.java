package com.javatechie.entity;

import com.javatechie.enumeration.TypeDyspnee;
import com.javatechie.enumeration.TypeSouffle;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "signeCliniques")

public class SignesClinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean dyspneeEffort;
    private TypeDyspnee typeDyspnee;
    private boolean oedemePoumon;
    private boolean toux;
    private boolean palpitations;
    private boolean omi;
    private double taille;
    private double poids;
    private double temperature;
    private double IMC;
    private double TA;
    private double FC;
    private boolean souffleCardiaque;
    private TypeSouffle typeSouffle;
    private boolean TSVJ;
    private boolean hepatomegalie;

    @OneToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche;
}




