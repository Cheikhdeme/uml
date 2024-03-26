package com.javatechie.entity;


import com.javatechie.enumeration.TypeInsuffisanceCardiaque;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AntecedentMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean htaGravidique;
    @ElementCollection
    private List<String> autres;
    private TypeInsuffisanceCardiaque typeInsuffisanceCardiaque;
    private boolean hospitalisationsAnterieures;
    private int nbHospitalisationsAnterieures;

    @OneToOne
    @JoinColumn(name = "antecedentsPersonnel_id")
    private AntecedentsPersonnel antecedentsPersonnel;


}
