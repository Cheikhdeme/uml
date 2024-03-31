package com.javatechie.service;

import com.javatechie.dto.EvolutionApresSortieDTO;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.TraitementMedical;
import com.javatechie.repository.EvolutionApresSortieRepository;
import com.javatechie.repository.TraitementMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvolutionApresSortieService {

    @Autowired
    private EvolutionApresSortieRepository evolutionApresSortieRepository;
    @Autowired
    private TraitementMedicalRepository traitementMedicalRepository;

    public EvolutionApresSortieDTO saveEvolutionApresSortie(EvolutionApresSortieDTO evolutionApresSortieDTO, Long id) {
        Optional<TraitementMedical> traitementMedicalOptional=traitementMedicalRepository.findById(id);
        if(traitementMedicalOptional.isPresent()){
            TraitementMedical traitementMedical=traitementMedicalOptional.get();
            EvolutionApresSortie evolutionApresSortie = EvolutionApresSortieDTO.convertToEntity(evolutionApresSortieDTO);
            evolutionApresSortie.setTraitementMedical(traitementMedical);
            return EvolutionApresSortieDTO.convertToDTO(evolutionApresSortieRepository.save(evolutionApresSortie));
        }
        else{
            throw new IllegalArgumentException("Traitement médicqle non trouvée avec l'ID : " + id);
        }

    }

    public List<EvolutionApresSortieDTO> getAllEvolutionApresSortieDTOs() {
        List<EvolutionApresSortie> evolutionApresSortieList = evolutionApresSortieRepository.findAll();
        return evolutionApresSortieList.stream()
                .map(EvolutionApresSortieDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EvolutionApresSortieDTO> getEvolutionApresSortieDTOById(Long id) {
        return evolutionApresSortieRepository.findById(id)
                .map(EvolutionApresSortieDTO::convertToDTO);
    }

    public EvolutionApresSortieDTO updateEvolutionApresSortie(Long id, EvolutionApresSortieDTO evolutionApresSortieDTO) {
        EvolutionApresSortie evolutionApresSortie = EvolutionApresSortieDTO.convertToEntity(evolutionApresSortieDTO);
        evolutionApresSortie.setId(id);
        TraitementMedical traitementMedical=traitementMedicalRepository.findTraitementMedicalByEvolutionApresSorties(evolutionApresSortie);
        evolutionApresSortie.setTraitementMedical(traitementMedical);
        return EvolutionApresSortieDTO.convertToDTO(evolutionApresSortieRepository.save(evolutionApresSortie));
    }

    public void deleteEvolutionApresSortie(Long id) {
        evolutionApresSortieRepository.deleteById(id);
    }
}
