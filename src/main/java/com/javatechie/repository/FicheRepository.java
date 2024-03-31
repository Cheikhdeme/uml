package com.javatechie.repository;



import com.javatechie.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FicheRepository extends JpaRepository<Fiche, Long> {
    Fiche findFichesByNumero(String numero);
    List<Fiche> findFichesByCreatedAt(Date date);
    Fiche findFichesBySignesClinique(SignesClinique signesClinique);
    Fiche findFichesByTraitementMedical(TraitementMedical traitementMedical);
    Fiche findByAntecedentsPersonnel(AntecedentsPersonnel antecedentsPersonnel);
    Fiche findFichesBySignesParaclinique(SignesParaclinique signesParaclinique);

}
