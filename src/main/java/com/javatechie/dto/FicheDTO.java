package com.javatechie.dto;



import com.javatechie.entity.Fiche;

import lombok.Data;

import java.util.Date;


@Data
public class FicheDTO {
    private Long id;
    private String numero;
    private Date createdAt;
    private TraitementMedicalDTO traitementMedical;
    private SignesCliniqueDTO signesClinique;
    private SignesParacliniqueDTO signesParaclinique;
    private AntecedentsPersonnelDTO antecedentsPersonnel;


    public static FicheDTO convertToDTO(Fiche fiche) {
        if (fiche == null) {
            return null;
        }
        FicheDTO ficheDTO = new FicheDTO();
        ficheDTO.setId(fiche.getId());
        ficheDTO.setNumero(fiche.getNumero());
        ficheDTO.setCreatedAt(fiche.getCreatedAt());


        if (fiche.getTraitementMedical() != null) {
            ficheDTO.setTraitementMedical(TraitementMedicalDTO.convertToDTO(fiche.getTraitementMedical()));
        }

        if (fiche.getSignesClinique() != null) {
            ficheDTO.setSignesClinique(SignesCliniqueDTO.convertToDTO(fiche.getSignesClinique()));
        }


        if (fiche.getSignesParaclinique() != null) {
            ficheDTO.setSignesParaclinique(SignesParacliniqueDTO.convertToDTO(fiche.getSignesParaclinique()));
        }

        if (fiche.getAntecedentsPersonnel() != null) {
            ficheDTO.setAntecedentsPersonnel(AntecedentsPersonnelDTO.convertToDTO(fiche.getAntecedentsPersonnel()));
        }


        return ficheDTO;
    }

    public static Fiche convertToEntity(FicheDTO ficheDTO) {
        if (ficheDTO == null) {
            return null;
        }

        Fiche fiche = new Fiche();
        fiche.setId(ficheDTO.getId());
        fiche.setNumero(ficheDTO.getNumero());
        fiche.setCreatedAt(ficheDTO.getCreatedAt());



        if (ficheDTO.getTraitementMedical() != null) {
            fiche.setTraitementMedical(TraitementMedicalDTO.convertToEntity(ficheDTO.getTraitementMedical()));
        }

        if (ficheDTO.getSignesClinique() != null) {
            fiche.setSignesClinique(SignesCliniqueDTO.convertToEntity(ficheDTO.getSignesClinique()));
        }

        if (ficheDTO.getSignesParaclinique() != null) {
            fiche.setSignesParaclinique(SignesParacliniqueDTO.convertToEntity(ficheDTO.getSignesParaclinique()));
        }

        if (ficheDTO.getAntecedentsPersonnel() != null) {
            fiche.setAntecedentsPersonnel(AntecedentsPersonnelDTO.convertToEntity(ficheDTO.getAntecedentsPersonnel()));
        }

        return fiche;
    }
}
