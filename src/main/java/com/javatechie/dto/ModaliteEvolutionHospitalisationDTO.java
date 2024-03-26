package com.javatechie.dto;

import com.javatechie.entity.ModaliteEvolutionHospitalisation;
import com.javatechie.enumeration.AspectDefavorable;
import com.javatechie.enumeration.QualiteEvolution;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ModaliteEvolutionHospitalisationDTO {

    private Long id;
    private QualiteEvolution qualiteEvolution;
    private AspectDefavorable aspectDefavorable;
    private List<String> complications;
    private Date delaiDeces;

    public static ModaliteEvolutionHospitalisationDTO convertToDTO(ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation) {
        ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO = new ModaliteEvolutionHospitalisationDTO();
        modaliteEvolutionHospitalisationDTO.setId(modaliteEvolutionHospitalisation.getId());
        modaliteEvolutionHospitalisationDTO.setQualiteEvolution(modaliteEvolutionHospitalisation.getQualiteEvolution());
        modaliteEvolutionHospitalisationDTO.setAspectDefavorable(modaliteEvolutionHospitalisation.getAspectDefavorable());
        modaliteEvolutionHospitalisationDTO.setComplications(modaliteEvolutionHospitalisation.getComplications());
        modaliteEvolutionHospitalisationDTO.setDelaiDeces(modaliteEvolutionHospitalisation.getDelaiDeces());
        return modaliteEvolutionHospitalisationDTO;
    }

    public static ModaliteEvolutionHospitalisation convertToEntity(ModaliteEvolutionHospitalisationDTO modaliteEvolutionHospitalisationDTO) {
        ModaliteEvolutionHospitalisation modaliteEvolutionHospitalisation = new ModaliteEvolutionHospitalisation();
        modaliteEvolutionHospitalisation.setId(modaliteEvolutionHospitalisationDTO.getId());
        modaliteEvolutionHospitalisation.setQualiteEvolution(modaliteEvolutionHospitalisationDTO.getQualiteEvolution());
        modaliteEvolutionHospitalisation.setAspectDefavorable(modaliteEvolutionHospitalisationDTO.getAspectDefavorable());
        modaliteEvolutionHospitalisation.setComplications(modaliteEvolutionHospitalisationDTO.getComplications());
        modaliteEvolutionHospitalisation.setDelaiDeces(modaliteEvolutionHospitalisationDTO.getDelaiDeces());
        return modaliteEvolutionHospitalisation;
    }
}
