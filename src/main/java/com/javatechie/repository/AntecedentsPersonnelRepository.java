package com.javatechie.repository;

import com.javatechie.entity.AntecedentMedical;
import com.javatechie.entity.AntecedentsGynecoObstetricaux;
import com.javatechie.entity.AntecedentsPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntecedentsPersonnelRepository extends JpaRepository<AntecedentsPersonnel,Long> {

    AntecedentsPersonnel findAntecedentsPersonnelByAntecedentMedical(AntecedentMedical antecedentMedical );
    AntecedentsPersonnel findAntecedentsPersonnelByAntecedentsGynecoObstetricaux(AntecedentsGynecoObstetricaux antecedentsGynecoObstetricaux);
}
