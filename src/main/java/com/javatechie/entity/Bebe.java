package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bebe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean mortNe;
    private boolean premature;
    private double poidsNaissance;

    @OneToOne
    @JoinColumn(name = "traitementMedical_id")
    private TraitementMedical traitementMedical;
}
