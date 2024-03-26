package com.javatechie.dto;

import com.javatechie.entity.AntecedentsGynecoObstetricaux;
import lombok.Data;

import com.javatechie.entity.AntecedentsGynecoObstetricaux;

@Data
public class AntecedentsGynecoObstetricauxDTO {

    private Long id;
    private int menarche;
    private int gestite;
    private int parite;
    private boolean grossessesGemellaires;
    private boolean tocolyseProlongee;
    private boolean antecedentDecompensation;
    private int nbDecompensations;

    public static AntecedentsGynecoObstetricauxDTO convertToDTO(AntecedentsGynecoObstetricaux antecedentsGynecoObstetricaux) {
        AntecedentsGynecoObstetricauxDTO dto = new AntecedentsGynecoObstetricauxDTO();
        dto.setId(antecedentsGynecoObstetricaux.getId());
        dto.setMenarche(antecedentsGynecoObstetricaux.getMenarche());
        dto.setGestite(antecedentsGynecoObstetricaux.getGestite());
        dto.setParite(antecedentsGynecoObstetricaux.getParite());
        dto.setGrossessesGemellaires(antecedentsGynecoObstetricaux.isGrossessesGemellaires());
        dto.setTocolyseProlongee(antecedentsGynecoObstetricaux.isTocolyseProlongee());
        dto.setAntecedentDecompensation(antecedentsGynecoObstetricaux.isAntecedentDecompensation());
        dto.setNbDecompensations(antecedentsGynecoObstetricaux.getNbDecompensations());
        return dto;
    }

    public static AntecedentsGynecoObstetricaux convertToEntity(AntecedentsGynecoObstetricauxDTO dto) {
        AntecedentsGynecoObstetricaux antecedentsGynecoObstetricaux = new AntecedentsGynecoObstetricaux();
        antecedentsGynecoObstetricaux.setId(dto.getId());
        antecedentsGynecoObstetricaux.setMenarche(dto.getMenarche());
        antecedentsGynecoObstetricaux.setGestite(dto.getGestite());
        antecedentsGynecoObstetricaux.setParite(dto.getParite());
        antecedentsGynecoObstetricaux.setGrossessesGemellaires(dto.isGrossessesGemellaires());
        antecedentsGynecoObstetricaux.setTocolyseProlongee(dto.isTocolyseProlongee());
        antecedentsGynecoObstetricaux.setAntecedentDecompensation(dto.isAntecedentDecompensation());
        antecedentsGynecoObstetricaux.setNbDecompensations(dto.getNbDecompensations());
        return antecedentsGynecoObstetricaux;
    }
}

