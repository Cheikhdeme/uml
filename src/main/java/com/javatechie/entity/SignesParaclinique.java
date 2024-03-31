package com.javatechie.entity;


import com.javatechie.enumeration.FuiteValvulaire;
import com.javatechie.enumeration.StenoseValvulaire;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class SignesParaclinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean telecoeur;
    private double indexCardiothoracique;
    @ElementCollection
    private List<String> autreSignes;
    private boolean ECG;
    private boolean epanchementPericardique;
    private FuiteValvulaire fuiteValvulaire;
    private StenoseValvulaire stenoseValvulaire;


    @OneToOne(mappedBy = "signesParaclinique")
    private ResultatsBiologique resultatsBiologique;

    @OneToOne(mappedBy = "signesParaclinique")
    private ETT ett;

    @OneToOne(mappedBy = "signesParaclinique")
    private Biologie biologie;

    @OneToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche;





}


