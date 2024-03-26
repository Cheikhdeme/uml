package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AntecedentsPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "antecedentsPersonnel")
    private AntecedentMedical antecedentMedical;

    @OneToOne(mappedBy = "antecedentsPersonnel")
    private AntecedentsGynecoObstetricaux   antecedentsGynecoObstetricaux;

    @OneToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche;
}
