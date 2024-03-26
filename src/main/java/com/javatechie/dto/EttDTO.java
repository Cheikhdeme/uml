package com.javatechie.dto;

import com.javatechie.entity.ETT;
import lombok.Data;

@Data
public class EttDTO {

    private Long id;
    private double DTDVG;
    private double DTSV;
    private double DTOG;
    private double FEVG;
    private double TAPSE;
    private double EoverEprime;
    private double TD;
    private double E;

    public static EttDTO convertToDTO(ETT ett) {
        EttDTO ettDTO = new EttDTO();
        ettDTO.setId(ett.getId());
        ettDTO.setDTDVG(ett.getDTDVG());
        ettDTO.setDTSV(ett.getDTSV());
        ettDTO.setDTOG(ett.getDTOG());
        ettDTO.setFEVG(ett.getFEVG());
        ettDTO.setTAPSE(ett.getTAPSE());
        ettDTO.setEoverEprime(ett.getEoverEprime());
        ettDTO.setTD(ett.getTD());
        ettDTO.setE(ett.getE());
        return ettDTO;
    }
    public static ETT convertToEntity(EttDTO ettDTO) {
        ETT ett = new ETT();
        ett.setId(ettDTO.getId());
        ett.setDTDVG(ettDTO.getDTDVG());
        ett.setDTSV(ettDTO.getDTSV());
        ett.setDTOG(ettDTO.getDTOG());
        ett.setFEVG(ettDTO.getFEVG());
        ett.setTAPSE(ettDTO.getTAPSE());
        ett.setEoverEprime(ettDTO.getEoverEprime());
        ett.setTD(ettDTO.getTD());
        ett.setE(ettDTO.getE());
        return ett;
    }


}
