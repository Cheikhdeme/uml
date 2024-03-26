package com.javatechie.dto;

import com.javatechie.entity.Biologie;
import lombok.Data;

@Data
public class BiologieDTO {
    private Long id;
    private double hemoglobinemie;
    private double GB;
    private double plaquettes;
    private double VGM;
    private double CCMH;
    private double TCMH;
    private double DTOC;
    private double CRP;
    private double uree;
    private double creatininemie;
    private double NTproBNP;
    private double prolactine;
    private double NFS;
    private double FEVG;

    public  static BiologieDTO convertToDTO(Biologie biologie) {
        BiologieDTO biologieDTO = new BiologieDTO();
        biologieDTO.setId(biologie.getId());
        biologieDTO.setHemoglobinemie(biologie.getHemoglobinemie());
        biologieDTO.setGB(biologie.getGB());
        biologieDTO.setPlaquettes(biologie.getPlaquettes());
        biologieDTO.setVGM(biologie.getVGM());
        biologieDTO.setCCMH(biologie.getCCMH());
        biologieDTO.setTCMH(biologie.getTCMH());
        biologieDTO.setDTOC(biologie.getDTOC());
        biologieDTO.setCRP(biologie.getCRP());
        biologieDTO.setUree(biologie.getUree());
        biologieDTO.setCreatininemie(biologie.getCreatininemie());
        biologieDTO.setNTproBNP(biologie.getNTproBNP());
        biologieDTO.setProlactine(biologie.getProlactine());
        biologieDTO.setNFS(biologie.getNFS());
        biologieDTO.setFEVG(biologie.getFEVG());
        return biologieDTO;
    }

    public static Biologie convertToEntity(BiologieDTO biologieDTO) {
        Biologie biologie = new Biologie();
        biologie.setId(biologieDTO.getId());
        biologie.setHemoglobinemie(biologieDTO.getHemoglobinemie());
        biologie.setGB(biologieDTO.getGB());
        biologie.setPlaquettes(biologieDTO.getPlaquettes());
        biologie.setVGM(biologieDTO.getVGM());
        biologie.setCCMH(biologieDTO.getCCMH());
        biologie.setTCMH(biologieDTO.getTCMH());
        biologie.setDTOC(biologieDTO.getDTOC());
        biologie.setCRP(biologieDTO.getCRP());
        biologie.setUree(biologieDTO.getUree());
        biologie.setCreatininemie(biologieDTO.getCreatininemie());
        biologie.setNTproBNP(biologieDTO.getNTproBNP());
        biologie.setProlactine(biologieDTO.getProlactine());
        biologie.setNFS(biologieDTO.getNFS());
        biologie.setFEVG(biologieDTO.getFEVG());
        return biologie;
    }
}
