package com.javatechie.service;

import com.javatechie.dto.BebeDTO;
import com.javatechie.entity.Bebe;
import com.javatechie.entity.TraitementMedical;
import com.javatechie.repository.BebeRepository;
import com.javatechie.repository.TraitementMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BebeService {

    @Autowired
    private BebeRepository bebeRepository;
    @Autowired
    private TraitementMedicalRepository traitementMedicalRepository;

    public BebeDTO saveBebe(BebeDTO bebeDTO,Long id) {
        Optional<TraitementMedical> traitementMedicalOptional=traitementMedicalRepository.findById(id);
        if(traitementMedicalOptional.isPresent()) {
            TraitementMedical traitementMedical = traitementMedicalOptional.get();
            Bebe bebe = BebeDTO.convertToEntity(bebeDTO);
            bebe.setTraitementMedical(traitementMedical);
            return BebeDTO.convertToDTO(bebeRepository.save(bebe));
        }
        else{
            throw new IllegalArgumentException("Traitement médicqle non trouvée avec l'ID : " + id);
        }

    }


    public List<BebeDTO> getBebes() {
        List<Bebe> bebes = bebeRepository.findAll();
        return bebes.stream()
                .map(BebeDTO::convertToDTO)
                .collect(Collectors.toList());
    }
    public Optional<BebeDTO> getBebeById(Long id) {
        return bebeRepository.findById(id)
                .map(BebeDTO::convertToDTO);
    }

    public BebeDTO updateBebe(Long id, BebeDTO bebeDTO) {
        Bebe bebe = BebeDTO.convertToEntity(bebeDTO);
        bebe.setId(id);
        TraitementMedical traitementMedical=traitementMedicalRepository.findTraitementMedicalByBebe(bebe);
        bebe.setTraitementMedical(traitementMedical);
        return BebeDTO.convertToDTO(bebeRepository.save(bebe));
    }

    public void deleteBebe(Long id) {
        bebeRepository.deleteById(id);
    }


}
