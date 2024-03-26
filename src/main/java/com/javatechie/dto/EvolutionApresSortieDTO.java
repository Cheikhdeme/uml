package com.javatechie.dto;

import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.enumeration.ClasseNYHA;
import com.javatechie.enumeration.LieuDeces;
import com.javatechie.enumeration.Mois;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EvolutionApresSortieDTO {

    private Long id;
    private ClasseNYHA classeNYHA;
    private boolean deces;
    private Date dateDeces;
    private LieuDeces lieuDeces;
    private boolean bonneObservanceTherapeutique;
    private int nbRehospitalisations;
    private String facteursDecompensation;
    private Mois mois;
    private EttDTO ett;
    private  BiologieDTO biologie;
    private EvolutionBebeDTO evolutionBebe;

    public static EvolutionApresSortieDTO convertToDTO(EvolutionApresSortie evolutionApresSortie) {
        EvolutionApresSortieDTO evolutionApresSortieDTO = new EvolutionApresSortieDTO();
        evolutionApresSortieDTO.setId(evolutionApresSortie.getId());
        evolutionApresSortieDTO.setClasseNYHA(evolutionApresSortie.getClasseNYHA());
        evolutionApresSortieDTO.setDeces(evolutionApresSortie.isDeces());
        evolutionApresSortieDTO.setDateDeces(evolutionApresSortie.getDateDeces());
        evolutionApresSortieDTO.setLieuDeces(evolutionApresSortie.getLieuDeces());
        evolutionApresSortieDTO.setBonneObservanceTherapeutique(evolutionApresSortie.isBonneObservanceTherapeutique());
        evolutionApresSortieDTO.setNbRehospitalisations(evolutionApresSortie.getNbRehospitalisations());
        evolutionApresSortieDTO.setFacteursDecompensation(evolutionApresSortie.getFacteursDecompensation());
        evolutionApresSortieDTO.setMois(evolutionApresSortie.getMois());

        // Vérification de nullité avant conversion
        if (evolutionApresSortie.getEtt() != null) {
            evolutionApresSortieDTO.setEtt(EttDTO.convertToDTO(evolutionApresSortie.getEtt()));
        }
        if (evolutionApresSortie.getBiologie() != null) {
            evolutionApresSortieDTO.setBiologie(BiologieDTO.convertToDTO(evolutionApresSortie.getBiologie()));
        }
        if (evolutionApresSortie.getEvolutionBebe() != null) {
            evolutionApresSortieDTO.setEvolutionBebe(EvolutionBebeDTO.convertToDTO(evolutionApresSortie.getEvolutionBebe()));
        }

        return evolutionApresSortieDTO;
    }

    public static EvolutionApresSortie convertToEntity(EvolutionApresSortieDTO evolutionApresSortieDTO) {
        EvolutionApresSortie evolutionApresSortie = new EvolutionApresSortie();
        evolutionApresSortie.setId(evolutionApresSortieDTO.getId());
        evolutionApresSortie.setClasseNYHA(evolutionApresSortieDTO.getClasseNYHA());
        evolutionApresSortie.setDeces(evolutionApresSortieDTO.isDeces());
        evolutionApresSortie.setDateDeces(evolutionApresSortieDTO.getDateDeces());
        evolutionApresSortie.setLieuDeces(evolutionApresSortieDTO.getLieuDeces());
        evolutionApresSortie.setBonneObservanceTherapeutique(evolutionApresSortieDTO.isBonneObservanceTherapeutique());
        evolutionApresSortie.setNbRehospitalisations(evolutionApresSortieDTO.getNbRehospitalisations());
        evolutionApresSortie.setFacteursDecompensation(evolutionApresSortieDTO.getFacteursDecompensation());
        evolutionApresSortie.setMois(evolutionApresSortieDTO.getMois());

        // Vérification de nullité avant conversion
        if (evolutionApresSortieDTO.getEtt() != null) {
            evolutionApresSortie.setEtt(EttDTO.convertToEntity(evolutionApresSortieDTO.getEtt()));
        }
        if (evolutionApresSortieDTO.getBiologie() != null) {
            evolutionApresSortie.setBiologie(BiologieDTO.convertToEntity(evolutionApresSortieDTO.getBiologie()));

        }
        if (evolutionApresSortieDTO.getEvolutionBebe() != null) {
            evolutionApresSortie.setEvolutionBebe(EvolutionBebeDTO.convertToEntity(evolutionApresSortieDTO.getEvolutionBebe()));
        }

        return evolutionApresSortie;
    }


}
