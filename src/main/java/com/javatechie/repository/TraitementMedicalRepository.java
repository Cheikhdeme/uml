package com.javatechie.repository;

import com.javatechie.entity.Bebe;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.ModaliteEvolutionHospitalisation;
import com.javatechie.entity.TraitementMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraitementMedicalRepository extends JpaRepository<TraitementMedical,Long> {

    TraitementMedical findTraitementMedicalByEvolutionApresSorties(EvolutionApresSortie evolutionApresSortie);
    TraitementMedical   findTraitementMedicalByBebe(Bebe bebe);
    TraitementMedical findTraitementMedicalByModaliteEvolutionHospitalisation(ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation);

}
