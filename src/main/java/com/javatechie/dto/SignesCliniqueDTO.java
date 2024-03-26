package com.javatechie.dto;

import com.javatechie.entity.SignesClinique;
import com.javatechie.enumeration.TypeDyspnee;
import com.javatechie.enumeration.TypeSouffle;
import lombok.Data;

@Data
public class SignesCliniqueDTO {

    private Long id;
    private boolean dyspneeEffort;
    private TypeDyspnee typeDyspnee;
    private boolean oedemePoumon;
    private boolean toux;
    private boolean palpitations;
    private boolean omi;
    private double taille;
    private double poids;
    private double temperature;
    private double IMC;
    private double TA;
    private double FC;
    private boolean souffleCardiaque;
    private TypeSouffle typeSouffle;
    private boolean TSVJ;
    private boolean hepatomegalie;

    public static SignesCliniqueDTO convertToDTO(SignesClinique signesClinique) {
        SignesCliniqueDTO signesCliniqueDTO = new SignesCliniqueDTO();
        if (signesClinique != null) {
            signesCliniqueDTO.setId(signesClinique.getId());
            signesCliniqueDTO.setDyspneeEffort(signesClinique.isDyspneeEffort());
            signesCliniqueDTO.setTypeDyspnee(signesClinique.getTypeDyspnee());
            signesCliniqueDTO.setOedemePoumon(signesClinique.isOedemePoumon());
            signesCliniqueDTO.setToux(signesClinique.isToux());
            signesCliniqueDTO.setPalpitations(signesClinique.isPalpitations());
            signesCliniqueDTO.setOmi(signesClinique.isOmi());
            signesCliniqueDTO.setTaille(signesClinique.getTaille());
            signesCliniqueDTO.setPoids(signesClinique.getPoids());
            signesCliniqueDTO.setTemperature(signesClinique.getTemperature());
            signesCliniqueDTO.setIMC(signesClinique.getIMC());
            signesCliniqueDTO.setTA(signesClinique.getTA());
            signesCliniqueDTO.setFC(signesClinique.getFC());
            signesCliniqueDTO.setSouffleCardiaque(signesClinique.isSouffleCardiaque());
            signesCliniqueDTO.setTypeSouffle(signesClinique.getTypeSouffle());
            signesCliniqueDTO.setTSVJ(signesClinique.isTSVJ());
            signesCliniqueDTO.setHepatomegalie(signesClinique.isHepatomegalie());
        }
        return signesCliniqueDTO;
    }

    public static SignesClinique convertToEntity(SignesCliniqueDTO signesCliniqueDTO) {
        SignesClinique signesClinique = new SignesClinique();
        if (signesCliniqueDTO != null) {
            signesClinique.setId(signesCliniqueDTO.getId());
            signesClinique.setDyspneeEffort(signesCliniqueDTO.isDyspneeEffort());
            signesClinique.setTypeDyspnee(signesCliniqueDTO.getTypeDyspnee());
            signesClinique.setOedemePoumon(signesCliniqueDTO.isOedemePoumon());
            signesClinique.setToux(signesCliniqueDTO.isToux());
            signesClinique.setPalpitations(signesCliniqueDTO.isPalpitations());
            signesClinique.setOmi(signesCliniqueDTO.isOmi());
            signesClinique.setTaille(signesCliniqueDTO.getTaille());
            signesClinique.setPoids(signesCliniqueDTO.getPoids());
            signesClinique.setTemperature(signesCliniqueDTO.getTemperature());
            signesClinique.setIMC(signesCliniqueDTO.getIMC());
            signesClinique.setTA(signesCliniqueDTO.getTA());
            signesClinique.setFC(signesCliniqueDTO.getFC());
            signesClinique.setSouffleCardiaque(signesCliniqueDTO.isSouffleCardiaque());
            signesClinique.setTypeSouffle(signesCliniqueDTO.getTypeSouffle());
            signesClinique.setTSVJ(signesCliniqueDTO.isTSVJ());
            signesClinique.setHepatomegalie(signesCliniqueDTO.isHepatomegalie());
        }
        return signesClinique;
    }
}
