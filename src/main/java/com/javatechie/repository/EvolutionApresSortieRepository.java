package com.javatechie.repository;


import com.javatechie.entity.Biologie;
import com.javatechie.entity.ETT;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.EvolutionBebe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolutionApresSortieRepository extends JpaRepository<EvolutionApresSortie,Long> {
    EvolutionApresSortie findEvolutionApresSortieByBiologie(Biologie biologie);
    EvolutionApresSortie findEvolutionApresSortieByEtt(ETT ett);
    EvolutionApresSortie findEvolutionApresSortieByEvolutionBebe(EvolutionBebe evolutionBebe);

}
