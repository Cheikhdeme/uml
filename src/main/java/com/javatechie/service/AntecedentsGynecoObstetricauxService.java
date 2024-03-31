package com.javatechie.service;

import com.javatechie.dto.AntecedentsGynecoObstetricauxDTO;
import com.javatechie.entity.AntecedentsGynecoObstetricaux;
import com.javatechie.entity.AntecedentsPersonnel;
import com.javatechie.repository.AntecedentsGynecoObstetricauxRepository;
import com.javatechie.repository.AntecedentsPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AntecedentsGynecoObstetricauxService {

    @Autowired
    private AntecedentsGynecoObstetricauxRepository antecedentsGynecoObstetricauxRepository;
    @Autowired
    private AntecedentsPersonnelRepository antecedentsPersonnelRepository;

    public AntecedentsGynecoObstetricauxDTO saveAntecedentsGynecoObstetricaux(AntecedentsGynecoObstetricauxDTO dto,Long id) {
        Optional<AntecedentsPersonnel> antecedentsPersonnelOptional=antecedentsPersonnelRepository.findById(id);
        if (antecedentsPersonnelOptional.isPresent()){
            AntecedentsPersonnel antecedentsPersonnel=antecedentsPersonnelOptional.get();
            AntecedentsGynecoObstetricaux antecedentsGynecoObstetricaux = AntecedentsGynecoObstetricauxDTO.convertToEntity(dto);
            antecedentsGynecoObstetricaux.setAntecedentsPersonnel(antecedentsPersonnel);
            return AntecedentsGynecoObstetricauxDTO.convertToDTO(antecedentsGynecoObstetricauxRepository.save(antecedentsGynecoObstetricaux));
        }
       else {
           throw  new IllegalArgumentException("antécédents personnels non trouvé par id "+id);
        }
    }

    public List<AntecedentsGynecoObstetricauxDTO> getAllAntecedentsGynecoObstetricaux() {
        List<AntecedentsGynecoObstetricaux> antecedentsGynecoObstetricauxList = antecedentsGynecoObstetricauxRepository.findAll();
        return antecedentsGynecoObstetricauxList.stream()
                .map(AntecedentsGynecoObstetricauxDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AntecedentsGynecoObstetricauxDTO> getAntecedentsGynecoObstetricauxById(Long id) {
        return antecedentsGynecoObstetricauxRepository.findById(id)
                .map(AntecedentsGynecoObstetricauxDTO::convertToDTO);
    }

    public AntecedentsGynecoObstetricauxDTO updateAntecedentsGynecoObstetricaux(Long id, AntecedentsGynecoObstetricauxDTO dto) {
        AntecedentsGynecoObstetricaux antecedentsGynecoObstetricaux = AntecedentsGynecoObstetricauxDTO.convertToEntity(dto);
        antecedentsGynecoObstetricaux.setId(id);
        AntecedentsPersonnel antecedentsPersonnel=antecedentsPersonnelRepository.findAntecedentsPersonnelByAntecedentsGynecoObstetricaux(antecedentsGynecoObstetricaux);
        antecedentsGynecoObstetricaux.setAntecedentsPersonnel(antecedentsPersonnel);
        return AntecedentsGynecoObstetricauxDTO.convertToDTO(antecedentsGynecoObstetricauxRepository.save(antecedentsGynecoObstetricaux));
    }

    public void deleteAntecedentsGynecoObstetricaux(Long id) {
        antecedentsGynecoObstetricauxRepository.deleteById(id);
    }
}
