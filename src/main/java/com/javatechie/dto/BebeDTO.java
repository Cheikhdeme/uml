package com.javatechie.dto;

import com.javatechie.entity.Bebe;
import lombok.Data;

@Data
public class BebeDTO {
    private Long id;
    private boolean mortNe;
    private boolean premature;
    private double poidsNaissance;

    public static BebeDTO convertToDTO(Bebe bebe) {
        BebeDTO bebeDTO = new BebeDTO();
        bebeDTO.setId(bebe.getId());
        bebeDTO.setMortNe(bebe.isMortNe());
        bebeDTO.setPremature(bebe.isPremature());
        bebeDTO.setPoidsNaissance(bebe.getPoidsNaissance());
        return bebeDTO;
    }

    public static Bebe convertToEntity(BebeDTO bebeDTO) {
        Bebe bebe = new Bebe();
        bebe.setId(bebeDTO.getId());
        bebe.setMortNe(bebeDTO.isMortNe());
        bebe.setPremature(bebeDTO.isPremature());
        bebe.setPoidsNaissance(bebeDTO.getPoidsNaissance());
        return bebe;
    }
}
