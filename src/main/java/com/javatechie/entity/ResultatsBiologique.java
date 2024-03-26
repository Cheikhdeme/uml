package com.javatechie.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ResultatsBiologique{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean sinusal;
    private boolean tachycardie;
    private boolean troublesConductifs;
    private boolean HAG;
    private boolean HVG;
    private boolean HAD;
    private boolean HVD;
    private boolean FA;
    @ElementCollection
    private List<String> autres;

    @OneToOne
    @JoinColumn(name = "signesParaclinique_id")
    private SignesParaclinique signesParaclinique;

}

