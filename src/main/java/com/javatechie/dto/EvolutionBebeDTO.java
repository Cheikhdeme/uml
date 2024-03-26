package com.javatechie.dto;

import com.javatechie.entity.EvolutionBebe;
import lombok.Data;

@Data
public class EvolutionBebeDTO {

    private Long id;
    private double poids;
    private String modeAlimentation;


    public static EvolutionBebe convertToEntity(EvolutionBebeDTO evolutionBebeDTO) {
        EvolutionBebe evolutionBebe = new EvolutionBebe();
        evolutionBebe.setId(evolutionBebeDTO.getId());
        evolutionBebe.setPoids(evolutionBebeDTO.getPoids());
        evolutionBebe.setModeAlimentation(evolutionBebeDTO.getModeAlimentation());
        return evolutionBebe;
    }


    public static  EvolutionBebeDTO convertToDTO(EvolutionBebe evolutionBebe) {

        EvolutionBebeDTO evolutionBebeDTO = new EvolutionBebeDTO();
        evolutionBebeDTO.setId(evolutionBebe.getId());
        evolutionBebeDTO.setPoids(evolutionBebe.getPoids());
        evolutionBebeDTO.setModeAlimentation(evolutionBebe.getModeAlimentation());
        return evolutionBebeDTO;
    }
}
