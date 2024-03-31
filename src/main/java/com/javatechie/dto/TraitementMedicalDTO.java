package com.javatechie.dto;



import com.javatechie.entity.TraitementMedical;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TraitementMedicalDTO {
    private Long id;

    private boolean diuretique;
    private boolean IEC;
    private boolean tonicardiaque;
    private boolean bromocriptine;
    private boolean anticoagulants;
    private boolean betabloquants;
    private boolean contraception;
    private List<String> autres;

    private List<EvolutionApresSortieDTO> evolutionApresSorties;
    private BebeDTO bebe;
    private ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisation;

    public static TraitementMedical convertToEntity(TraitementMedicalDTO traitementMedicalDTO) {
        TraitementMedical traitementMedical = new TraitementMedical();
        traitementMedical.setId(traitementMedicalDTO.getId());
        traitementMedical.setDiuretique(traitementMedicalDTO.isDiuretique());
        traitementMedical.setIEC(traitementMedicalDTO.isIEC());
        traitementMedical.setBromocriptine(traitementMedicalDTO.isBromocriptine());
        traitementMedical.setAnticoagulants(traitementMedicalDTO.isAnticoagulants());
        traitementMedical.setContraception(traitementMedicalDTO.isContraception());
        traitementMedical.setTonicardiaque(traitementMedicalDTO.isTonicardiaque());
        traitementMedical.setBetabloquants(traitementMedicalDTO.isBetabloquants());
        traitementMedical.setAutres(traitementMedicalDTO.getAutres());
        // Assurez-vous que les propriétés sont initialisées pour éviter les erreurs de NullPointerException
        if (traitementMedicalDTO.getEvolutionApresSorties() != null) {
            traitementMedical.setEvolutionApresSorties(traitementMedicalDTO.getEvolutionApresSorties().stream()
                    .map(EvolutionApresSortieDTO::convertToEntity)
                    .collect(Collectors.toList()));
        }
        if (traitementMedicalDTO.getBebe() != null) {
            traitementMedical.setBebe(BebeDTO.convertToEntity(traitementMedicalDTO.getBebe()));
        }
        if (traitementMedicalDTO.getModaliteEvolutionHospitalisation() != null) {
            traitementMedical.setModaliteEvolutionHospitalisation(ModaliteEvolutionHospitalisationDTO.convertToEntity(traitementMedicalDTO.getModaliteEvolutionHospitalisation()));
        }
        // Autres propriétés
        return traitementMedical;
    }

    public static TraitementMedicalDTO convertToDTO(TraitementMedical traitementMedical) {
        TraitementMedicalDTO traitementMedicalDTO = new TraitementMedicalDTO();
        traitementMedicalDTO.setId(traitementMedical.getId());
        traitementMedicalDTO.setDiuretique(traitementMedical.isDiuretique());
        traitementMedicalDTO.setIEC(traitementMedical.isIEC());
        traitementMedicalDTO.setBromocriptine(traitementMedical.isBromocriptine());
        traitementMedicalDTO.setAnticoagulants(traitementMedical.isAnticoagulants());
        traitementMedicalDTO.setContraception(traitementMedical.isContraception());
        traitementMedicalDTO.setTonicardiaque(traitementMedical.isTonicardiaque());
        traitementMedicalDTO.setBetabloquants(traitementMedical.isBetabloquants());
        traitementMedicalDTO.setAutres(traitementMedical.getAutres());
        // Assurez-vous que les propriétés sont initialisées pour éviter les erreurs de NullPointerException
        if (traitementMedical.getEvolutionApresSorties() != null) {
            traitementMedicalDTO.setEvolutionApresSorties(traitementMedical.getEvolutionApresSorties().stream()
                    .map(EvolutionApresSortieDTO::convertToDTO)
                    .collect(Collectors.toList()));
        }
        if (traitementMedical.getBebe() != null) {
            traitementMedicalDTO.setBebe(BebeDTO.convertToDTO(traitementMedical.getBebe()));
        }
        if (traitementMedical.getModaliteEvolutionHospitalisation() != null) {
            traitementMedicalDTO.setModaliteEvolutionHospitalisation(ModaliteEvolutionHospitalisationDTO.convertToDTO(traitementMedical.getModaliteEvolutionHospitalisation()));
        }
        // Autres propriétés
        return traitementMedicalDTO;
    }

}
