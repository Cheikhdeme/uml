package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TraitementMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean diuretique;
    private boolean IEC;
    private boolean tonicardiaque;
    private boolean bromocriptine;
    private boolean anticoagulants;
    private boolean betabloquants;
    private boolean contraception;
    @ElementCollection
    private List<String> autres;

    @OneToMany(mappedBy = "traitementMedical")
    private List<EvolutionApresSortie> evolutionApresSorties;

    @OneToOne(mappedBy = "traitementMedical")
    private Bebe bebe;

    @OneToOne(mappedBy = "traitementMedical")
    private ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation;

    @OneToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche;

}