package com.javatechie.entity;

import com.javatechie.enumeration.ClasseNYHA;
import com.javatechie.enumeration.LieuDeces;
import com.javatechie.enumeration.Mois;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class EvolutionApresSortie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ClasseNYHA classeNYHA;
    private boolean deces;
    private Date dateDeces;
    private LieuDeces lieuDeces;
    private boolean bonneObservanceTherapeutique;
    private int nbRehospitalisations;
    private String facteursDecompensation;
    private Mois mois;

    @OneToOne(mappedBy = "evolutionApresSortie")
    private ETT ett;

    @OneToOne(mappedBy = "evolutionApresSortie")
    private Biologie biologie;

    @OneToOne(mappedBy = "evolutionApresSortie")
    private EvolutionBebe evolutionBebe;

    @ManyToOne
    @JoinColumn(name = "traitementMedical_id")
    private TraitementMedical traitementMedical;







}
