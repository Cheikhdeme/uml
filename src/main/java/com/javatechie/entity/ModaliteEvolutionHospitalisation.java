package com.javatechie.entity;

import com.javatechie.enumeration.AspectDefavorable;
import com.javatechie.enumeration.QualiteEvolution;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class ModaliteEvolutionHospitalisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private QualiteEvolution qualiteEvolution;
    private AspectDefavorable aspectDefavorable;
    @ElementCollection
    private List<String> complications;
    private Date delaiDeces;

    @OneToOne
    @JoinColumn(name = "traitementMedical_id")
    private TraitementMedical traitementMedical;






}
