package com.javatechie.service;

import com.javatechie.dto.FicheDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.Patient;
import com.javatechie.repository.FicheRepository;
import com.javatechie.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.javatechie.dto.FicheDTO.convertToDTO;
import static com.javatechie.dto.FicheDTO.convertToEntity;

@Service
public class FicheService {

    @Autowired
    private FicheRepository ficheRepository;

    @Autowired
    private PatientRepository patientRepository;


    public FicheDTO saveFiche(FicheDTO ficheDTO, Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            Fiche fiche = convertToEntity(ficheDTO);
            fiche.setCreatedAt(new Date());
            fiche.setPatient(patient);
            return convertToDTO(ficheRepository.save(fiche));
        } else {
            throw new IllegalArgumentException("Patient not found with ID: " + patientId);
        }
    }

    public List<FicheDTO> getAllFiches() {
        return ficheRepository.findAll().stream()
                .map(FicheDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<FicheDTO> getFicheById(Long id) {
        return ficheRepository.findById(id)
                .map(FicheDTO::convertToDTO);
    }

    public FicheDTO updateFiche(Long id, FicheDTO ficheDTO) {
        ficheDTO.setId(id);
        Fiche fiche = convertToEntity(ficheDTO);
        Patient patient= patientRepository.findPatientByFiches(fiche);
        fiche.setPatient(patient);
        return convertToDTO(ficheRepository.save(fiche));
    }

    public void deleteFiche(Long id) {
        ficheRepository.deleteById(id);
    }


}
