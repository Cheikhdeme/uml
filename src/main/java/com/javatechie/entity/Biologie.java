package com.javatechie.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Biologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double hemoglobinemie;
    private double GB;
    private double plaquettes;
    private double VGM;
    private double CCMH;
    private double TCMH;
    private double DTOC;
    private double CRP;
    private double uree;
    private double creatininemie;
    private double NTproBNP;
    private double prolactine;
    private double NFS;
    private double FEVG;

    @OneToOne
    @JoinColumn(name = "signesParaclinique_id")
    private SignesParaclinique signesParaclinique;

    @OneToOne
    @JoinColumn(name = "evolutionApresSortie_id")
    private EvolutionApresSortie evolutionApresSortie;


}
