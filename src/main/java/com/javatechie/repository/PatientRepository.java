package com.javatechie.repository;

import com.javatechie.dto.PatientDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientByPrenom(String prenom);
    List<Patient> findPatientByAdresse(String adresse);
    Patient findPatientByFiches(Fiche fiche);


}
