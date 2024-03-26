package com.javatechie.dto;

import com.javatechie.entity.AntecedentMedical;
import com.javatechie.enumeration.TypeInsuffisanceCardiaque;
import lombok.Data;

import java.util.List;


@Data
public class AntecedentMedicalDTO {
    private Long id;

    private boolean htaGravidique;
    private List<String> autres;
    private TypeInsuffisanceCardiaque typeInsuffisanceCardiaque;
    private boolean hospitalisationsAnterieures;
    private int nbHospitalisationsAnterieures;

    public static AntecedentMedicalDTO convertToDTO(AntecedentMedical antecedentMedical) {
        AntecedentMedicalDTO antecedentMedicalDTO = new AntecedentMedicalDTO();
        antecedentMedicalDTO.setId(antecedentMedical.getId());
        antecedentMedicalDTO.setHtaGravidique(antecedentMedical.isHtaGravidique());
        antecedentMedicalDTO.setAutres(antecedentMedical.getAutres());
        antecedentMedicalDTO.setTypeInsuffisanceCardiaque(antecedentMedical.getTypeInsuffisanceCardiaque());
        antecedentMedicalDTO.setHospitalisationsAnterieures(antecedentMedical.isHospitalisationsAnterieures());
        antecedentMedicalDTO.setNbHospitalisationsAnterieures(antecedentMedical.getNbHospitalisationsAnterieures());
        return antecedentMedicalDTO;
    }

    public static AntecedentMedical convertToEntity(AntecedentMedicalDTO antecedentMedicalDTO) {
        AntecedentMedical antecedentMedical = new AntecedentMedical();
        antecedentMedical.setId(antecedentMedicalDTO.getId());
        antecedentMedical.setHtaGravidique(antecedentMedicalDTO.isHtaGravidique());
        antecedentMedical.setAutres(antecedentMedicalDTO.getAutres());
        antecedentMedical.setTypeInsuffisanceCardiaque(antecedentMedicalDTO.getTypeInsuffisanceCardiaque());
        antecedentMedical.setHospitalisationsAnterieures(antecedentMedicalDTO.isHospitalisationsAnterieures());
        antecedentMedical.setNbHospitalisationsAnterieures(antecedentMedicalDTO.getNbHospitalisationsAnterieures());
        return antecedentMedical;
    }
}
