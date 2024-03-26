package com.javatechie.dto;



import com.javatechie.entity.Patient;
import com.javatechie.enumeration.NiveauSocioEconomique;
import com.javatechie.enumeration.StatutMatrimonial;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PatientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private StatutMatrimonial statutMatrimonial;
    private int age;
    private String adresse;
    private String telephone;
    private String profession;
    private NiveauSocioEconomique niveauSocioEconomique;
    private List<FicheDTO> fiches;

    public static PatientDTO convertToDTO(Patient patient) {
        if (patient == null) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setNom(patient.getNom());
        patientDTO.setPrenom(patient.getPrenom());
        patientDTO.setStatutMatrimonial(patient.getStatutMatrimonial());
        patientDTO.setAge(patient.getAge());
        patientDTO.setAdresse(patient.getAdresse());
        patientDTO.setTelephone(patient.getTelephone());
        patientDTO.setProfession(patient.getProfession());
        patientDTO.setNiveauSocioEconomique(patient.getNiveauSocioEconomique());

        if (patient.getFiches() != null) {
            patientDTO.setFiches(patient.getFiches().stream()
                    .map(FicheDTO::convertToDTO)
                    .collect(Collectors.toList()));
        }

        return patientDTO;
    }

    public static Patient convertToEntity(PatientDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setNom(patientDTO.getNom());
        patient.setPrenom(patientDTO.getPrenom());
        patient.setStatutMatrimonial(patientDTO.getStatutMatrimonial());
        patient.setAge(patientDTO.getAge());
        patient.setAdresse(patientDTO.getAdresse());
        patient.setTelephone(patientDTO.getTelephone());
        patient.setProfession(patientDTO.getProfession());
        patient.setNiveauSocioEconomique(patientDTO.getNiveauSocioEconomique());

        if (patientDTO.getFiches() != null) {
            patient.setFiches(patientDTO.getFiches().stream()
                    .map(FicheDTO::convertToEntity)
                    .collect(Collectors.toList()));
        }

        return patient;
    }
}





