package com.javatechie.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "fiches")
public class Fiche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "fiche")
    private SignesClinique signesClinique;

    @OneToOne(mappedBy = "fiche")
    private SignesParaclinique signesParaclinique;

    @OneToOne(mappedBy = "fiche")
    private AntecedentsPersonnel antecedentsPersonnel;

    @OneToOne(mappedBy = "fiche")
    private TraitementMedical traitementMedical;


}
