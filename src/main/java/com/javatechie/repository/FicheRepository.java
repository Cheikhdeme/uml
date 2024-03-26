package com.javatechie.repository;



import com.javatechie.entity.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FicheRepository extends JpaRepository<Fiche, Long> {
    Fiche findFichesByNumero(String numero);
    List<Fiche> findFichesByCreatedAt(Date date);

}
