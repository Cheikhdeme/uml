package com.javatechie.repository;

import com.javatechie.entity.Biologie;
import com.javatechie.entity.ETT;
import com.javatechie.entity.ResultatsBiologique;
import com.javatechie.entity.SignesParaclinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignesParacliniqueRepository extends JpaRepository<SignesParaclinique,Long> {
    SignesParaclinique findSignesParacliniqueByEtt(ETT ett);
    SignesParaclinique findSignesParacliniqueByBiologie(Biologie biologie);
    SignesParaclinique findSignesParacliniqueByResultatsBiologique(ResultatsBiologique resultatsBiologique);
}
