package com.javatechie.dto;

import com.javatechie.entity.ResultatsBiologique;
import lombok.Data;

import java.util.List;

@Data
public class ResultatsBiologiqueDTO {

    private Long id;
    private boolean sinusal;
    private boolean tachycardie;
    private boolean troublesConductifs;
    private boolean HAG;
    private boolean HVG;
    private boolean HAD;
    private boolean HVD;
    private boolean FA;
    private List<String> autres;

    public static ResultatsBiologiqueDTO convertToDTO(ResultatsBiologique resultatsBiologique) {
        ResultatsBiologiqueDTO resultatsBiologiqueDTO = new ResultatsBiologiqueDTO();
        resultatsBiologiqueDTO.setId(resultatsBiologique.getId());
        resultatsBiologiqueDTO.setSinusal(resultatsBiologique.isSinusal());
        resultatsBiologiqueDTO.setTachycardie(resultatsBiologique.isTachycardie());
        resultatsBiologiqueDTO.setTroublesConductifs(resultatsBiologique.isTroublesConductifs());
        resultatsBiologiqueDTO.setHAG(resultatsBiologique.isHAG());
        resultatsBiologiqueDTO.setHVG(resultatsBiologique.isHVG());
        resultatsBiologiqueDTO.setHAD(resultatsBiologique.isHAD());
        resultatsBiologiqueDTO.setHVD(resultatsBiologique.isHVD());
        resultatsBiologiqueDTO.setFA(resultatsBiologique.isFA());
        resultatsBiologiqueDTO.setAutres(resultatsBiologique.getAutres());
        return resultatsBiologiqueDTO;
    }

    public static ResultatsBiologique convertToEntity(ResultatsBiologiqueDTO resultatsBiologiqueDTO) {
        ResultatsBiologique resultatsBiologique = new ResultatsBiologique();
        resultatsBiologique.setId(resultatsBiologiqueDTO.getId());
        resultatsBiologique.setSinusal(resultatsBiologiqueDTO.isSinusal());
        resultatsBiologique.setTachycardie(resultatsBiologiqueDTO.isTachycardie());
        resultatsBiologique.setTroublesConductifs(resultatsBiologiqueDTO.isTroublesConductifs());
        resultatsBiologique.setHAG(resultatsBiologiqueDTO.isHAG());
        resultatsBiologique.setHVG(resultatsBiologiqueDTO.isHVG());
        resultatsBiologique.setHAD(resultatsBiologiqueDTO.isHAD());
        resultatsBiologique.setHVD(resultatsBiologiqueDTO.isHVD());
        resultatsBiologique.setFA(resultatsBiologiqueDTO.isFA());
        resultatsBiologique.setAutres(resultatsBiologiqueDTO.getAutres());
        return resultatsBiologique;
    }
}
