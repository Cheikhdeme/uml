package com.javatechie.entity;

import com.javatechie.dto.PatientDTO;
import com.javatechie.enumeration.NiveauSocioEconomique;
import com.javatechie.enumeration.StatutMatrimonial;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private StatutMatrimonial statutMatrimonial;

    private int age;
    private String adresse;
    private String telephone;
    private String profession;

    @Enumerated(EnumType.STRING)
    private NiveauSocioEconomique niveauSocioEconomique;

    @OneToMany(mappedBy = "patient")
    private List<Fiche> fiches;






}


