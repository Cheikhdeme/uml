package com.javatechie.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ETT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double DTDVG;
    private double DTSV;
    private double DTOG;
    private double FEVG;
    private double TAPSE;
    private double EoverEprime;
    private double TD;
    private double E;

    @OneToOne
    @JoinColumn(name = "signesParaclinique_id")
    private SignesParaclinique signesParaclinique;

    @OneToOne
    @JoinColumn(name = "evolutionApresSortie_id")
    private EvolutionApresSortie evolutionApresSortie;

}
