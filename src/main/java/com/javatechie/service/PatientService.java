package com.javatechie.service;

import com.javatechie.dto.PatientDTO;
import com.javatechie.entity.Patient;
import com.javatechie.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.javatechie.dto.PatientDTO.convertToDTO;
import static com.javatechie.dto.PatientDTO.convertToEntity;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Méthode pour sauvegarder un patient
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        return convertToDTO( patientRepository.save(patient));
    }

    // Méthode pour récupérer tous les patients
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    // Méthode pour récupérer un patient par son ID
    public Optional<PatientDTO> getPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.map(PatientDTO::convertToDTO);
    }

    // Méthode pour mettre à jour les informations d'un patient
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = convertToEntity(patientDTO);
            patient.setId(id);
            return convertToDTO(patientRepository.save(patient));
        } else {
            throw new IllegalArgumentException("Patient non trouvé avec l'ID : " + id);
        }
    }

    // Méthode pour supprimer un patient par son ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
