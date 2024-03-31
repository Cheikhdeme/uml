package com.javatechie.dto;


import com.javatechie.entity.SignesParaclinique;
import com.javatechie.enumeration.FuiteValvulaire;
import com.javatechie.enumeration.StenoseValvulaire;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
public class SignesParacliniqueDTO {

    private Long id;
    private boolean telecoeur;
    private double indexCardiothoracique;
    private List <String> autreSignes;
    private boolean ECG;
    private boolean epanchementPericardique;
    private FuiteValvulaire fuiteValvulaire;
    private StenoseValvulaire stenoseValvulaire;
    private ResultatsBiologiqueDTO resultatsBiologique;
    private EttDTO ett;
    private BiologieDTO biologie;

    public static SignesParacliniqueDTO convertToDTO(SignesParaclinique signesParaclinique) {
        SignesParacliniqueDTO signesParacliniqueDTO = new SignesParacliniqueDTO();
        signesParacliniqueDTO.setId(signesParaclinique.getId());
        signesParacliniqueDTO.setTelecoeur(signesParaclinique.isTelecoeur());
        signesParacliniqueDTO.setIndexCardiothoracique(signesParaclinique.getIndexCardiothoracique());
        signesParacliniqueDTO.setAutreSignes(signesParaclinique.getAutreSignes());
        signesParacliniqueDTO.setECG(signesParaclinique.isECG());
        signesParacliniqueDTO.setEpanchementPericardique(signesParaclinique.isEpanchementPericardique());
        signesParacliniqueDTO.setFuiteValvulaire(signesParaclinique.getFuiteValvulaire());
        signesParacliniqueDTO.setStenoseValvulaire(signesParaclinique.getStenoseValvulaire());

        if (signesParaclinique.getResultatsBiologique() != null) {
            signesParacliniqueDTO.setResultatsBiologique(ResultatsBiologiqueDTO.convertToDTO(signesParaclinique.getResultatsBiologique()));
        }
        if (signesParaclinique.getEtt() != null) {
            signesParacliniqueDTO.setEtt(EttDTO.convertToDTO(signesParaclinique.getEtt()));
        }
        if (signesParaclinique.getBiologie() != null) {
            signesParacliniqueDTO.setBiologie(BiologieDTO.convertToDTO(signesParaclinique.getBiologie()));
        }

        return signesParacliniqueDTO;
    }

    public static SignesParaclinique convertToEntity(SignesParacliniqueDTO signesParacliniqueDTO) {
        SignesParaclinique signesParaclinique = new SignesParaclinique();
        signesParaclinique.setId(signesParacliniqueDTO.getId());
        signesParaclinique.setTelecoeur(signesParacliniqueDTO.isTelecoeur());
        signesParaclinique.setIndexCardiothoracique(signesParacliniqueDTO.getIndexCardiothoracique());
        signesParaclinique.setAutreSignes(signesParacliniqueDTO.getAutreSignes());
        signesParaclinique.setECG(signesParacliniqueDTO.isECG());
        signesParaclinique.setEpanchementPericardique(signesParacliniqueDTO.isEpanchementPericardique());
        signesParaclinique.setFuiteValvulaire(signesParacliniqueDTO.getFuiteValvulaire());
        signesParaclinique.setStenoseValvulaire(signesParacliniqueDTO.getStenoseValvulaire());

        if (signesParacliniqueDTO.getResultatsBiologique() != null) {
            signesParaclinique.setResultatsBiologique(ResultatsBiologiqueDTO.convertToEntity(signesParacliniqueDTO.getResultatsBiologique()));
        }
        if (signesParacliniqueDTO.getEtt() != null) {
            signesParaclinique.setEtt(EttDTO.convertToEntity(signesParacliniqueDTO.getEtt()));
        }
        if (signesParacliniqueDTO.getBiologie() != null) {
            signesParaclinique.setBiologie(BiologieDTO.convertToEntity(signesParacliniqueDTO.getBiologie()));
        }

        return signesParaclinique;
    }
}
