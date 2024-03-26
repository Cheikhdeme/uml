package com.javatechie.service;

import com.javatechie.dto.FicheDTO;
import com.javatechie.dto.TraitementMedicalDTO;
import com.javatechie.entity.Fiche;
import com.javatechie.entity.TraitementMedical;
import com.javatechie.repository.FicheRepository;
import com.javatechie.repository.TraitementMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraitementMedicalService {

    @Autowired
    private TraitementMedicalRepository traitementMedicalRepository;
    @Autowired
    private FicheRepository ficheRepository ;

    public TraitementMedicalDTO saveTraitementMedical(TraitementMedicalDTO traitementMedicalDTO, Long ficheId) {
        Optional<Fiche> ficheOptional = ficheRepository.findById(ficheId);
        if (ficheOptional.isPresent()) {
            Fiche fiche = ficheOptional.get();
            TraitementMedical traitementMedical = TraitementMedicalDTO.convertToEntity(traitementMedicalDTO);
            traitementMedical.setFiche(fiche);
            return TraitementMedicalDTO.convertToDTO(traitementMedicalRepository.save(traitementMedical));
        } else {
            throw new IllegalArgumentException("Fiche non trouvée avec l'ID : " + ficheId);
        }
    }


    public List<TraitementMedicalDTO> getAllTraitementMedicalDTOs() {
        List<TraitementMedical> traitementMedicalList = traitementMedicalRepository.findAll();
        return traitementMedicalList.stream()
                .map(TraitementMedicalDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TraitementMedicalDTO> getTraitementMedicalDTOById(Long id) {
        return traitementMedicalRepository.findById(id)
                .map(TraitementMedicalDTO::convertToDTO);
    }

    public TraitementMedicalDTO updateTraitementMedical(Long id, TraitementMedicalDTO traitementMedicalDTO) {
        TraitementMedical traitementMedical = TraitementMedicalDTO.convertToEntity(traitementMedicalDTO);
        traitementMedical.setId(id);
        return TraitementMedicalDTO.convertToDTO(traitementMedicalRepository.save(traitementMedical));
    }

    public void deleteTraitementMedical(Long id) {
        traitementMedicalRepository.deleteById(id);
    }
}
