package com.javatechie.dto;


import com.javatechie.entity.AntecedentsPersonnel;
import lombok.Data;

@Data
public class AntecedentsPersonnelDTO {

    private Long id;
    private AntecedentMedicalDTO antecedentMedical;
    private AntecedentsGynecoObstetricauxDTO antecedentsGynecoObstetricaux;



    public static AntecedentsPersonnelDTO convertToDTO(AntecedentsPersonnel antecedentsPersonnel) {
        AntecedentsPersonnelDTO dto = new AntecedentsPersonnelDTO();
        dto.setId(antecedentsPersonnel.getId());
        if (antecedentsPersonnel.getAntecedentMedical() != null) {
            dto.setAntecedentMedical(AntecedentMedicalDTO.convertToDTO(antecedentsPersonnel.getAntecedentMedical()));
        }
        if (antecedentsPersonnel.getAntecedentsGynecoObstetricaux() != null) {
            dto.setAntecedentsGynecoObstetricaux(AntecedentsGynecoObstetricauxDTO.convertToDTO(antecedentsPersonnel.getAntecedentsGynecoObstetricaux()));
        }
        return dto;
    }

    public static AntecedentsPersonnel convertToEntity(AntecedentsPersonnelDTO dto) {
        AntecedentsPersonnel antecedentsPersonnel = new AntecedentsPersonnel();
        antecedentsPersonnel.setId(dto.getId());
        if (dto.getAntecedentMedical() != null) {
            antecedentsPersonnel.setAntecedentMedical(AntecedentMedicalDTO.convertToEntity(dto.getAntecedentMedical()));
        }
        if (dto.getAntecedentsGynecoObstetricaux() != null) {
            antecedentsPersonnel.setAntecedentsGynecoObstetricaux(AntecedentsGynecoObstetricauxDTO.convertToEntity(dto.getAntecedentsGynecoObstetricaux()));
        }
        return antecedentsPersonnel;
    }
}
