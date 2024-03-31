package com.javatechie.service;

import com.javatechie.dto.EvolutionBebeDTO;
import com.javatechie.entity.EvolutionApresSortie;
import com.javatechie.entity.EvolutionBebe;
import com.javatechie.repository.EvolutionApresSortieRepository;
import com.javatechie.repository.EvolutionBebeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvolutionBebeService {

    @Autowired
    private EvolutionBebeRepository evolutionBebeRepository;
    @Autowired
    private EvolutionApresSortieRepository evolutionApresSortieRepository;

    public EvolutionBebeDTO saveEvolutionBebe(EvolutionBebeDTO evolutionBebeDTO,Long id) {
        Optional<EvolutionApresSortie> evolutionApresSortieOptional=evolutionApresSortieRepository.findById(id);
        if (evolutionApresSortieOptional.isPresent()){
            EvolutionApresSortie evolutionApresSortie=evolutionApresSortieOptional.get();
            EvolutionBebe evolutionBebe = EvolutionBebeDTO.convertToEntity(evolutionBebeDTO);
            evolutionBebe.setEvolutionApresSortie(evolutionApresSortie);
            return EvolutionBebeDTO.convertToDTO((EvolutionBebe) evolutionBebeRepository.save(evolutionBebe));
        }else {
            throw new IllegalArgumentException ("evolution apres sortie non trouvé par "+ id);
        }

    }

    public List<EvolutionBebeDTO> getAllEvolutionBebeDTOs() {
        List<EvolutionBebe> evolutionBebeList = evolutionBebeRepository.findAll();
        return evolutionBebeList.stream()
                .map(EvolutionBebeDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EvolutionBebeDTO> getEvolutionBebeDTOById(Long id) {
        Optional<EvolutionBebe> evolutionBebeOptional = evolutionBebeRepository.findById(id);
        return evolutionBebeOptional.map(EvolutionBebeDTO::convertToDTO);
    }

    public EvolutionBebeDTO updateEvolutionBebe(Long id, EvolutionBebeDTO evolutionBebeDTO) {
        EvolutionBebe evolutionBebe = EvolutionBebeDTO.convertToEntity(evolutionBebeDTO);
        evolutionBebe.setId(id);
        EvolutionApresSortie evolutionApresSortie=evolutionApresSortieRepository.findEvolutionApresSortieByEvolutionBebe(evolutionBebe);
        evolutionBebe.setEvolutionApresSortie(evolutionApresSortie);
        return EvolutionBebeDTO.convertToDTO((EvolutionBebe) evolutionBebeRepository.save(evolutionBebe));
    }

    public void deleteEvolutionBebe(Long id) {
        evolutionBebeRepository.deleteById(id);
    }
}
