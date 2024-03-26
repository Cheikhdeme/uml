package com.javatechie.service;
import com.javatechie.dto.AntecedentsPersonnelDTO;
import com.javatechie.entity.AntecedentsPersonnel;
import com.javatechie.entity.Fiche;
import com.javatechie.repository.AntecedentsPersonnelRepository;
import com.javatechie.repository.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AntecedentsPersonnelService {

    @Autowired
    private AntecedentsPersonnelRepository antecedentsPersonnelRepository;
    @Autowired
    FicheRepository ficheRepository;

    public AntecedentsPersonnelDTO saveAntecedentsPersonnel(AntecedentsPersonnelDTO antecedentsPersonnelDTO,Long ficheId) {
        Optional<Fiche> ficheOptional = ficheRepository.findById(ficheId);
        if (ficheOptional.isPresent()) {
            Fiche fiche = ficheOptional.get();
            AntecedentsPersonnel antecedentsPersonnel = AntecedentsPersonnelDTO.convertToEntity(antecedentsPersonnelDTO);
            antecedentsPersonnel.setFiche(fiche);
            return AntecedentsPersonnelDTO.convertToDTO(antecedentsPersonnelRepository.save(antecedentsPersonnel));
        }
        else {
            throw new IllegalArgumentException("Fiche non trouvée avec l'ID : " + ficheId);
        }

    }

    public List<AntecedentsPersonnelDTO> getAllAntecedentsPersonnelDTOs() {
        List<AntecedentsPersonnel> antecedentsPersonnelList = antecedentsPersonnelRepository.findAll();
        return antecedentsPersonnelList.stream()
                .map(AntecedentsPersonnelDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AntecedentsPersonnelDTO> getAntecedentsPersonnelById(Long id) {
        return antecedentsPersonnelRepository.findById(id)
                .map(AntecedentsPersonnelDTO::convertToDTO);
    }

    public void deleteAntecedentsPersonnel(Long id) {
        antecedentsPersonnelRepository.deleteById(id);
    }
}

