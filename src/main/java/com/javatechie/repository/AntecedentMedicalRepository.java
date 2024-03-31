package com.javatechie.repository;

import com.javatechie.entity.AntecedentMedical;
import com.javatechie.entity.AntecedentsPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AntecedentMedicalRepository extends JpaRepository<AntecedentMedical,Long> {
}
